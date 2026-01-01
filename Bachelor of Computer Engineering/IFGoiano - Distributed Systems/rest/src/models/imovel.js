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
  if (fs.existsSync(paths.IMOVEL)) {
    const { imoveis = [] } = JSON.parse(fs.readFileSync(paths.IMOVEL, 'utf-8'))
    return imoveis
  } else {
    return []
  }
}

function saveFile(imoveis) {
  const data = JSON.stringify({ imoveis: imoveis })
  fs.writeFileSync(paths.IMOVEL, data)
}

function getAll() {
  return loadFile()
}

function getById(id) {
  const imoveis = getAll()
  return imoveis.find((imovel) => imovel.id == id)
}

function insert(imovel) {
  const imoveis = getAll()
  imovel.id = getNextId()
  if (!imovel.proprietarios) imovel.proprietarios = []
  imoveis.push(imovel)
  saveFile(imoveis)
  return imovel
}

function update(imovel) {
  const imoveis = getAll()
  const idx = imoveis.findIndex((item) => item.id == imovel.id)
  if (idx < 0) {
    return undefined
  }
  imovelAtualizado = {
    ...imoveis[idx],
    ...imovel,
    proprietarios: imovel.proprietarios ?? imoveis[idx].proprietarios ?? []
  }
  imoveis[idx] = imovelAtualizado
  saveFile(imoveis)
  return imovelAtualizado
}

function getNextId() {
  const imoveis = getAll()

  let nextId = imoveis
    .reduce((maior, imovel) => {
      if (imovel.id > maior) {
        return imovel.id
      } else {
        return maior
      }
    }, 0)

  nextId++

  return nextId
}

function remove(id) {
  let imoveis = getAll()
  const tamanhoAnterior = imoveis.length

  imoveis = imoveis.filter((imovel) => imovel.id != id)
  saveFile(imoveis)

  return tamanhoAnterior != imoveis.length
}
