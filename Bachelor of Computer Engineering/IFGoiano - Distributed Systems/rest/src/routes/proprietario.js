const express = require('express')
const router = express.Router()
const log = require('./middlewares/log')
const proprietarioController = require('../controllers/proprietario')

router.get('/proprietarios', log, (req, res) => {
  proprietarioController.getAll(req, res)
})

router.get('/proprietarios/:id', log, (req, res) => {
  proprietarioController.getById(req, res)
})

router.post('/proprietarios', log, (req, res) => {
  proprietarioController.insert(req, res)
})

router.put('/proprietarios/:id', log, (req, res) => {
  proprietarioController.update(req, res)
})

router.delete('/proprietarios/:id', log, (req, res) => {
  proprietarioController.remove(req, res)
})

module.exports = router
