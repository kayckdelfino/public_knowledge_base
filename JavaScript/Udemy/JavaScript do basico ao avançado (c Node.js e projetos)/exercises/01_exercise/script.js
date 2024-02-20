// Regular expression to validate uppercase letters
const validateUppercase = /[A-Z]/;

console.log(validateUppercase.test("testando")); // Should print 'false'
console.log(validateUppercase.test("123")); // Should print 'false'
console.log(validateUppercase.test("TESTANDO")); // Should print 'true'