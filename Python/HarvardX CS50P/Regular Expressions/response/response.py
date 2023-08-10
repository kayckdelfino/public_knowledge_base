# Response Validation
# When creating a Google Form that prompts users for a short answer (or paragraph), it’s possible to enable response validation and require that the user’s input match a regular expression. For instance, you could require that a user input an email address with a regex like this one:
# 
# ^[a-zA-Z0-9.!#$%&'*+\/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$
# 
# In a file called response.py, using either validator-collection or validators from PyPI, implement a program that prompts the user for an email address via input and then prints Valid or Invalid, respectively, if the input is a syntatically valid email address. You may not use re. And do not validate whether the email address’s domain name actually exists.
# 
# Hints
# - Note that you can install validator-collection with:
# pip install validator-collection
# Click Homepage to find your way to the library’s documentation.
# 
# - Note that you can install validators with:
# pip install validators
# Click Homepage to find your way to the library’s documentation.
# 
# Demo
# $ python response.py
# What's your email address? malan
# Invalid
# $ python response.py
# What's your email address? malan at harvard dot edu
# Invalid
# $ python response.py
# What's your email address? malan@harvard.edu
# Valid


import validators


def main():
    email = input("What's your email address? ")
    if is_valid(email): print("Valid")
    else: print("Invalid")


def is_valid(email):
    return validators.email(email)


if __name__ == "__main__":
    main()