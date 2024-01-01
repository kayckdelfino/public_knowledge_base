# For this challenge, create two sets, each containing 5 of your friends' names. Some names must be present in both sets. Use a method to find which names appear in both sets and print the result.


friends1 = {"Marcos", "Ana", "Sophia", "Arthur", "Amanda"}
friends2 = {"Jose", "Arthur", "Ana", "Carol", "Paulo"}

result = friends1.intersection(friends2)
print(result)