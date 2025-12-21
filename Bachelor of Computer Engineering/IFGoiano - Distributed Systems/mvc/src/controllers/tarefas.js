const { getAll, create, toggleStatus, remove } = require("../models/tarefas")

function index(req, res) {
  // Exibe todas as tarefas
  const tarefas = getAll()
  res.render('tarefas/index', { tarefas: tarefas })
}

function salvar(req, res) {
  // Salva uma nova tarefa, se o título for válido
  const { titulo } = req.body
  if (titulo && titulo.trim() !== '') {
    create(titulo.trim())
  }
  const tarefas = getAll()
  res.render('tarefas/index', { tarefas: tarefas })
}

function excluir(req, res) {
  // Exclui uma tarefa pelo ID, se válido
  const id = parseInt(req.params.id)
  if (!isNaN(id)) {
    try {
      remove(id)
    } catch (err) {
      console.error('Erro ao excluir:', err.message)
    }
  }
  const tarefas = getAll()
  res.render('tarefas/index', { tarefas: tarefas })
}

function alternarStatus(req, res) {
  // Alterna o status de uma tarefa pelo ID, se válido
  const id = parseInt(req.params.id)
  if (!isNaN(id)) {
    try {
      toggleStatus(id)
    } catch (err) {
      console.error('Erro ao alternar status:', err.message)
    }
  }
  const tarefas = getAll()
  res.render('tarefas/index', { tarefas: tarefas })
}

module.exports = {
  alternarStatus,
  excluir,
  index,
  salvar
}
