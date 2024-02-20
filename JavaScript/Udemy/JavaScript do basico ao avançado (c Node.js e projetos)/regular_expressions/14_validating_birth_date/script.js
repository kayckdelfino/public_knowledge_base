// Regular expression to validate date of birth in the format DD/MM/YYYY
const validateDateOfBirth = /^(0[1-9]|[12][0-9]|3[01])\/(0[1-9]|1[0-2])\/(19\d{2}|20\d{2})$/;

console.log(validateDateOfBirth.test('05/02/2000')); // Should print 'true'
console.log(validateDateOfBirth.test('5/2/2000')); // Should print 'false'
console.log(validateDateOfBirth.test('05-02-2000')); // Should print 'false'
console.log(validateDateOfBirth.test('05/02/00')); // Should print 'false'
console.log(validateDateOfBirth.test('12/12/1999')); // Should print 'true'
console.log(validateDateOfBirth.test('99/99/9999')); // Should print 'false'
console.log(validateDateOfBirth.test('31/00/2010')); // Should print 'false'