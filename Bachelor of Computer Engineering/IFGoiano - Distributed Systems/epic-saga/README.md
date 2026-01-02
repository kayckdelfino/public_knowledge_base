# Simulando Epic Saga (sao)

Este projeto implementa um conjunto de microserviços em Flask/Python para simular o padrão **Epic Saga (sao)**.
A operação envolve quatro serviços independentes:

- **Orquestrador** (coordena toda a saga)
- **Pedidos** (criação e cancelamento)
- **Pagamentos** (aprovação e reembolso)
- **Estoque** (reserva e liberação)

O objetivo é coordenar transações distribuídas com compensações em caso de falha, garantindo consistência do estado final.

---

# Requisitos

- Python **3.10+**
- pip

---

# Instalação

```bash
# dentro da pasta do projeto:
python -m venv .venv

# Linux/Mac:
source .venv/bin/activate

# Windows (PowerShell):
.venv\Scripts\Activate.ps1

pip install -r requirements.txt
```

---

# Execução dos Serviços

Abra **quatro terminais**, um para cada microserviço:

```bash
# Orquestrador (porta 8000)
python src/servico-orquestrador/main.py

# Pedidos (porta 8001)
python src/servico-pedidos/main.py

# Pagamentos (porta 8002)
python src/servico-pagamentos/main.py

# Estoque (porta 8003)
python src/servico-estoque/main.py
```

Cada serviço roda em sua própria porta e é completamente independente.

---

# Testando o Orquestrador

### Endpoint principal

```
POST /processar-pedido
```

A seguir, os **bodies JSON** que devem ser enviados ao orquestrador para simular:

* **sucesso**
* **falhas em pedidos**
* **falhas em pagamentos**
* **falhas em estoque**

---

## Fluxo de Sucesso

```json
{
  "clienteId": "cliente-123",
  "produtoId": "produto-abc",
  "quantidade": 1,
  "valor": 150.00
}
```

Fluxo executado:

1. Criação do pedido (PENDENTE)
2. Pagamento aprovado
3. Estoque reservado
4. Pedido confirmado

Resultado final esperado:
`{"pedidoId": "...", "status": "PEDIDO_CONFIRMADO"}`

---

## Falhas Simuladas

### 1) Falha no Serviço de **Pedidos**

Simulada quando `produtoId = "0"`:

```json
{
  "clienteId": "cliente-123",
  "produtoId": "0",
  "quantidade": 1,
  "valor": 150.00
}
```

Resultado esperado:

* pedido **não é criado**
* saga falha imediatamente
* nenhuma compensação é acionada

---

### 2) Falha no Serviço de **Pagamentos**

Simulada quando `valor >= 1000`:

```json
{
  "clienteId": "cliente-123",
  "produtoId": "produto-abc",
  "quantidade": 1,
  "valor": 1000.00
}
```

Resultado:

* pedido criado (PENDENTE)
* pagamento recusado
* orquestrador **compensa cancelando o pedido**

---

### 3) Falha no Serviço de **Estoque**

Simulada quando `quantidade >= 500`:

```json
{
  "clienteId": "cliente-123",
  "produtoId": "produto-abc",
  "quantidade": 500,
  "valor": 150.00
}
```

Resultado:

* pedido criado (PENDENTE)
* pagamento aprovado
* reserva de estoque falha
* compensação:

  * reembolso do pagamento
  * cancelamento do pedido

---

# Armazenamento e Reset

Cada microserviço persiste seus dados em um arquivo dentro da pasta `data/`:

* `src/servico-orquestrador/data/orquestrador.json` - histórico de execuções da saga
* `src/servico-pedidos/data/pedidos.json` - lista de pedidos
* `src/servico-pagamentos/data/pagamentos.json` - pagamentos aprovados/reembolsados
* `src/servico-estoque/data/estoque.json` - inventário de produtos

Para **resetar o estado do sistema**, basta apagar os arquivos `.json`.
Eles são recriados automaticamente na próxima execução.

---

# Logs

Todos os serviços registram:

* Payloads recebidos
* Ações executadas
* Erros simulados
* Compensações
* Estado final da operação

O orquestrador mantém um log completo da saga no arquivo `orquestrador.json`.
