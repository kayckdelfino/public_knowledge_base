# README

## Como executar os serviços

Abra quatro terminais separados e execute cada serviço:

```sh
node src/services/addService.js
node src/services/subService.js
node src/services/mulService.js
node src/services/divService.js
```

Em um quinto terminal, inicie o orquestrador:

```sh
node src/orchestrator/orchestrator.js
```

## Como testar

No terminal, execute o cliente:

```sh
node src/client/client.js
```

Digite comandos no formato:

```
[operation] [a] [b]
```

Exemplo:

```
add 5 3
sub 10 2
mul 4 7
div 8 2
```

Para sair, digite:

```
quit
```
