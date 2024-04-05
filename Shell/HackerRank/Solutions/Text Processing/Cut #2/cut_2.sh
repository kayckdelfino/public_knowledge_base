#!/bin/bash

# Challenge statement: https://www.hackerrank.com/challenges/text-processing-cut-2/problem
# 
# Display the 2nd and 7th character from each line of text.
# 
# Input Format
# A text file with N lines of ASCII text only.
# 
# Constraints
# - 1 <= N <= 100
# 
# Output Format
# The output should contain N lines. Each line should contain just two characters at 2nd the and the 7th position of the corresponding input line.
# 
# Sample Input
# Hello
# World
# how are you
# 
# Sample Output
# e
# o
# oe


while read line
do 
    echo $line | cut -c2,7
done