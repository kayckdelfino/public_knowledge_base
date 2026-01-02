import logging
import requests
import os
import json
from datetime import datetime
from flask import Flask, request, jsonify

logging.basicConfig(
    level=logging.INFO, format="%(asctime)s [orquestrador] %(levelname)s: %(message)s"
)

app = Flask(__name__)

# Diretório base e arquivo de dados (persistência simples em JSON)
BASE_DIR = os.path.dirname(os.path.abspath(__file__))
DATA_DIR = os.path.join(BASE_DIR, "data")
os.makedirs(DATA_DIR, exist_ok=True)
ORQ_FILE = os.path.join(DATA_DIR, "orquestrador.json")

# Garantir que o arquivo exista e contenha um dicionário JSON inicial
if not os.path.exists(ORQ_FILE):
    with open(ORQ_FILE, "w", encoding="utf-8") as f:
        json.dump({"sagas": []}, f, indent=2, ensure_ascii=False)

# URLs dos microserviços
PEDIDOS_URL = "http://localhost:8001/pedidos"
PAGAMENTOS_URL = "http://localhost:8002/pagamentos"
ESTOQUE_URL = "http://localhost:8003/estoque"


def safe_json(res):
    try:
        return res.json()
    except Exception:
        return {"raw": res.text}


def salvar_saga_log(entry: dict):
    """Salva uma entrada de execução da saga no arquivo orquestrador.json."""
    try:
        with open(ORQ_FILE, "r", encoding="utf-8") as f:
            data = json.load(f)

        data["sagas"].append(entry)

        with open(ORQ_FILE, "w", encoding="utf-8") as f:
            json.dump(data, f, indent=2, ensure_ascii=False)

    except Exception as e:
        logging.error(f"Erro ao registrar saga no arquivo: {e}")


def compensar_pagamento(pagamento_id):
    """Reembolsa um pagamento já aprovado."""
    logging.info(f"Compensando pagamento {pagamento_id}...")
    try:
        requests.post(f"{PAGAMENTOS_URL}/{pagamento_id}/reembolso", json={})
    except Exception as e:
        logging.error(f"Falha ao compensar pagamento: {e}")


def compensar_pedido(pedido_id):
    """Altera o status do pedido para CANCELADO."""
    logging.info(f"Compensando pedido {pedido_id}...")
    try:
        requests.put(f"{PEDIDOS_URL}/{pedido_id}/status", json={"status": "CANCELADO"})
    except Exception as e:
        logging.error(f"Falha ao compensar pedido: {e}")


def compensar_estoque(pedido_id, produto_id, quantidade):
    """Libera estoque já debitado."""
    logging.info(f"Compensando estoque para pedido {pedido_id}...")
    try:
        requests.post(
            f"{ESTOQUE_URL}/liberacao",
            json={
                "pedidoId": pedido_id,
                "produtoId": produto_id,
                "quantidade": quantidade,
            },
        )
    except Exception as e:
        logging.error(f"Falha ao compensar estoque: {e}")


