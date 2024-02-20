// Regular expression to validate username: should contain only lowercase letters, digits, hyphens, or underscores, with a length between 3 and 16 characters
let validateUsername = /^(?=.{3,16}$)[a-z0-9-_]/;

console.log(validateUsername.test("matheus_123")); // Should print 'true'

console.log(validateUsername.test("as")); // Should print 'false'
console.log(validateUsername.test("11111111111111111111111111111")); // Should print 'false'