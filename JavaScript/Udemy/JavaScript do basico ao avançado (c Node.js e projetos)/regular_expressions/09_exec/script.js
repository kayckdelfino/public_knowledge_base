// Regular expression to match one or more digits
const digits = /\d+/;

console.log(digits.exec("There's the number 100 here")); // Should print ['100']
console.log(digits.exec("There's no number here")); // Should print null