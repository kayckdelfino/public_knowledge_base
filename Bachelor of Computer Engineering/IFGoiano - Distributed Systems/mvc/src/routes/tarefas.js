const express = require('express')
const router = express.Router()

const tarefas = require('../controllers/tarefas')

router.get('/tarefas', (req, res) => {
  tarefas.index(req, res)
})

router.post('/tarefas', (req, res) => {
  tarefas.salvar(req, res)
})

router.get('/tarefas/:id/excluir', (req, res) => {
  tarefas.excluir(req, res)
})

router.get('/tarefas/:id/alternar-status', (req, res) => {
  tarefas.alternarStatus(req, res)
})

module.exports = router