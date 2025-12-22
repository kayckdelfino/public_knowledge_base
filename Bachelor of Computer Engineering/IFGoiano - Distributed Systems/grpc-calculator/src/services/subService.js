// services/subService.js

const grpc = require('@grpc/grpc-js');
const protoLoader = require('@grpc/proto-loader');
const path = require('path');

const packageDefinition = protoLoader.loadSync(
  path.join(__dirname, '../protos/calculator.proto')
);
const proto = grpc.loadPackageDefinition(packageDefinition);

// Implementação da função de subtração
function compute(call, callback) {
  const { a, b } = call.request;
  console.log(`[SUB] Received: a=${a}, b=${b}`);

  const result = a - b;
  console.log(`[SUB] Returning result: ${result}`);

  callback(null, { result });
}

function main() {
  const server = new grpc.Server();
  server.addService(proto.Calculator.service, { Compute: compute });
  server.bindAsync('0.0.0.0:50052', grpc.ServerCredentials.createInsecure(), () => {
    console.log('SubService running at 50052');
  });
}

main();
