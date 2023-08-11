# Seasons of Love
# Five hundred twenty-five thousand, six hundred minutes
# Five hundred twenty-five thousand moments so dear
# Five hundred twenty-five thousand, six hundred minutes
# How do you measure, measure a year?
# — “Seasons of Love,” Rent
# 
# Assuming there are 365 days in a year, there are 365 x 24 x 60 = 525,600 minutes in that same year (because there are 24 hours in a day and 60 minutes in an hour). But how many minutes are there in two or more years? Well, it depends on how many of those are leap years with 366 days, per the Gregorian calendar, as some of them could have 1 x 24 x 60 = 1,440 additional minutes. In fact, how many minutes has it been since you were born? Well, that, too, depends on how many leap years there have been since! There is an algorithm for such, but let’s not reinvent that wheel. Let’s use a library instead. Fortunately, Python comes with a datetime module that has a class called date that can help, per docs.python.org/3/library/datetime.html#date-objects.
# 
# In a file called seasons.py, implement a program that prompts the user for their date of birth in YYYY-MM-DD format and then sings prints how old they are in minutes, rounded to the nearest integer, using English words instead of numerals, just like the song from Rent, without any and between words. Since a user might not know the time at which they were born, assume, for simplicity, that the user was born at midnight (i.e., 00:00:00) on that date. And assume that the current time is also midnight. In other words, even if the user runs the program at noon, assume that it’s actually midnight, on the same date. Use datetime.date.today to get today’s date, per docs.python.org/3/library/datetime.html#datetime.date.today.
# 
# Structure your program per the below, not only with a main function but also with one or more other functions as well:
# 
# from datetime import date
# 
# 
# def main():
#     ...
# 
# 
# ...
# 
# 
# if __name__ == "__main__":
#     main()
# 
# You’re welcome to import other (built-in) libraries, or any that are specified in the below hints. Exit via sys.exit if the user does not input a date in YYYY-MM-DD format. Ensure that your program will not raise any exceptions.
# 
# Either before or after you implement seasons.py, additionally implement, in a file called test_seasons.py, one or more functions that test your implementation of any functions besides main in seasons.py thoroughly, each of whose names should begin with test_ so that you can execute your tests with:
# pytest test_seasons.py
# 
# Hints
# - Note that the date class comes with quite a few methods and “supported operations,” per docs.python.org/3/library/datetime.html#date-objects. In particular, the class implements __sub__, per docs.python.org/3/library/operator.html#operator.__sub__, overloading - in such a way that subtracting one date object from another returns a timedelta object, which itself comes with several (read-only) “instance attributes,” per docs.python.org/3/library/datetime.html#timedelta-objects.
# - Note that the inflect module comes with quite a few methods, per pypi.org/project/inflect. You can install it with:
# pip install inflect
# 
# Demo
# Assume that this demo was recorded on January 1, 2000.
# $ python seasons.py
# Date of Birth: January 1, 1999
# Invalid date
# $ python seasons.py
# Date of Birth: 1999-01-01
# Five hundred twenty-five thousand, six hundred minutes
# $ python seasons.py
# Date of Birth: 1999-12-31
# One thousand, four hundred forty minutes
# $ python seasons.py
# Date of Birth: 1970-01-01
# Fifteen million, seven hundred seventy-eight thousand eighty minutes


from datetime import date
import re
import sys
import inflect


def main():
    age_in_minutes = calculate_minutes(input("Date of Birth: "))
    print(numbers_in_words(age_in_minutes))


def calculate_minutes(birthdate):
    if not re.match(r"^\d{4}-\d{2}-\d{2}$", birthdate): sys.exit("Invalid date")

    today = date.today()
    birth = date.fromisoformat(birthdate)

    difference = today - birth
    return difference.days * 24 * 60


def numbers_in_words(number):
    inf = inflect.engine()
    s =  inf.number_to_words(number, andword="").capitalize()
    return f"{s} minutes"


if __name__ == "__main__":
    main()