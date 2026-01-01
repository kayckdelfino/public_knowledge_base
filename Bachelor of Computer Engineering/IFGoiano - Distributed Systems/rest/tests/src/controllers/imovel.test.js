const fs = require('fs')
const request = require('supertest')
const app = require('../../../app')
const { createImovel } = require('../../factories/imovel')
const imovelModel = require('../../../src/models/imovel')

const path = './data/imoveisControllerTest.json'

jest.mock('../../../src/models/paths', () => {
  return {
    IMOVEL: path
  }
})

describe('testes para controllers/imovel', () => {

  beforeEach(() => {
    const data = { imoveis: [] }
    fs.writeFileSync(path, JSON.stringify(data))
  })

  afterEach(() => {
    if (fs.existsSync(path)) {
      fs.unlinkSync(path)
    }
  })

  describe('GET /imoveis', () => {

    test('obter todos os imóveis', async () => {
      imovelModel.insert(createImovel({ rua: 'rua 01' }))
      imovelModel.insert(createImovel({ rua: 'rua 02' }))

      const response = await request(app).get('/imoveis')

      expect(response.statusCode).toEqual(200)

      expect(response.body).toEqual([
        expect.objectContaining({ rua: 'rua 01' }),
        expect.objectContaining({ rua: 'rua 02' })
      ])
    })

    test('obter uma lista vazia de imóveis', async () => {
      fs.unlinkSync(path)

      const response = await request(app).get('/imoveis')

      expect(response.statusCode).toEqual(200)
      expect(response.body).toEqual([])
    })

  })

  describe('GET /imoveis/:id', () => {

    test('retorna um imóvel existente', async () => {
      imovelModel.insert(createImovel({ rua: 'rua 01' }))
      imovelModel.insert(createImovel({ rua: 'rua 02' }))

      const response = await request(app).get('/imoveis/2')

      expect(response.statusCode).toEqual(200)

      expect(response.body).toEqual(
        expect.objectContaining({ id: 2, rua: 'rua 02' }))
    })

    test('não retorna um imóvel inexistente', async () => {
      fs.unlinkSync(path)

      const response = await request(app).get('/imoveis/2')

      expect(response.statusCode).toEqual(404)
      expect(response.body).toEqual({})
    })

  })

  describe('DELETE /imoveis/:id', () => {

    test('remove um imóvel existente', async () => {
      imovelModel.insert(createImovel({ rua: 'rua 01' }))
      imovelModel.insert(createImovel({ rua: 'rua 02' }))

      const response = await request(app).delete('/imoveis/2')
      expect(response.statusCode).toEqual(200)

      const imovel = imovelModel.getById(2)
      expect(imovel).toBeUndefined()
    })

    test('não remove um imóvel inexistente', async () => {
      const response = await request(app).delete('/imoveis/2')

      expect(response.statusCode).toEqual(404)

      expect(response.body).toEqual({
        errors: ['Registro não encontrado']
      })
    })

  })

  describe('POST /imoveis', () => {

    test('insere um novo imóvel', async () => {
      const imovel = {
        rua: 'rua 01',
        cidade: 'trindade',
        estado: 'GO',
        numero: '123',
        tipo: 'apartamento'
      }

      const response = await request(app)
        .post('/imoveis')
        .send(imovel)

      expect(response.statusCode).toEqual(200)

      expect(response.body).toEqual({
        id: 1,
        rua: 'rua 01',
        cidade: 'trindade',
        estado: 'GO',
        numero: '123',
        tipo: 'apartamento'
      })

      const imoveis = imovelModel.getAll()

      expect(imoveis).toEqual([
        {
          id: 1,
          rua: 'rua 01',
          cidade: 'trindade',
          estado: 'GO',
          numero: '123',
          tipo: 'apartamento'
        }
      ])
    })

    test('não insere um imóvel porque a entrada de dados é inválida', async () => {
      const imovel = {
        cidade: 'trindade',
        estado: 'GO',
        numero: '123'
      }

      const response = await request(app)
        .post('/imoveis')
        .send(imovel)

      expect(response.statusCode).toEqual(500)

      expect(response.body).toEqual({
        errors: [
          {
            instancePath: '',
            keyword: 'required',
            message: 'must have required property \'rua\'',
            params: {
              missingProperty: 'rua',
            },
            schemaPath: '#/required',
          },
        ]
      })
    })

  })

  describe('PUT /imoveis', () => {

    test('altera um registro existente', async () => {
      imovelModel.insert(createImovel({
        rua: 'rua 01',
        cidade: 'trindade',
        estado: 'GO',
        numero: '123',
        tipo: 'apartamento'
      }))

      const imovel = {
        rua: 'rua 666',
        cidade: 'Brasília',
        estado: 'DF',
        numero: '321',
        tipo: 'casa'
      }

      const response = await request(app)
        .put('/imoveis/1')
        .send(imovel)

      expect(response.statusCode).toEqual(200)

      expect(response.body).toEqual({
        id: 1,
        rua: 'rua 666',
        cidade: 'Brasília',
        estado: 'DF',
        numero: '321',
        tipo: 'casa'
      })

      const imovelGravado = imovelModel.getById(1)

      expect(imovelGravado).toEqual({
        id: 1,
        rua: 'rua 666',
        cidade: 'Brasília',
        estado: 'DF',
        numero: '321',
        tipo: 'casa'
      })
    })

    test('não altera um registro inexistente', async () => {
      const imovel = {
        rua: 'rua 666',
        cidade: 'Brasília',
        estado: 'DF',
        numero: '321',
        tipo: 'casa'
      }

      const response = await request(app)
        .put('/imoveis/1')
        .send(imovel)

      expect(response.statusCode).toEqual(404)

      expect(response.body).toEqual({
        errors: ['Registro não encontrado']
      })
    })

    test('não altera um imóvel porque a entrada de dados é inválida', async () => {
      const imovel = {
        cidade: 'trindade',
        estado: 'GO',
        numero: '123'
      }

      const response = await request(app)
        .put('/imoveis/1')
        .send(imovel)

      expect(response.statusCode).toEqual(500)

      expect(response.body).toEqual({
        errors: [
          {
            instancePath: '',
            keyword: 'required',
            message: 'must have required property \'rua\'',
            params: {
              missingProperty: 'rua',
            },
            schemaPath: '#/required',
          },
        ]
      })
    })

  })

})