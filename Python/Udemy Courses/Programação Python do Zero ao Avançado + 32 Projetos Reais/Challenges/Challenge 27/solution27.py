# Recursive functions are functions that are called within their own block of code. They are useful for solving problems that can be broken down into smaller problems of a similar nature.
#
# A classic example of where recursion is used is calculating the factorial of a number. The factorial of a number n is the product of all positive integers from n to 1.


def factorial(n):
    if n == 0 or n == 1:
        return 1
    else:
        return n * factorial(n - 1)

user_number = int(input("Enter a number: "))
print(f"The factorial of {user_number} is {factorial(user_number)}")