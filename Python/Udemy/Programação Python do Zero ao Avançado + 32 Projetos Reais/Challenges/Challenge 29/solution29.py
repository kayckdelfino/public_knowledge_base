# For this challenge, create a lambda function that accepts a number and returns the cube of that number.


cube = lambda num: num ** 3

number = int(input("Enter a number: "))
print(f"The cube of {number} is {cube(number)}")