#!/bin/bash

# Challenge statement: https://www.hackerrank.com/challenges/bash-tutorials---a-personalized-echo/problem
# 
# Write a Bash script which accepts name as input and displays the greeting "Welcome (name)"
# 
# Input Format
# There is one line of text, name.
# 
# Output Format
# One line: "Welcome (name)" (quotation marks excluded).
# The evaluation will be case-sensitive.
# 
# Sample Input 0
# Dan  
# 
# Sample Output 0
# Welcome Dan  
# 
# Sample Input 1
# Prashant
# 
# Sample Output 1
# Welcome Prashant


read name
echo "Welcome $name"