# Working 9 to 5
# Whereas most countries use a 24-hour clock, the United States tends to use a 12-hour clock. Accordingly, instead of “09:00 to 17:00”, many Americans would say they work “9:00 AM to 5:00 PM” (or “9 AM to 5 PM”), wherein “AM” is an abbreviation for “ante meridiem” and “PM” is an abbreviation for “post meridiem”, wherein “meridiem” means midday (i.e., noon).
# 
# In a file called working.py, implement a function called convert that expects a str in either of the 12-hour formats below and returns the corresponding str in 24-hour format (i.e., 9:00 to 17:00). Expect that AM and PM will be capitalized (with no periods therein) and that there will be a space before each. Assume that these times are representative of actual times, not necessarily 9:00 AM and 5:00 PM specifically.
# 
#     - 9:00 AM to 5:00 PM
#     - 9 AM to 5 PM
# 
# Raise a ValueError instead if the input to convert is not in either of those formats or if either time is invalid (e.g., 12:60 AM, 13:00 PM, etc.). But do not assume that someone’s hours will start ante meridiem and end post meridiem; someone might work late and even long hours (e.g., 5:00 PM to 9:00 AM).
# 
# Structure working.py as follows, wherein you’re welcome to modify main and/or implement other functions as you see fit, but you may not import any other libraries. You’re welcome, but not required, to use re and/or sys.
# 
# import re
# import sys
# 
# 
# def main():
#     print(convert(input("Hours: ")))
# 
# 
# def convert(s):
#     ...
# 
# 
# if __name__ == "__main__":
#     main()
# 
# Either before or after you implement convert in working.py, additionally implement, in a file called test_working.py, three or more functions that collectively test your implementation of convert thoroughly, each of whose names should begin with test_ so that you can execute your tests with:
# pytest test_working.py
# 
# Hints
# - Recall that the re module comes with quite a few functions, per docs.python.org/3/library/re.html, including search.
# - Recall that regular expressions support quite a few special characters, per docs.python.org/3/library/re.html#regular-expression-syntax.
# - Because backslashes in regular expressions could be mistaken for escape sequences (like \n), best to use Python’s raw string notation for regular expression patterns, else pytest will warn with DeprecationWarning: invalid escape sequence. Just as format strings are prefixed with f, so are raw strings prefixed with r. For instance, instead of "harvard\.edu", use r"harvard\.edu".
# - Note that re.search, if passed a pattern with “capturing groups” (i.e., parentheses), returns a “match object,” per docs.python.org/3/library/re.html#match-objects, wherein matches are 1-indexed, which you can access individually with group, per docs.python.org/3/library/re.html#re.Match.group, or collectively with groups, per docs.python.org/3/library/re.html#re.Match.groups.
# - Note that you can format an int with leading zeroes with code like
#     print(f"{n:02}")
# wherein, if n is a single digit, it will be prefixed with one 0, per docs.python.org/3/library/string.html#format-string-syntax.
# 
# Demo
# $ python working.py
# Hours: 9:00 AM to 5:00 PM
# 09:00 to 17:00
# $ python working.py
# Hours: 9 AM to 5 PM
# 09:00 to 17:00
# $ python working.py
# Hours: 9 AM to 5:30 PM
# 09:00 to 17:30


def main():
    print(convert(input("Hours: ")))


def validate_time(time):
    if ":" in time:
        hours, minutes = time.split(":")
        if not hours.isdigit() or not minutes.isdigit():
            raise ValueError("Invalid time format")

        hours = int(hours)
        minutes = int(minutes)

        if hours < 0 or hours > 23 or minutes < 0 or minutes > 59:
            raise ValueError("Invalid time range")
    else:
        if not time.isdigit():
            raise ValueError("Invalid time format")

        hours = int(time)
        if hours < 0 or hours > 23:
            raise ValueError("Invalid time range")


def convert(s):
    if " to " in s: parts = s.split(" to ")
    else: raise ValueError("Invalid input format")
    hours_formatted = []

    if len(parts) != 2: raise ValueError("Invalid input format")

    for part in parts:
        time, period = part.split(" ")
        validate_time(time)

        if ":" in time:
            hours, minutes = time.split(":")
        else:
            hours, minutes = time, "00"

        if period not in ["AM", "PM"]:
            raise ValueError("Invalid period")

        if period == "AM":
            if hours == "12":
                hours_formatted.append(f"00:{minutes}")
            else:
                hours_formatted.append(f"{hours.zfill(2)}:{minutes}")
        elif period == "PM":
            if hours == "12":
                hours_formatted.append(f"{hours.zfill(2)}:{minutes}")
            else:
                hours_formatted.append(f"{str(int(hours) + 12).zfill(2)}:{minutes}")

    return f"{hours_formatted[0]} to {hours_formatted[1]}"


if __name__ == "__main__":
    main()