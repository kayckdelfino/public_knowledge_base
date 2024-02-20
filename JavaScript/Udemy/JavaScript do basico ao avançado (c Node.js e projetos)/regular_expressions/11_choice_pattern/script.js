// Regular expression to match patterns like 'Nome: Matheus', 'Nome: João', or 'Nome: Maria'
const reg = /\w+: (Matheus|João|Maria)/;

console.log(reg.test("Nome: Matheus")); // Should print 'true'
console.log(reg.test("Nome: José")); // Should print 'false'
console.log(reg.test("Nome: Maria")); // Should print 'true'