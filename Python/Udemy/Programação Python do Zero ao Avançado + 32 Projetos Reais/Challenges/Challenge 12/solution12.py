# For this challenge, create a list of fruits and a list of vegetables. Use a nested for loop to print all possible combinations of fruits and vegetables, with the fruit first and the vegetable second.


fruits = ["apple", "banana", "mango"]
vegetables = ["carrot", "lettuce", "broccoli"]

for fruit in fruits:
    for vegetable in vegetables:
        print(fruit, vegetable)