const express = require('express')
const imoveis = require('./src/routes/imoveis')
const tarefas = require('./src/routes/tarefas')

const app = express()

app.set('view engine', 'ejs')
app.set('views', './src/views')

app.use(express.json())
app.use(express.urlencoded())

app.use(imoveis)
app.use(tarefas)

app.use(express.static(__dirname + '/public'))

app.listen(3000, () => {
  console.log('Aplicação executando na porta 3000')
})