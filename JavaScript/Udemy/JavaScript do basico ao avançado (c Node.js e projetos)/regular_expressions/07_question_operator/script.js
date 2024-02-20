// Regular expression to match 'Abacaxi' or 'Abacai'
const pattern = /Abacax?i/;

console.log(pattern.test("Abacaxi")); // Should print 'true'
console.log(pattern.test("Abacai")); // Should print 'true'

// Regular expression to match one or more digits followed by zero or one word character
const pattern2 = /\d+\w?/;

console.log(pattern2.test("123")); // Should print 'true'
console.log(pattern2.test("123a")); // Should print 'true'
console.log(pattern2.test("123 ")); // Should print 'true'