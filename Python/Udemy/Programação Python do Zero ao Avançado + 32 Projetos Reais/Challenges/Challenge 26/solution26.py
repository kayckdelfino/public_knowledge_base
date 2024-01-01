# For this challenge, create a function that calculates the power of a number. The function must accept two arguments: the base and the exponent. However, if the exponent is not provided when calling the function, it should default to 2.


def power(base, exponent = 2):
    return base ** exponent

user_number = int(input("Enter the base number: "))
user_exponent = input("Enter an exponent (default 2): ")

if user_exponent:
    print(f"The result is: {power(user_number, int(user_exponent))}")
else:
    print(f"The result is: {power(user_number)}")