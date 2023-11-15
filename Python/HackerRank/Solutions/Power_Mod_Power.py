# Challenge statement: https://www.hackerrank.com/challenges/python-power-mod-power/problem
# 
# So far, we have only heard of Python's powers. Now, we will witness them!
# 
# Powers or exponents in Python can be calculated using the built-in power function. Call the power function  as shown below:
# >>> pow(a,b) 
# or
# >>> a**b
# 
# It's also possible to calculate a^b mod m.
# >>> pow(a,b,m)  
# This is very helpful in computations where you have to print the resultant % mod.
# 
# Note: Here, a and b can be floats or negatives, but, if a third argument is present, b cannot be negative.
# 
# Note: Python has a math module that has its own pow(). It takes two arguments and returns a float. It is uncommon to use math.pow().
# 
# Task
# You are given three integers: a, b, and m. Print two lines.
# On the first line, print the result of pow(a,b). On the second line, print the result of pow(a,b,m).
# 
# Input Format
# The first line contains a, the second line contains b, and the third line contains m.
# 
# Constraints
# - 1 <= a <= 10
# - 1 <= b <= 10
# - 2 <= m <= 1000
# 
# Sample Input
# 3
# 4
# 5
# 
# Sample Output
# 81
# 1


if __name__ == "__main__":
    a, b, m = int(input()), int(input()), int(input())

    print(pow(a,b))
    print(pow(a,b,m))