import os
import json
import logging
from uuid import uuid4
from flask import Flask, request, jsonify

# Configuração básica de logging
logging.basicConfig(
    level=logging.INFO, format="%(asctime)s [pagamentos] %(levelname)s: %(message)s"
)

# Diretório base e arquivo de dados (persistência simples em JSON)
BASE_DIR = os.path.dirname(os.path.abspath(__file__))
DATA_DIR = os.path.join(BASE_DIR, "data")
os.makedirs(DATA_DIR, exist_ok=True)
PAGAMENTOS_FILE = os.path.join(DATA_DIR, "pagamentos.json")

# Garantir que o arquivo exista e contenha uma lista JSON inicial
if not os.path.exists(PAGAMENTOS_FILE):
    with open(PAGAMENTOS_FILE, "w", encoding="utf-8") as f:
        json.dump([], f, indent=2, ensure_ascii=False)


def load_pagamentos():
    """
    Carrega e retorna a lista de pagamentos do arquivo JSON.

    Returns:
        list: lista de pagamentos (cada pagamento é um dict).
    """
    with open(PAGAMENTOS_FILE, "r", encoding="utf-8") as f:
        return json.load(f)


def save_pagamentos(items):
    """
    Persiste a lista de pagamentos no arquivo JSON.

    Args:
        items (list): lista de pagamentos a salvar.
    """
    with open(PAGAMENTOS_FILE, "w", encoding="utf-8") as f:
        json.dump(items, f, indent=2, ensure_ascii=False)


app = Flask(__name__)


@app.post("/pagamentos")
def aprovar():
    """
    Endpoint para aprovar um novo pagamento.

    Returns:
        201 com {'pagamentoId', 'status'} em caso de sucesso.
        400 em caso de payload inválido ou simulação de recusa (valor >= 1000).
    """
    # Forçar parse do corpo como JSON
    body = request.get_json(force=True, silent=False) or {}
    logging.info(f"POST /pagamentos - recebido: {body}")

    # Validação simples dos campos obrigatórios
    required = ["pedidoId", "produtoId", "valor"]
    if any(k not in body for k in required):
        return jsonify({"detail": "Payload inválido"}), 400

    # Simulação de recusa para valores altos
    valor = float(body["valor"])
    if valor >= 1000:
        logging.error("Pagamento recusado (simulação): valor >= 1000")
        return jsonify({"detail": "Pagamento recusado (simulação: valor >= 1000)"}), 400

    # Construrir o pagamento aprovado
    pagamento = {
        "pagamentoId": str(uuid4()),
        "pedidoId": str(body["pedidoId"]),
        "produtoId": str(body["produtoId"]),
        "valor": valor,
        "status": "APROVADO",
    }

    # Persistir o pagamento
    data = load_pagamentos()
    data.append(pagamento)
    save_pagamentos(data)

    logging.info(f"Pagamento APROVADO: {pagamento['pagamentoId']}")
    return jsonify({"pagamentoId": pagamento["pagamentoId"], "status": "APROVADO"}), 201


@app.post("/pagamentos/<pagamento_id>/reembolso")
def reembolsar(pagamento_id):
    """
    Endpoint para reembolsar um pagamento existente.

    Args:
        pagamento_id (str): identificador do pagamento na URL.

    Returns:
        200 com {'pagamentoId', 'status'} em caso de sucesso.
        404 se o pagamento não for encontrado.
    """
    # Forçar parse do corpo como JSON
    body = request.get_json(force=True, silent=False) or {}
    logging.info(f"POST /pagamentos/{pagamento_id}/reembolso - recebido: {body}")

    # Localizar o pagamento e atualizar o status para REEMBOLSADO
    data = load_pagamentos()
    for p in data:
        if p["pagamentoId"] == pagamento_id:
            if p["status"] == "REEMBOLSADO":
                logging.info(f"Pagamento {pagamento_id} já estava REEMBOLSADO")
                return jsonify({"pagamentoId": pagamento_id, "status": "REEMBOLSADO"})

            # Atualizar status
            p["status"] = "REEMBOLSADO"
            save_pagamentos(data)
            logging.info(f"Pagamento {pagamento_id} reembolsado")

            return jsonify({"pagamentoId": pagamento_id, "status": "REEMBOLSADO"})

    # Pagamento não encontrado
    logging.error(f"Pagamento {pagamento_id} não encontrado")
    return jsonify({"detail": "Pagamento não encontrado"}), 404


@app.get("/pagamentos")
def listar():
    """
    Endpoint para listar todos os pagamentos persistidos.

    Returns:
        JSON com a lista de pagamentos.
    """
    return jsonify(load_pagamentos())


if __name__ == "__main__":
    # Execução local para desenvolvimento
    # debug=True ativa reload e mostra erros
    app.run(host="0.0.0.0", port=8002, debug=True)
