// services/addService.js

const grpc = require('@grpc/grpc-js');
const protoLoader = require('@grpc/proto-loader');
const path = require('path');

const packageDefinition = protoLoader.loadSync(path.join(__dirname, '../protos/calculator.proto'));
const proto = grpc.loadPackageDefinition(packageDefinition);

// Implementação da função de soma
function compute(call, callback) {
  const { a, b } = call.request;
  console.log(`[ADD] Received: a=${a}, b=${b}`);

  const result = a + b;
  console.log(`[ADD] Returning result: ${result}`);

  callback(null, { result });
}

function main() {
  const server = new grpc.Server();
  server.addService(proto.Calculator.service, { Compute: compute });
  server.bindAsync('0.0.0.0:50051', grpc.ServerCredentials.createInsecure(), () => {
    console.log('AddService running at 50051');
  });
}

// Executa a função principal para iniciar o servidor
main();
