# Fuel Gauge
# Fuel gauges indicate, often with fractions, just how much fuel is in a tank. For instance 1/4 indicates that a tank is 25% full, 1/2 indicates that a tank is 50% full, and 3/4 indicates that a tank is 75% full.
# 
# In a file called fuel.py, implement a program that prompts the user for a fraction, formatted as X/Y, wherein each of X and Y is an integer, and then outputs, as a percentage rounded to the nearest integer, how much fuel is in the tank. If, though, 1% or less remains, output E instead to indicate that the tank is essentially empty. And if 99% or more remains, output F instead to indicate that the tank is essentially full.
# 
# If, though, X or Y is not an integer, X is greater than Y, or Y is 0, instead prompt the user again. (It is not necessary for Y to be 4.) Be sure to catch any exceptions like ValueError or ZeroDivisionError.
# 
# Hints
# - Recall that a str comes with quite a few methods, per docs.python.org/3/library/stdtypes.html#string-methods, including split.
# 
# - Note that you can handle two exceptions separately with code like:
# try:
#     ...
# except ValueError:
#     ...
# except ZeroDivisionError:
#     ...
# 
# - Or you can handle two exceptions together with code like:
# try:
#     ...
# except (ValueError, ZeroDivisionError):
#     ...
# 
# Demo
# $ python fuel.py
# Fraction: cat/dog
# Fraction: 1/4
# 25%
# $ python fuel.py
# Fraction: 1/2
# 50%
# $ python fuel.py
# Fraction: 3/4
# 75%
# $ python fuel.py
# Fraction: 4/4
# F
# $ python fuel.py
# Fraction: 1/0
# Fraction: 0/1
# E

while True:
    s = input("Fraction: ")
    if "/" in s:
        x, y = s.split("/")
        try:
            div = int(x) / int(y)
        except (ValueError, ZeroDivisionError):
            pass
        else:
            if int(x) > int(y):
                continue
            else:
                div = round(div * 100)
                if div <= 1:
                    print("E")
                elif div >= 99:
                    print("F")
                else:
                    print(f"{div}%")
                break
    else:
        continue