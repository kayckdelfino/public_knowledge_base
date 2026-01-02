import os
import json
import logging
from uuid import uuid4
from flask import Flask, request, jsonify

# Configuração básica de logging
logging.basicConfig(
    level=logging.INFO, format="%(asctime)s [pedidos] %(levelname)s: %(message)s"
)

# Diretório base e arquivo de dados (persistência simples em JSON)
BASE_DIR = os.path.dirname(os.path.abspath(__file__))
DATA_DIR = os.path.join(BASE_DIR, "data")
os.makedirs(DATA_DIR, exist_ok=True)
PEDIDOS_FILE = os.path.join(DATA_DIR, "pedidos.json")

# Garantir que o arquivo exista e contenha uma lista JSON inicial
if not os.path.exists(PEDIDOS_FILE):
    with open(PEDIDOS_FILE, "w", encoding="utf-8") as f:
        json.dump([], f, indent=2, ensure_ascii=False)


def load_pedidos():
    """
    Carrega e retorna a lista de pedidos do arquivo JSON.

    Returns:
        list: lista de pedidos (cada pedido é um dict).
    """
    with open(PEDIDOS_FILE, "r", encoding="utf-8") as f:
        return json.load(f)


def save_pedidos(items):
    """
    Persiste a lista de pedidos no arquivo JSON.

    Args:
        items (list): lista de pedidos a salvar.
    """
    with open(PEDIDOS_FILE, "w", encoding="utf-8") as f:
        json.dump(items, f, indent=2, ensure_ascii=False)


app = Flask(__name__)


@app.post("/pedidos")
def criar_pedido():
    """
    Endpoint para criar um novo pedido.

    Returns:
        201 com {'pedidoId', 'status'} em caso de sucesso.
        400 em caso de payload inválido ou simulação de falha (produtoId == "0").
    """
    # Forçar parse do corpo como JSON
    body = request.get_json(force=True, silent=False) or {}
    logging.info(f"POST /pedidos - recebido: {body}")

    # Validação simples dos campos obrigatórios
    required = ["clienteId", "produtoId", "quantidade", "valor"]
    if any(k not in body for k in required):
        return jsonify({"detail": "Payload inválido"}), 400

    # Simulação de falha se produtoId for "0"
    if str(body.get("produtoId")) == "0":
        logging.error("Falha simulada: produtoId == 0")
        return jsonify(
            {"detail": "Simulação de falha no serviço de pedidos (produtoId == 0)"}
        ), 400

    # Construir o pedido
    pedido = {
        "pedidoId": str(uuid4()),
        "clienteId": str(body["clienteId"]),
        "produtoId": str(body["produtoId"]),
        "quantidade": int(body["quantidade"]),
        "valor": float(body["valor"]),
        "status": "PENDENTE",
    }

    # Persistir o pedido
    data = load_pedidos()
    data.append(pedido)
    save_pedidos(data)

    logging.info(f"Pedido criado: {pedido['pedidoId']} com status PENDENTE")
    return jsonify({"pedidoId": pedido["pedidoId"], "status": "PENDENTE"}), 201


@app.put("/pedidos/<pedido_id>/status")
def atualizar_status(pedido_id):
    """
    Atualiza o status de um pedido existente.

    Args:
        pedido_id (str): identificador do pedido na URL.

    Returns:
        200 com {'pedidoId', 'status'} em caso de sucesso.
        400 se o status informado for inválido.
        404 se o pedido não for encontrado.
    """
    # Forçar parse do corpo como JSON
    body = request.get_json(force=True, silent=False) or {}
    logging.info(f"PUT /pedidos/{pedido_id}/status - recebido: {body}")

    # Validação do novo status
    status_novo = body.get("status")
    if status_novo not in ("CONFIRMADO", "CANCELADO"):
        return jsonify({"detail": "status deve ser CONFIRMADO ou CANCELADO"}), 400

    # Carregar pedidos e buscar o pedido a ser atualizado
    data = load_pedidos()
    for p in data:
        # Encontrou o pedido: atualizar e salvar
        if p["pedidoId"] == pedido_id:
            p["status"] = status_novo
            save_pedidos(data)
            logging.info(f"Pedido {pedido_id} atualizado para {status_novo}")
            return jsonify({"pedidoId": pedido_id, "status": status_novo})

    # Pedido não encontrado: retornar 404
    logging.error(f"Pedido {pedido_id} não encontrado")
    return jsonify({"detail": "Pedido não encontrado"}), 404


@app.get("/pedidos")
def listar():
    """
    Endpoint para listar todos os pedidos.

    Returns:
        JSON com a lista completa de pedidos.
    """
    return jsonify(load_pedidos())


if __name__ == "__main__":
    # Execução local para desenvolvimento
    # debug=True ativa reload e mostra erros
    app.run(host="0.0.0.0", port=8001, debug=True)
