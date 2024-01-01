# Create a function that accepts a number as input and returns the square of that number.


def square(number):
    return number ** 2

num = int(input("Enter a number: "))
print(f"The square of {num} is {square(num)}")