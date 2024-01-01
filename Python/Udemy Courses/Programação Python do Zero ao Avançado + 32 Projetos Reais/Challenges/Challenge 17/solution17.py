# For this challenge, ask the user to enter their age. If age is less than 13, print "You are a child". If the age is between 13 and 19, print "You are a teenager". If age is 20 or older, print "You are an adult."


age = int(input("Enter your age: "))

if age < 13:
    print("You are a child!")
elif age >= 13 and age < 20:
    print("You are a teenager!")
else:
    print("You are an adult!")