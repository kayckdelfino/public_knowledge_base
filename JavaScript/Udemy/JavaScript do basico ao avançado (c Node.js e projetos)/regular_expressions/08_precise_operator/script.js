// Regular expression to match a Brazilian zip code (CEP) format
const zipcode = /\d{5}-\d{3}/;

console.log(zipcode.test("88117-500")); // Should print 'true'
console.log(zipcode.test("asd")); // Should print 'false'
console.log(zipcode.test("881-50")); // Should print 'false'
console.log(zipcode.test("99999-999")); // Should print 'true'

// Regular expression to match a Brazilian telephone number format
const phoneNumber = /\(\d{2}\)\d{4,5}-\d{4}/;

console.log(phoneNumber.test("(48)9999-9999")); // Should print 'true'
console.log(phoneNumber.test("(48)55555-4444")); // Should print 'true'