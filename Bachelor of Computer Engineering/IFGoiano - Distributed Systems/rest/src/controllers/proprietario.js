const proprietarioModel = require('../models/proprietario')
const proprietarioSchema = require('../models/schemas/proprietario')
const Ajv = require('ajv')
const ajv = new Ajv()

module.exports = {
  getAll,
  getById,
  insert,
  update,
  remove
}

function getAll(_req, res) {
  res.json(proprietarioModel.getAll())
}

function getById(req, res) {
  const id = req.params.id
  const proprietario = proprietarioModel.getById(id)
  if (proprietario) {
    res.json(proprietario)
  } else {
    res.sendStatus(404)
  }
}

function insert(req, res) {
  let proprietario = req.body
  if (ajv.validate(proprietarioSchema, proprietario)) {
    proprietario = proprietarioModel.insert(proprietario)
    res.json(proprietario)
  } else {
    res.status(400).json({ errors: ajv.errors })
  }
}

function update(req, res) {
  let proprietario = req.body
  proprietario.id = Number.parseInt(req.params.id)
  if (ajv.validate(proprietarioSchema, proprietario)) {
    if (proprietarioModel.update(proprietario)) {
      res.json(proprietario)
    } else {
      res.status(404).json({ errors: ['Registro não encontrado'] })
    }
  } else {
    res.status(400).json({ errors: ajv.errors })
  }
}

function remove(req, res) {
  const id = req.params.id
  if (proprietarioModel.remove(id)) {
    res.sendStatus(200)
  } else {
    res.status(404).json({ errors: ['Registro não encontrado'] })
  }
}
