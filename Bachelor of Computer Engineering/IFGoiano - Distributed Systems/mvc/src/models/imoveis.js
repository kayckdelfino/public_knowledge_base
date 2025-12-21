const fs = require('fs')

function getAll() {
  const { imoveis } = JSON.parse(fs.readFileSync('./data/imoveis.json', 'utf8'))
  return imoveis
}

function getLastImoveis() {
  const imoveis = getAll()
  return imoveis.slice(0, 5)
}

function getByTipo(valor) {
  const imoveis = getAll()
  valor = valor.trim()
  return imoveis.filter(({ tipo }) => tipo == valor)
}

module.exports = {
  getLastImoveis,
  getByTipo
}