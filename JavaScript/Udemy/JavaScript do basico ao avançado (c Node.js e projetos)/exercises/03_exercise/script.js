// Regular expression to validate brand names: Nike, Adidas, Puma, or Asics
const validateBrand = /Brand: (Nike|Adidas|Puma|Asics)/;

console.log(validateBrand.test("Brand: Nike")); // Should print 'true'
console.log(validateBrand.test("Brand: asd")); // Should print 'false'
console.log(validateBrand.test("Brand: ")); // Should print 'false'
console.log(validateBrand.test("Nike")); // Should print 'false'
console.log(validateBrand.test("123132")); // Should print 'false'
console.log(validateBrand.test("Brand: Puma")); // Should print 'true'