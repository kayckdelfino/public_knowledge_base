// Regular expression to match one or more digits
const oneOrMoreNumbers = /\d+/;

console.log(oneOrMoreNumbers.test("1518")); // Should print 'true'
console.log(oneOrMoreNumbers.test("")); // Should print 'false'
console.log(oneOrMoreNumbers.test("asdasdas")); // Should print 'false'
console.log(oneOrMoreNumbers.test("1")); // Should print 'true'
console.log(oneOrMoreNumbers.test("1511231231233123121323123121238")); // Should print 'true'