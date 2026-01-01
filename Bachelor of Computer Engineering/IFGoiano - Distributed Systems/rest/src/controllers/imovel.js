const imovelModel = require('../models/imovel')
const imovelSchema = require('../models/schemas/imovel')
const proprietarioModel = require('../models/proprietario')
const Ajv = require("ajv")
const ajv = new Ajv()

module.exports = {
  getAll,
  getById,
  remove,
  insert,
  update,
  associateProprietario,
  dissociateProprietario
}

function getAll(_req, res) {
  const imoveis = imovelModel.getAll()
  res.json(imoveis)
}

function getById(req, res) {
  const id = req.params.id
  const imovel = imovelModel.getById(id)
  if (imovel) {
    res.json(imovel)
  } else {
    res.sendStatus(404)
  }
}

function remove(req, res) {
  const id = req.params.id
  if (imovelModel.remove(id)) {
    res.sendStatus(200)
  } else {
    res.status(404).json({ errors: ['Registro não encontrado'] })
  }
}

function insert(req, res) {
  let imovel = req.body
  if (ajv.validate(imovelSchema, imovel)) {
    imovel = imovelModel.insert(imovel)
    res.json(imovel)
  } else {
    res.status(500).json({ errors: ajv.errors })
  }
}

function update(req, res) {
  let imovel = req.body
  const id = Number.parseInt(req.params.id)
  imovel.id = id
  if (ajv.validate(imovelSchema, imovel)) {
    if (imovelModel.update(imovel)) {
      res.json(imovel)
    } else {
      res.status(404).json({ errors: ['Registro não encontrado'] })
    }
  } else {
    res.status(500).json({ errors: ajv.errors })
  }
}

function associateProprietario(req, res) {
  const imovelId = Number(req.params.imovelId)
  const proprietarioId = Number(req.params.proprietarioId)
  const imovel = imovelModel.getById(imovelId)
  const proprietario = proprietarioModel.getById(proprietarioId)
  if (!imovel || !proprietario) {
    return res.status(404).json({ errors: ['Imóvel ou proprietário não encontrado'] })
  }
  // Atualiza imóvel
  if (!imovel.proprietarios) imovel.proprietarios = []
  if (!imovel.proprietarios.includes(proprietarioId)) {
    imovel.proprietarios.push(proprietarioId)
    imovelModel.update(imovel)
  }
  // Atualiza proprietário
  if (!proprietario.imoveis) proprietario.imoveis = []
  if (!proprietario.imoveis.includes(imovelId)) {
    proprietario.imoveis.push(imovelId)
    proprietarioModel.update(proprietario)
  }
  res.json(imovel)
}

function dissociateProprietario(req, res) {
  const imovelId = Number(req.params.imovelId)
  const proprietarioId = Number(req.params.proprietarioId)
  const imovel = imovelModel.getById(imovelId)
  const proprietario = proprietarioModel.getById(proprietarioId)
  if (!imovel) {
    return res.status(404).json({ errors: ['Imóvel não encontrado'] })
  }
  // Remove proprietário do imóvel
  imovel.proprietarios = (imovel.proprietarios || []).filter(id => id !== proprietarioId)
  imovelModel.update(imovel)
  // Remove imóvel do proprietário
  if (proprietario) {
    proprietario.imoveis = (proprietario.imoveis || []).filter(id => id !== imovelId)
    proprietarioModel.update(proprietario)
  }
  res.json(imovel)
}
