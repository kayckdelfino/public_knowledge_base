# In this challenge, I want you to create a script that prompts the user for two numbers. Then your script should print the addition, subtraction, multiplication, division (decimal result), and exponentiation (first number raised to the second number) of these two numbers.


# Ask the user to enter two numbers
num1 = float(input("Enter the first number: "))
num2 = float(input("Enter the second number: "))

# Perform mathematical calculations
sum = num1 + num2
subtraction = num1 - num2
multiplication = num1 * num2
division = num1 / num2
exponentiation = num1 ** num2

# Printing results to the console
print(f"Sum: {sum}")
print(f"Subtraction: {subtraction}")
print(f"Multiplication: {multiplication}")
print(f"Division: {division}")
print(f"Exponentiation: {exponentiation}")