@app.post("/processar-pedido")
def fechar_pedido():
    """
    Fluxo completo:
    1. Criar pedido
    2. Aprovar pagamento
    3. Reservar estoque
    4. Confirmar pedido
    Em falha: executar compensações.
    """
    body = request.get_json(force=True) or {}
    logging.info(f"Recebido pedido de fechamento: {body}")

    required = ["clienteId", "produtoId", "quantidade", "valor"]
    if any(k not in body for k in required):
        return jsonify({"detail": "Payload inválido"}), 400

    cliente_id = body["clienteId"]
    produto_id = body["produtoId"]
    quantidade = body["quantidade"]
    valor = body["valor"]

    pedido_id = None
    pagamento_id = None
    estoque_reservado = False

    try:
        # 1) Criar pedido (PENDENTE)
        logging.info("Criando pedido...")
        res = requests.post(PEDIDOS_URL, json=body)

        if res.status_code != 201:
            logging.error("Falha ao criar pedido")
            salvar_saga_log(
                {
                    "timestamp": datetime.now().isoformat(),
                    "status": "FALHA_CRIAR_PEDIDO",
                    "motivo": safe_json(res),
                }
            )
            return jsonify(
                {"erro": "A saga falhou", "motivo": safe_json(res), "pedidoId": None}
            ), 500

        pedido_id = safe_json(res)["pedidoId"]

        # 2) Aprovar pagamento (pode falhar)
        logging.info("Aprovando pagamento...")
        res = requests.post(
            PAGAMENTOS_URL,
            json={"pedidoId": pedido_id, "produtoId": produto_id, "valor": valor},
        )

        if res.status_code != 201:
            # Até aqui só o pedido foi criado -> cancela pedido
            logging.error("Falha no pagamento, iniciando compensação...")
            compensar_pedido(pedido_id)

            salvar_saga_log(
                {
                    "timestamp": datetime.now().isoformat(),
                    "status": "FALHA_PAGAMENTO",
                    "pedidoId": pedido_id,
                    "motivo": safe_json(res),
                }
            )

            return jsonify(
                {
                    "erro": "A saga falhou",
                    "motivo": safe_json(res),
                    "pedidoId": pedido_id,
                }
            ), 500

        pagamento_id = safe_json(res)["pagamentoId"]

        # 3) Reservar estoque (pode falhar)
        logging.info("Reservando estoque...")
        res = requests.post(
            f"{ESTOQUE_URL}/reserva",
            json={
                "pedidoId": pedido_id,
                "produtoId": produto_id,
                "quantidade": quantidade,
            },
        )

        if res.status_code != 200:
            # Até aqui: pagamento aprovado e pedido criado -> estorna pagamento, depois cancela pedido
            logging.error("Falha no estoque! Iniciando compensações...")
            compensar_pagamento(pagamento_id)
            compensar_pedido(pedido_id)

            salvar_saga_log(
                {
                    "timestamp": datetime.now().isoformat(),
                    "status": "FALHA_ESTOQUE",
                    "pedidoId": pedido_id,
                    "pagamentoId": pagamento_id,
                    "motivo": safe_json(res),
                }
            )

            return jsonify(
                {
                    "erro": "A saga falhou",
                    "motivo": safe_json(res),
                    "pedidoId": pedido_id,
                }
            ), 500

        # Reserva ocorreu com sucesso -> habilita liberação em eventual compensação
        estoque_reservado = True

        # 4) Confirmar pedido (se falhar, dispara compensações)
        logging.info("Confirmando pedido...")
        res_conf = requests.put(
            f"{PEDIDOS_URL}/{pedido_id}/status", json={"status": "CONFIRMADO"}
        )
        if res_conf.status_code != 200:
            # Agora a ordem inversa completa: estoque (reservado) -> pagamento -> pedido
            logging.error("Falha ao confirmar pedido! Iniciando compensações...")
            compensar_estoque(pedido_id, produto_id, quantidade)
            compensar_pagamento(pagamento_id)
            compensar_pedido(pedido_id)

            salvar_saga_log(
                {
                    "timestamp": datetime.now().isoformat(),
                    "status": "FALHA_CONFIRMAR_PEDIDO",
                    "pedidoId": pedido_id,
                    "pagamentoId": pagamento_id,
                    "motivo": safe_json(res_conf),
                }
            )

            return jsonify(
                {
                    "erro": "A saga falhou",
                    "motivo": safe_json(res_conf),
                    "pedidoId": pedido_id,
                }
            ), 500

        logging.info(f"Pedido {pedido_id} FINALIZADO com sucesso!")

        salvar_saga_log(
            {
                "timestamp": datetime.now().isoformat(),
                "status": "PEDIDO_CONFIRMADO",
                "pedidoId": pedido_id,
                "pagamentoId": pagamento_id,
                "clienteId": cliente_id,
                "produtoId": produto_id,
                "quantidade": quantidade,
            }
        )

        return jsonify({"pedidoId": pedido_id, "status": "PEDIDO_CONFIRMADO"}), 201

    except Exception as e:
        logging.error(f"Erro inesperado: {e}")

        # COMPENSAÇÕES em ordem inversa do caminho feliz
        try:
            if estoque_reservado:
                compensar_estoque(pedido_id, produto_id, quantidade)
            if pagamento_id:
                compensar_pagamento(pagamento_id)
            if pedido_id:
                compensar_pedido(pedido_id)
        finally:
            salvar_saga_log(
                {
                    "timestamp": datetime.now().isoformat(),
                    "status": "ERRO_INTERNO",
                    "erro": str(e),
                    "pedidoId": pedido_id,
                    "pagamentoId": pagamento_id,
                }
            )

        return jsonify(
            {
                "erro": "A saga falhou",
                "motivo": "Erro interno na orquestração",
                "pedidoId": pedido_id,
            }
        ), 500


if __name__ == "__main__":
    app.run(host="0.0.0.0", port=8000, debug=True)
