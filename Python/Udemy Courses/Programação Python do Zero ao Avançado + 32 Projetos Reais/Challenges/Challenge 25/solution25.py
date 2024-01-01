# For this challenge, create a function that accepts two numbers as input and returns the sum of those numbers.


def sum(num1, num2):
    return num1 + num2

user_num1 = int(input("Enter the first number: "))
user_num2 = int(input("Enter the second number: "))

print(f"The sum of the two numbers is equal to: {sum(user_num1, user_num2)}")