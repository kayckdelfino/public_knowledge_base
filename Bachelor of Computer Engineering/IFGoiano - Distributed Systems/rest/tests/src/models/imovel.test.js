const fs = require('fs')
const imovelModel = require('../../../src/models/imovel')
const { createImovel } = require('../../factories/imovel')

const path = './data/imoveisModelTest.json'

jest.mock('../../../src/models/paths', () => {
  return {
    IMOVEL: path
  }
})

describe('testes para models/imovel', () => {

  beforeEach(() => {
    const data = { imoveis: [] }
    fs.writeFileSync(path, JSON.stringify(data))
  })

  afterEach(() => {
    fs.unlinkSync(path)
  })

  describe('getAll', () => {

    test('retorna nenhum registro', () => {
      const imoveis = imovelModel.getAll()

      expect(imoveis.length).toEqual(0)

      expect(imoveis).toEqual([])
    })

    test('retorna todos os registros', () => {
      imovelModel.insert(createImovel({ rua: 'rua 001' }))
      imovelModel.insert(createImovel({ rua: 'rua 002' }))

      const imoveis = imovelModel.getAll()

      expect(imoveis.length).toEqual(2)

      expect(imoveis).toEqual(
        [
          expect.objectContaining({ id: 1, rua: 'rua 001' }),
          expect.objectContaining({ id: 2, rua: 'rua 002' })
        ]
      )
    })

  })

  describe('getById', () => {

    test('retorna um elemento existente', () => {
      imovelModel.insert(createImovel({ id: 1, rua: 'rua 001' }))

      const imovel = imovelModel.getById(1)

      expect(imovel).toEqual(
        expect.objectContaining({ id: 1, rua: 'rua 001' })
      )
    })

    test('retorna undefined para um elemento inexistente', () => {
      imovelModel.insert(createImovel({ id: 1, rua: 'rua 001' }))

      const imovel = imovelModel.getById(10)

      expect(imovel).toBeUndefined()
    })

  })

  describe('remove', () => {

    test('remove um elemento existente', () => {
      imovelModel.insert(createImovel({ id: 1, rua: 'rua 001' }))

      const isRemovido = imovelModel.remove(1)
      expect(isRemovido).toEqual(true)

      const imovel = imovelModel.getById(1)
      expect(imovel).toBeUndefined()

    })

    test('não remove um elemento inexistente', () => {
      imovelModel.insert(createImovel({ id: 1, rua: 'rua 001' }))

      const isRemovido = imovelModel.remove(10)
      expect(isRemovido).toEqual(false)

      const imoveis = imovelModel.getAll()
      expect(imoveis.length).toEqual(1)
    })

  })

  describe('insert', () => {

    test('insere um novo registro', () => {
      let imovel = {
        rua: 'rua 01',
        cidade: 'trindade',
        estado: 'GO',
        numero: '123',
        tipo: 'apartamento'
      }

      imovel = imovelModel.insert(imovel)
      const imoveis = imovelModel.getById(imovel.id)

      expect(imovel).toEqual({
        id: imovel.id,
        rua: 'rua 01',
        cidade: 'trindade',
        estado: 'GO',
        numero: '123',
        tipo: 'apartamento'
      })
    })

  })

  describe('update', () => {

    test('atualiza um único campo de um registro existente', () => {
      imovelModel.insert(createImovel({
        rua: 'rua 01',
        cidade: 'trindade',
        estado: 'GO',
        numero: '123',
        tipo: 'apartamento'
      }))

      let imovel = {
        id: 1,
        rua: 'rua 666'
      }

      imovel = imovelModel.update(imovel)

      expect(imovel).toEqual({
        id: 1,
        rua: 'rua 666',
        cidade: 'trindade',
        estado: 'GO',
        numero: '123',
        tipo: 'apartamento'
      })

      const imovelGravado = imovelModel.getById(1)

      expect(imovelGravado).toEqual({
        id: 1,
        rua: 'rua 666',
        cidade: 'trindade',
        estado: 'GO',
        numero: '123',
        tipo: 'apartamento'
      })
    })

    test('atualiza um registro existente', () => {
      imovelModel.insert(createImovel({
        rua: 'rua 01',
        cidade: 'trindade',
        estado: 'GO',
        numero: '123',
        tipo: 'apartamento'
      }))

      let imovel = {
        id: 1,
        rua: 'rua 666',
        cidade: 'Brasília',
        estado: 'DF',
        numero: '321',
        tipo: 'casa'
      }

      imovel = imovelModel.update(imovel)

      expect(imovel).toEqual({
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

    test('não atualiza um registro inexistente', () => {
      imovelModel.insert(createImovel({
        rua: 'rua 01',
        cidade: 'trindade',
        estado: 'GO',
        numero: '123',
        tipo: 'apartamento'
      }))

      let imovel = {
        id: 1000,
        rua: 'rua 666'
      }

      imovel = imovelModel.update(imovel)

      expect(imovel).toBeUndefined()

      const imoveis = imovelModel.getAll()

      expect(imoveis).toEqual([
        {
          id: 1,
          rua: 'rua 01',
          cidade: 'trindade',
          estado: 'GO',
          numero: '123',
          tipo: 'apartamento'
        }])
    })

  })

})