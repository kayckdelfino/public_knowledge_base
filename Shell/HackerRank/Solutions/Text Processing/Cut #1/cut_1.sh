#!/bin/bash

# Challenge statement: https://www.hackerrank.com/challenges/text-processing-cut-1/problem
# 
# Given N lines of input, print the 3rd character from each line as a new line of output. It is guaranteed that each of the n lines of input will have a 3rd character.
# 
# Input Format
# A text file containing N lines of ASCII characters.
# 
# Constraints
# - 1 <= N <= 100
# 
# Output Format
# For each line of input, print its 3rd character on a new line for a total of N lines of output.
# 
# Sample Input
# Hello
# World
# how are you
# 
# Sample Output
# l
# r
# w


while read line
do
    echo $line | cut -c3
done