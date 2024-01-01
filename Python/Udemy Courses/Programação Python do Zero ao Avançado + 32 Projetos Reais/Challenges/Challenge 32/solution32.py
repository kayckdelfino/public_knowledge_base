# For this challenge, create a lambda function that squares a number. Then use this function to calculate the square of all numbers in a list using a for loop.


numbers = [1, 2, 3, 4, 5, 6]
square = lambda num: num ** 2

results = []
for i in numbers:
    results.append(square(i))

print(f"The squares of the numbers {numbers} are {results}")