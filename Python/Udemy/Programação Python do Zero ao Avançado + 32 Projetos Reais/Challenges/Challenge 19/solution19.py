# For this challenge, create a loop that asks the user to type the name of a fruit. If the fruit entered is not "avocado", loop should continue asking the user to enter the name of a fruit. If the fruit is "avocado", the loop should end and the program should print "Congratulations, you got the fruit right!".


while True:
    fruit = input("Enter the name of a fruit: ")
    if fruit.lower() == "avocado":
        break
        
print("Congratulations, you got the fruit right!")