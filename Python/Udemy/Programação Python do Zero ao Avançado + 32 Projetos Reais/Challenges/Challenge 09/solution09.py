# For this challenge, start with the "fruits" list from the previous challenge. First, remove the "sleeve" from the list using the remove() method. After that, remove the last item from the list using the del command. Finally, print the modified list on the screen.


fruits = ["apple", "strawberry", "mango", "grape", "pineapple"]

fruits.remove("mango")
del fruits[-1]

print(fruits)