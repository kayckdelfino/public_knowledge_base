module.exports = {
  type: 'object',
  properties: {
    id: { type: 'integer' },
    nome: { type: 'string' },
    cpf: { type: 'string' },
    email: { type: 'string' },
    imoveis: { type: 'array', items: { type: 'integer' }, default: [] }
  },
  required: ['nome', 'cpf', 'email'],
  additionalProperties: false
}
