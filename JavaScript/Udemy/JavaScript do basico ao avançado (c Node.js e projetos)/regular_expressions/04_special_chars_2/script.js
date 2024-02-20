// Regular expression to match two digits
const day = /\d\d/;

console.log(day.test("2019") && "2019".length == 2);
console.log(day.test("asd"));
console.log(day.test("05") && "05".length == 2);
console.log(day.test("asd1"));

// Regular expression to match at least three word characters
const wordsAtLeastThreeLetters = /\w\w\w/;

console.log(wordsAtLeastThreeLetters.test("asd"));
console.log(wordsAtLeastThreeLetters.test("asdd"));
console.log(wordsAtLeastThreeLetters.test("as"));