// Regular expression to validate IP addresses
const validateIp = /\d{1,3}\.\d{1,3}\.\d{1,3}\.\d{1,3}/;

console.log(validateIp.test("127.0.0.1")); // Should print 'true'
console.log(validateIp.test("8.8.8.8")); // Should print 'true'
console.log(validateIp.test("192.168.0.62")); // Should print 'true'

console.log(validateIp.test("192.168.0")); // Should print 'false'
console.log(validateIp.test("192")); // Should print 'false'
console.log(validateIp.test("asdasasd")); // Should print 'false'
console.log(validateIp.test("12312321")); // Should print 'false'
console.log(validateIp.test("1924.1648.04.62444")); // Should print 'false'