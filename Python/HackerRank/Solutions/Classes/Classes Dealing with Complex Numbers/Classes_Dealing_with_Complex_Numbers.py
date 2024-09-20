# Challenge statement: https://www.hackerrank.com/challenges/class-1-dealing-with-complex-numbers/problem
# 
# For this challenge, you are given two complex numbers, and you have to print the result of their addition, subtraction, multiplication, division and modulus operations.
# 
# The real and imaginary precision part should be correct up to two decimal places.
# 
# Input Format
# One line of input: The real and imaginary part of a number separated by a space.
# 
# Output Format
# For two complex numbers C and D, the output should be in the following sequence on separate lines:
# C + D
# C - D
# C * D
# C / D
# mod(C)
# mod(D)
# 
# For complex numbers with non-zero real (A) and complex part (B), the output should be in the following format:
# A + Bi
# 
# Replace the plus symbol (+) with a minus symbol (-) when B < 0.
# 
# For complex numbers with a zero complex part i.e. real numbers, the output should be:
# A + 0.00i
# 
# For complex numbers where the real part is zero and the complex part (B) is non-zero, the output should be:
# 0.00 + Bi
# 
# Sample Input
# 2 1
# 5 6
# 
# Sample Output
# 7.00+7.00i
# -3.00-5.00i
# 4.00+17.00i
# 0.26-0.11i
# 2.24+0.00i
# 7.81+0.00i
# 
# Concept
# Python is a fully object-oriented language like C++, Java, etc. For reading about classes, refer [here](http://www.diveintopython3.net/iterators.html#defining-classes).
# 
# Methods with a double underscore before and after their name are considered as built-in methods. They are used by interpreters and are generally used in the implementation of overloaded operators or other built-in functionality.
# 
# __add__-> Can be overloaded for + operation
# 
# __sub__ -> Can be overloaded for - operation
# 
# __mul__ -> Can be overloaded for * operation
# 
# For more information on operator overloading in Python, refer [here](https://docs.python.org/3.2/reference/datamodel.html).


import math

class Complex(object):
    def __init__(self, real, imaginary):
        self.real = real
        self.imaginary = imaginary
        
    def __add__(self, other):
        return Complex(self.real + other.real, self.imaginary + other.imaginary)
        
    def __sub__(self, other):
        return Complex(self.real - other.real, self.imaginary - other.imaginary)
        
    def __mul__(self, other):
        real = self.real * other.real - self.imaginary * other.imaginary
        imaginary = self.real * other.imaginary + self.imaginary * other.real
        
        return Complex(real, imaginary)

    def __truediv__(self, other):
        denominator = other.real**2 + other.imaginary**2
        real = (self.real * other.real + self.imaginary * other.imaginary) / denominator
        imaginary = (self.imaginary * other.real - self.real * other.imaginary) / denominator
        
        return Complex(real, imaginary)

    def mod(self):
        return Complex(math.sqrt(self.real**2 + self.imaginary**2), 0)

    def __str__(self):
        real_part = f"{self.real:.2f}"
        imaginary_part = f"{abs(self.imaginary):.2f}i"
        
        if self.imaginary == 0:
            return f"{real_part}+0.00i"
        elif self.real == 0:
            sign = "+" if self.imaginary >= 0 else "-"
            return f"0.00{sign}{imaginary_part}"
        else:
            sign = "+" if self.imaginary >= 0 else "-"
            return f"{real_part}{sign}{imaginary_part}"

if __name__ == '__main__':
    c = map(float, input().split())
    d = map(float, input().split())
    x = Complex(*c)
    y = Complex(*d)
    print(*map(str, [x+y, x-y, x*y, x/y, x.mod(), y.mod()]), sep='\n')