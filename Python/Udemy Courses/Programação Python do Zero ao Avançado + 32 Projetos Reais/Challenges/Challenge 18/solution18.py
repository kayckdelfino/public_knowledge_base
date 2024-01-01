# For this challenge, imagine you have a car store. Create a list of the cars you have in stock: BMW X6, BMW i5, BMW i8. Ask the user to enter the name of the car they want to buy. If the car is in stock, print "This car is available". If the car is not in stock, print "Sorry, this car is not available".


stock = ["BMW X6", "BMW i5", "BMW i8"]
car_search = input("Enter the car you want: ")

if car_search in stock:
    print("This car is available")
else:
    print("Sorry, this car is not available")