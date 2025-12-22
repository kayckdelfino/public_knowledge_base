// client/client.js

const grpc = require('@grpc/grpc-js');
const protoLoader = require('@grpc/proto-loader');
const readline = require('readline');
const path = require('path');

const packageDefinition = protoLoader.loadSync(path.join(__dirname, '../protos/calculator.proto'));
const proto = grpc.loadPackageDefinition(packageDefinition);

const client = new proto.Calculator('localhost:50050', grpc.credentials.createInsecure());

const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
  prompt: '> '
});

console.log('Decentralized Calculator CLI');
console.log('Usage: [operation] [a] [b] (e.g., "add 5 3")');
console.log('Type "quit" to exit.');
rl.prompt();

rl.on('line', (line) => {
  const input = line.trim();

  // Encerra o programa se o usuário digitar "quit"
  if (input.toLowerCase() === 'quit') {
    console.log('Bye!');
    rl.close();
    return;
  }

  // Separa a entrada em operação e operandos
  const [operation, aStr, bStr] = input.split(' ');
  const a = parseFloat(aStr);
  const b = parseFloat(bStr);

  // Valida a entrada do usuário
  if (!operation || isNaN(a) || isNaN(b)) {
    console.log('Invalid input. Usage: [operation] [a] [b]');
    rl.prompt();
    return;
  }

  // Cria metadata para enviar a operação ao servidor
  const metadata = new grpc.Metadata();
  metadata.add('operation', operation);

  // Chama o método Compute do servidor gRPC
  client.Compute({ a, b }, metadata, (err, response) => {
    if (err) {
      console.error(`Error: ${err.message}`);
    } else {
      console.log(`Result: ${response.result}`);
    }
    rl.prompt();
  });
});

rl.on('SIGINT', () => {
  console.log('\nReceived Ctrl+C. Exiting...');
  rl.close();
});
