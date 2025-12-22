// services/mulService.js

const grpc = require('@grpc/grpc-js');
const protoLoader = require('@grpc/proto-loader');
const path = require('path');

const packageDefinition = protoLoader.loadSync(
  path.join(__dirname, '../protos/calculator.proto')
);
const proto = grpc.loadPackageDefinition(packageDefinition);

// Implementação da função de multiplicação
function compute(call, callback) {
  const { a, b } = call.request;
  console.log(`[MUL] Received: a=${a}, b=${b}`);

  const result = a * b;
  console.log(`[MUL] Returning result: ${result}`);

  callback(null, { result });
}

function main() {
  const server = new grpc.Server();
  server.addService(proto.Calculator.service, { Compute: compute });
  server.bindAsync('0.0.0.0:50053', grpc.ServerCredentials.createInsecure(), () => {
    console.log('MulService running at 50053');
  });
}

main();
