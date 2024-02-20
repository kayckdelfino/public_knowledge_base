// Regular expression to match any character
const dotRegex = /./;

console.log('.');
console.log(dotRegex.test("asd"));
console.log(dotRegex.test(" "));
console.log(dotRegex.test("123"));
console.log(dotRegex.test("123sad"));

// Regular expression to match any digit [0-9]
const digitRegex = /\d/;

console.log('d');
console.log(digitRegex.test("asd"));
console.log(digitRegex.test(" "));
console.log(digitRegex.test("123"));
console.log(digitRegex.test("123sad"));

// Regular expression to match any non-digit [^0-9]
const nonDigitRegex = /\D/;

console.log('D');
console.log(nonDigitRegex.test("asd"));
console.log(nonDigitRegex.test(" "));
console.log(nonDigitRegex.test("123"));
console.log(nonDigitRegex.test("123sad"));

// Regular expression to match any whitespace character
const spaceRegex = /\s/;

console.log('s');
console.log(spaceRegex.test("asd"));
console.log(spaceRegex.test(" "));
console.log(spaceRegex.test("123"));
console.log(spaceRegex.test("123sad"));

// Regular expression to match any word character [a-zA-Z0-9_]
const wordRegex = /\w/;

console.log('w');
console.log(wordRegex.test("asd"));
console.log(wordRegex.test(" "));
console.log(wordRegex.test("123"));
console.log(wordRegex.test("123sad"));