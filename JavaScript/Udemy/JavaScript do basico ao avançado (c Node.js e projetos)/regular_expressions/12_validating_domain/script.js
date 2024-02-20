// Regular expression to validate domain names like 'www.google.com', 'www.horadecodar.com.br', 'www.horadecodar', 'horadecodar.com.br', etc.
const validateDomain = /[?www.]\w+\.com.br|.com/;

console.log(validateDomain.test("www.google.com")); // Should print 'true'
console.log(validateDomain.test("www.horadecodar.com.br")); // Should print 'true'
console.log(validateDomain.test("www.horadecodar")); // Should print 'false'
console.log(validateDomain.test("horadecodar.com.br")); // Should print 'true'