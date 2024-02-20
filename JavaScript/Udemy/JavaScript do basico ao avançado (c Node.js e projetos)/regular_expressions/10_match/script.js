// Matching the first occurrence of one or more digits in a string
const phrase = "The number 100 is here".match(/\d+/);
const phrase2 = "The number is here".match(/\d+/);

console.log(phrase); // Should print ['100']
console.log(phrase2); // Should print null