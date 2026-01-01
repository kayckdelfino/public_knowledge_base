const express = require('express')
const imoveis = require('./src/routes/imovel')
const proprietarios = require('./src/routes/proprietario')

const app = express()

app.use(express.json())
app.use(express.urlencoded({ extended: true }))


app.use(imoveis)
app.use(proprietarios)

module.exports = app
