#!/bin/bash

# Challenge statement: https://www.hackerrank.com/challenges/bash-tutorials---looping-and-skipping/problem
# 
# Your task is to use for loops to display only odd natural numbers from 1 to 99.
# 
# Input Format
# There is no input.
# 
# Constraints
# -
# 
# Output Format
# 1
# 3
# 5
# .
# .
# .
# .
# .
# 99  
# 
# Sample Input
# -
# 
# Sample Output
# 1
# 3
# 5
# .
# .
# .
# .
# .
# 99  
# 
# Explanation
# -


for n in {1..99..2}
do
    echo $n
done