// Regular expression to validate IDs ending with 'ID'
const validateId = /\d+ID\b/; 

console.log(validateId.test("384284ID")); // Should print 'true'
console.log(validateId.test("384284")); // Should print 'false'
console.log(validateId.test("asd")); // Should print 'false'
console.log(validateId.test("asdasdID")); // Should print 'false'
console.log(validateId.test("ID")); // Should print 'false'
console.log(validateId.test("555ID")); // Should print 'true'