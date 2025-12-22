// services/divService.js

const grpc = require('@grpc/grpc-js');
const protoLoader = require('@grpc/proto-loader');
const path = require('path');

const packageDefinition = protoLoader.loadSync(path.join(__dirname, '../protos/calculator.proto'));
const proto = grpc.loadPackageDefinition(packageDefinition);

// Implementação da função de divisão
function compute(call, callback) {
  const { a, b } = call.request;
  console.log(`[DIV] Received: a=${a}, b=${b}`);

  // Verifica se o divisor é zero para evitar divisão por zero
  if (b === 0) {
    console.error('[DIV] Error: Division by zero');
    return callback({
      code: grpc.status.INVALID_ARGUMENT,
      message: 'Division by zero is not allowed',
    });
  }

  const result = a / b;
  console.log(`[DIV] Returning result: ${result}`);

  callback(null, { result });
}

function main() {
  const server = new grpc.Server();
  server.addService(proto.Calculator.service, { Compute: compute });
  server.bindAsync('0.0.0.0:50054', grpc.ServerCredentials.createInsecure(), () => {
    console.log('DivService running at 50054');
  });
}

main();
