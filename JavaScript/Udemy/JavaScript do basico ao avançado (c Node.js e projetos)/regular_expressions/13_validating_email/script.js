// Regular expression to validate email addresses
const validateEmail = /\w+@\w+\.\w+/;

console.log(validateEmail.test("matheus@gmail.com")); // Should print 'true'
console.log(validateEmail.test("matheus@gmail")); // Should print 'false'
console.log(validateEmail.test("gmail.com")); // Should print 'false'
console.log(validateEmail.test("matheus@gmail.com.br")); // Should print 'true'
console.log(validateEmail.test("gmail@gmail.gmail.gmail")); // Should print 'true'