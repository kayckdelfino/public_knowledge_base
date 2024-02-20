// Regular expression to match any digit from 1 to 5
const reg1 = /[12345]/;

// Testing the regular expression against strings
console.log(reg1.test("We have the number 6")); // Should print 'false'
console.log(reg1.test("We have the number 2")); // Should print 'true'
console.log(reg1.test("We have the number 23")); // Should print 'true'
console.log(reg1.test("We have the number 60")); // Should print 'false'

// Regular expression to match any digit from 0 to 9
const reg2 = /[0-9]/;

// Testing the second regular expression
console.log(reg2.test("We have the number 65448484884848484")); // Should print 'true'
console.log(reg2.test("We have the number")); // Should print 'false'