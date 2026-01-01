const fs = require('fs')
const paths = require('./paths')

module.exports = {
  getAll,
  getById,
  insert,
  update,
  remove
}

function loadFile() {
  if (fs.existsSync(paths.PROPRIETARIO)) {
    const { proprietarios = [] } = JSON.parse(fs.readFileSync(paths.PROPRIETARIO, 'utf-8'))
    return proprietarios
  } else {
    return []
  }
}

function saveFile(proprietarios) {
  const data = JSON.stringify({ proprietarios: proprietarios })
  fs.writeFileSync(paths.PROPRIETARIO, data)
}

function getAll() {
  return loadFile()
}

function getById(id) {
  return getAll().find((p) => p.id == id)
}

function insert(proprietario) {
  const proprietarios = getAll()
  proprietario.id = getNextId()
  if (!proprietario.imoveis) proprietario.imoveis = []
  proprietarios.push(proprietario)
  saveFile(proprietarios)
  return proprietario
}

function update(proprietario) {
  const proprietarios = getAll()
  const idx = proprietarios.findIndex((p) => p.id == proprietario.id)
  if (idx < 0) return undefined
  proprietarios[idx] = {
    ...proprietarios[idx],
    ...proprietario,
    imoveis: proprietario.imoveis ?? proprietarios[idx].imoveis ?? []
  }
  saveFile(proprietarios)
  return proprietarios[idx]
}

function remove(id) {
  let proprietarios = getAll()
  const tamanhoAnterior = proprietarios.length
  proprietarios = proprietarios.filter((p) => p.id != id)
  saveFile(proprietarios)
  return tamanhoAnterior != proprietarios.length
}

function getNextId() {
  const proprietarios = getAll()
  let nextId = proprietarios.reduce((maior, p) => p.id > maior ? p.id : maior, 0)
  return nextId + 1
}
