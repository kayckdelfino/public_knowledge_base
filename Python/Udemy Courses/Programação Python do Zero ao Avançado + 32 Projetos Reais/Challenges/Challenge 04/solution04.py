# In this challenge, I want you to create a script that asks for the user's name and age, using the input() function. After that, the script should print a message that says "Hello, [name]! You are [age] years old."


first_name = input("Please enter your name: ") # String
age = int(input("Now, enter your age: ")) # Integer

print("Hello, {}! You are {} years old".format(first_name, age))
print(f"Hello, {first_name}! You are {age} years old")
print("Hello,", first_name + "!", "You are", age, "years old")