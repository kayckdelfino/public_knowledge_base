// Regular expression to match the word 'ball'
const reg1 = new RegExp('ball');

// Testing the regular expression against strings
console.log(reg1.test("Is there a ball?")); // Should print 'true'
console.log(reg1.test("There isn't")); // Should print 'false'

// Another way to define a regular expression
const reg2 = /ball/;

let text = 'There is a ball in the basket';

// Testing the second regular expression
console.log(reg2.test("Is there a ball?")); // Should print 'true'
console.log(reg2.test("There isn't")); // Should print 'false'
console.log(reg2.test(text)); // Should print 'true'

// Testing for the presence of the word 'quadrado'
console.log(/quadrado/.test("Where is a square")); // Should print 'false'
console.log(/quadrado/.test("3423442323434square2342323424332")); // Should print 'true'