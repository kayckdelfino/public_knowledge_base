const express = require('express')
const router = express.Router()

const imoveis = require('../controllers/imoveis')

router.get('/', (req, res) => {
  imoveis.index(req, res)
})

router.get('/imoveis/search', (req, res) => {
  imoveis.search(req, res)
})

router.post('/imoveis/search', (req, res) => {
  imoveis.search(req, res)
})

module.exports = router