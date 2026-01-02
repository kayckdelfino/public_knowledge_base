import os
import json
import logging
from flask import Flask, request, jsonify

# Configuração básica de logging
logging.basicConfig(
    level=logging.INFO, format="%(asctime)s [estoque] %(levelname)s: %(message)s"
)

# Diretório base e arquivo de dados (persistência simples em JSON)
BASE_DIR = os.path.dirname(os.path.abspath(__file__))
DATA_DIR = os.path.join(BASE_DIR, "data")
os.makedirs(DATA_DIR, exist_ok=True)
ESTOQUE_FILE = os.path.join(DATA_DIR, "estoque.json")

# Garantir que o arquivo exista e contenha um dicionário JSON inicial
if not os.path.exists(ESTOQUE_FILE):
    with open(ESTOQUE_FILE, "w", encoding="utf-8") as f:
        json.dump({"produto-abc": 100}, f, indent=2, ensure_ascii=False)


def load_estoque():
    """
    Carrega e retorna o dicionário do estoque a partir do arquivo JSON.

    Returns:
        dict: mapeamento produtoId -> quantidade disponível
    """
    with open(ESTOQUE_FILE, "r", encoding="utf-8") as f:
        return json.load(f)


def save_estoque(items):
    """
    Persiste o dicionário de estoque no arquivo JSON.

    Args:
        items (dict): mapeamento produtoId -> quantidade disponível
    """
    with open(ESTOQUE_FILE, "w", encoding="utf-8") as f:
        json.dump(items, f, indent=2, ensure_ascii=False)


app = Flask(__name__)


@app.post("/estoque/reserva")
def reservar():
    """
    Endpoint para reservar (diminuir) quantidade de um produto no estoque.

    Returns:
        200 com {'produtoId', 'estoque_restante'} em caso de sucesso.
        400 em caso de payload inválido, estoque insuficiente ou simulação de falha (quantidade >= 500).
    """
    # Forçar parse do corpo como JSON
    body = request.get_json(force=True, silent=False) or {}
    logging.info(f"POST /estoque/reserva - recebido: {body}")

    # Validação simples dos campos obrigatórios
    required = ["pedidoId", "produtoId", "quantidade"]
    if any(k not in body for k in required):
        return jsonify({"detail": "Payload inválido"}), 400

    produto_id = str(body["produtoId"])
    qtd = int(body["quantidade"])

    # Simulação de falha para quantidades altas
    if qtd >= 500:
        logging.error("Falha simulada no estoque: quantidade >= 500")
        return jsonify(
            {"detail": "Falha no estoque (simulação: quantidade >= 500)"}
        ), 400

    # Verifica se há estoque suficiente
    estoque = load_estoque()
    atual = int(estoque.get(produto_id, 0))
    if qtd > atual:
        logging.error(
            f"Estoque insuficiente: {produto_id} atual={atual}, solicitada={qtd}"
        )
        return jsonify({"detail": "Estoque insuficiente"}), 400

    # Atualiza e persiste o estoque
    estoque[produto_id] = atual - qtd
    save_estoque(estoque)

    logging.info(f"Reservado {qtd} de {produto_id}. Restante: {estoque[produto_id]}")
    return jsonify({"produtoId": produto_id, "estoque_restante": estoque[produto_id]})


@app.post("/estoque/liberacao")
def liberar():
    """
    Endpoint para liberar (aumentar) quantidade de um produto no estoque.

    Returns:
        200 com {'produtoId', 'estoque_restante'} em caso de sucesso.
        400 em caso de payload inválido.
    """
    # Forçar parse do corpo como JSON
    body = request.get_json(force=True, silent=False) or {}
    logging.info(f"POST /estoque/liberacao - recebido: {body}")

    # Validação simples dos campos obrigatórios
    required = ["pedidoId", "produtoId", "quantidade"]
    if any(k not in body for k in required):
        return jsonify({"detail": "Payload inválido"}), 400

    produto_id = str(body["produtoId"])
    qtd = int(body["quantidade"])

    # Carrega o estoque atual
    estoque = load_estoque()
    atual = int(estoque.get(produto_id, 0))

    # Incrementa e persiste o estoque
    estoque[produto_id] = atual + qtd
    save_estoque(estoque)

    logging.info(f"Liberado {qtd} de {produto_id}. Restante: {estoque[produto_id]}")
    return jsonify({"produtoId": produto_id, "estoque_restante": estoque[produto_id]})


@app.get("/estoque")
def ver():
    """
    Endpoint para ver o estado atual do estoque.

    Returns:
        JSON com o dicionário completo do estoque.
    """
    return jsonify(load_estoque())


if __name__ == "__main__":
    # Execução local para desenvolvimento
    # debug=True ativa reload e mostra erros
    app.run(host="0.0.0.0", port=8003, debug=True)
