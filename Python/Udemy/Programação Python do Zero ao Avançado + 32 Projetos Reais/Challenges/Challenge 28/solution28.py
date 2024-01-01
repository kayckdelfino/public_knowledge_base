# For this challenge, create two functions. The first function must accept a number and return twice that number. The second function must accept a number and return the square of that number. Then call the first function inside the second to return the square of twice a number.


def double(num):
    return num * 2

def square(num):
    return double(num) ** 2

user_number = int(input("Enter a number: "))
print(f"The square of twice the number {user_number} is {square(user_number)}")