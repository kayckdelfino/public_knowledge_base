# Back to the Bank
# In a file called bank.py, reimplement Home Federal Savings Bank from Problem Set 1, restructuring your code per the below, wherein value expects a str as input and returns 0 if that str starts with “hello”, 20 if that str starts with an “h” (but not “hello”), or 100 otherwise, treating the str case-insensitively. You can assume that the string passed to the value function will not contain any leading spaces. Only main should call print.
# 
# def main():
#     ...
# 
# 
# def value(greeting):
#     ...
# 
# 
# if __name__ == "__main__":
#     main()
# 
# Then, in a file called test_bank.py, implement three or more functions that collectively test your implementation of value thoroughly, each of whose names should begin with test_ so that you can execute your tests with:
# pytest test_bank.py
# 
# Hints
# - Be sure to include
# import bank
# or
# from bank import value
# atop test_bank.py so that you can call value in your tests.
# 
# - Take care to return, not print, an int in value. Only main should call print.
# 
# Demo
# $ pytest test_bank.py
# ======================================= test session starts ========================================
# # # #
# # # #
# collected 3 items
# 
# test_bank.py ...                                                                              [100%]
# 
# ======================================== 3 passed in 0.02s =========================================

from bank import value


def test_upper():
    assert value("HELLO") == 0
    assert value("HELLO, NEWMAN") == 0
    assert value("HOW YOU DOING?") == 20
    assert value("WHAT'S HAPPENING?") == 100


def test_lower():
    assert value("hello") == 0
    assert value("hello, newman") == 0
    assert value("how you doing?") == 20
    assert value("what's happening?") == 100


def test_leading_spaces():
    assert value(" hello ") == 0