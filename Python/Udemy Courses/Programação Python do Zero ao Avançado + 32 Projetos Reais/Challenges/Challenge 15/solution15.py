# For this challenge, create a list of fruits that includes "apple" three times and other fruits of your choice. Use a for loop to count how many times "apple" appears in the list and print the result.


fruits = ["apple", "banana", "apple", "apple", "avocado", "grape"]
counter = 0

for fruit in fruits:
    if fruit == "apple":
        counter += 1

print("Number of apples in the list: ", counter)