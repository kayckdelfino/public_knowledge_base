const fs = require('fs')
const path = './data/tarefas.json'

// Lê todas as tarefas do arquivo JSON
function getAll() {
  const { tarefas } = JSON.parse(fs.readFileSync(path, 'utf8'))
  return tarefas
}

// Salva a lista de tarefas no arquivo JSON
function saveAll(tarefas) {
  fs.writeFileSync(path, JSON.stringify({ tarefas }, null, 2))
}

// Cria uma nova tarefa e salva na lista
function create(titulo) {
  const tarefas = getAll()
  // Gera um novo ID incremental
  const novaTarefa = {
    id: tarefas.length > 0 ? tarefas[tarefas.length - 1].id + 1 : 1,
    titulo,
    concluida: false
  }
  tarefas.push(novaTarefa)
  saveAll(tarefas)
  return novaTarefa
}

// Alterna o status de conclusão de uma tarefa pelo ID
function toggleStatus(id) {
  const tarefas = getAll()
  const index = tarefas.findIndex(t => t.id === id)
  if (index === -1) throw new Error('Tarefa não encontrada')

  tarefas[index].concluida = !tarefas[index].concluida
  saveAll(tarefas)
  return tarefas[index]
}

// Remove uma tarefa pelo ID
function remove(id) {
  const tarefas = getAll()
  const novaLista = tarefas.filter(t => t.id !== id)
  if (novaLista.length === tarefas.length) throw new Error('Tarefa não encontrada')

  saveAll(novaLista)
}

module.exports = {
  getAll,
  create,
  toggleStatus,
  remove
}
