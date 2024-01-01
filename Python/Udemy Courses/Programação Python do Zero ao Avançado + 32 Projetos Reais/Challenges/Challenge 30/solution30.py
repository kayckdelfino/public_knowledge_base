# For this challenge, create a lambda function that accepts two numbers and returns the multiplication of those numbers.


multiply = lambda num1, num2: num1 * num2

user_number1 = int(input("Enter the first number: "))
user_number2 = int(input("Enter the second number: "))

print(f"The multiplication of {user_number1} and {user_number2} is {multiply(user_number1, user_number2)}")