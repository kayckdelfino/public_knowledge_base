const { pt_BR, Faker } = require('@faker-js/faker');

module.exports = {
  createImovel
}

const faker = new Faker({ locale: [pt_BR] })

function createImovel(imovel) {
  return {
    id: faker.number.int(),
    rua: faker.location.street(),
    cidade: faker.location.city(),
    estado: faker.location.state({ abbreviated: true }),
    numero: faker.location.buildingNumber(),
    tipo: faker.helpers.arrayElement(['casa', 'apartamento', 'comercial']),
    ...imovel
  }

}