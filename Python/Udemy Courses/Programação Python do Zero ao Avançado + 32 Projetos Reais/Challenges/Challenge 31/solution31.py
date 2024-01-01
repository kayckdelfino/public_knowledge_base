# For this challenge, create a lambda function that accepts a number and returns "Even" if the number is even and "Odd" if the number is odd.


even_or_odd = lambda num: "Even" if num % 2 == 0 else "Odd"

user_number = int(input("Enter a number: "))
print(f" The number {user_number} is {even_or_odd(user_number)}")