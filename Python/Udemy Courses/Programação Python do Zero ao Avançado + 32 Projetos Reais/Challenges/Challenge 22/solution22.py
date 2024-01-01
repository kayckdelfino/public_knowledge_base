# For this challenge, create a list with 5 country names and the capitals of these countries. Ask the user to enter the name of a country. If the country is on the list, print "The capital of [country] is [capital]". If the country is not in the list, print "Sorry, we don't have information about the capital of this country".


capitals = {
    "Brazil": "Brasilia",
    "Argentina": "Buenos Aires",
    "Chile": "Santiago",
    "Australia": "Canberra",
    "Canada": "Ottawa"
}
user_country = input("Enter the name of the country: ")

if user_country in capitals:
    print(f"The capital of {user_country} is {capitals[user_country]}")
else:
    print("Sorry, we don't have information about the capital of this country.")