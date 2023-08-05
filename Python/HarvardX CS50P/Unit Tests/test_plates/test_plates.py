# Re-requesting a Vanity Plate
# In a file called plates.py, reimplement Vanity Plates from Problem Set 2, restructuring your code per the below, wherein is_valid still expects a str as input and returns True if that str meets all requirements and False if it does not, but main is only called if the value of __name__ is "__main__":
# 
# def main():
#     ...
# 
# 
# def is_valid(s):
#     ...
# 
# 
# if __name__ == "__main__":
#     main()
# 
# Then, in a file called test_plates.py, implement four or more functions that collectively test your implementation of is_valid thoroughly, each of whose names should begin with test_ so that you can execute your tests with:
# pytest test_plates.py
# 
# Hints
# - Be sure to include
# import plates
# or
# from plates import is_valid
# atop test_plates.py so that you can call is_valid in your tests.
# 
# - Take care to return, not print, a bool in is_valid. Only main should call print.
# 
# Demo
# $ pytest test_plates.py
# =================================== test session starts ====================================
# # # #
# # # #
# collected 1 item
# 
# test_plates.py .                                                                      [100%]
# 
# ==================================== 1 passed in 0.01s =====================================

from plates import is_valid


def test():
    assert is_valid("CS50") == True
    assert is_valid("CS05") == False
    assert is_valid("CS50P") == False
    assert is_valid("PI3.14") == False
    assert is_valid("H") == False
    assert is_valid("OUTATIME") == False