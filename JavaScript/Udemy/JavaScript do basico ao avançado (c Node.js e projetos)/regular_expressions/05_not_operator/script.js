// Regular expression to match any character except 'a' and 'b'
const notAB = /[^ab]/;

console.log(notAB.test("a")); // Should print 'false'
console.log(notAB.test("Here is a")); // Should print 'true'

// Regular expression to match any character except lowercase letters 'a' through 'z'
const notLowercaseAZ = /[^a-z]/;

console.log(notLowercaseAZ.test("123 as")); // Should print 'true'
console.log(notLowercaseAZ.test("asdasfdfsfeeqweqeqwes")); // Should print 'false'

// Regular expression to match any lowercase letter 'a' through 'z'
const lowercaseAZ = /[a-z]/;

console.log(lowercaseAZ.test("asd123asdad")); // Should print 'true'