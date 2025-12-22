// orchestrator/orchestrator.js

const grpc = require('@grpc/grpc-js');
const protoLoader = require('@grpc/proto-loader');
const path = require('path');
const operationsRouter = require('./operationsRouter');

const packageDefinition = protoLoader.loadSync(path.join(__dirname, '../protos/calculator.proto'));
const proto = grpc.loadPackageDefinition(packageDefinition);

// Função que repassa a requisição para o serviço correto
function forwardOperation(operation, a, b, callback) {
  const route = operationsRouter[operation];
  if (!route) {
    console.error(`[ORCH] Invalid operation "${operation}"`);
    return callback(new Error('Invalid operation'));
  }

  console.log(`[ORCH] Forwarding: ${operation}(${a}, ${b}) → ${route.address}`);

  const client = new proto.Calculator(route.address, grpc.credentials.createInsecure());

  // Envia a requisição Compute para o serviço de operação
  client.Compute({ a, b }, (err, response) => {
    if (err) {
      console.error(`[ORCH] Error from ${operation} service: ${err.message}`);
      return callback(err);
    }
    console.log(`[ORCH] Result from ${operation}: ${response.result}`);
    callback(null, response.result);
  });
}

function main() {
  const server = new grpc.Server();

  server.addService(proto.Calculator.service, {
    // Implementação do método Compute
    Compute(call, callback) {
      // Extrai os parâmetros da requisição
      const { a, b } = call.request;

      // Recupera a operação do metadata da requisição
      const operation = call.metadata.get('operation')[0];

      // Encaminha a operação para o serviço apropriado
      forwardOperation(operation, a, b, (err, result) => {
        if (err) return callback(err);
        callback(null, { result });
      });
    }
  });

  server.bindAsync('0.0.0.0:50050', grpc.ServerCredentials.createInsecure(), () => {
    console.log('[ORCH] Orchestrator running at port 50050');
  });
}

main();
