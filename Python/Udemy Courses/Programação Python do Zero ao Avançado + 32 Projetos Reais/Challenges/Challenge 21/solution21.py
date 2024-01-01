# For this challenge, create a list with the names of three cities. Ask the user to enter the name of a city. If the city is in the list, print "The city is in the list of cities". If the city is not in the list, print "The city is not in the city list".
#
# Note: You cannot use list()


cities = ("São Paulo", "Rio de Janeiro", "Salvador")
user_city = input("Enter the name of the city: ")

if user_city in cities:
    print("The city is in the list of cities")
else:
    print("The city is not in the list of cities")