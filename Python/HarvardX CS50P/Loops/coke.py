# Coke Machine
# Suppose that a machine sells bottles of Coca-Cola (Coke) for 50 cents and only accepts coins in these denominations: 25 cents, 10 cents, and 5 cents.
# 
# In a file called coke.py, implement a program that prompts the user to insert a coin, one at a time, each time informing the user of the amount due. Once the user has inputted at least 50 cents, output how many cents in change the user is owed. Assume that the user will only input integers, and ignore any integer that isn’t an accepted denomination.
# 
# Demo
# $ python coke.py
# Amount Due: 50
# Insert Coin: 25
# Amount Due: 25
# Insert Coin: 25
# Change Owed: 0
# $ python coke.py
# Amount Due: 50
# Insert Coin: 50
# Amount Due: 50
# Insert Coin: 49
# Amount Due: 50
# Insert Coin: 25
# Amount Due: 25
# Insert Coin: 10
# Amount Due: 15
# Insert Coin: 10
# Amount Due: 5
# Insert Coin: 5
# Change Owed: 0
# $ python coke.py
# Amount Due: 50
# Insert Coin: 25
# Amount Due: 25
# Insert Coin: 10
# Amount Due: 15
# Insert Coin: 10
# Amount Due: 5
# Insert Coin: 10
# Change Owed: 5

price = 50

while price > 0:
    print("Amount Due:", price)
    coin = int(input("Insert Coin: "))
    if coin == 25 or coin == 10 or coin == 5:
        price -= coin

print("Change Owed:", -price)