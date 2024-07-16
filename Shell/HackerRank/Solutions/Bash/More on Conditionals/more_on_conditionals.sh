#!/bin/bash

# Challenge statement: https://www.hackerrank.com/challenges/bash-tutorials---more-on-conditionals/problem
# 
# Given three integers (X, Y, and Z) representing the three sides of a triangle, identify whether the triangle is scalene, isosceles, or equilateral.
# 
# - If all three sides are equal, output EQUILATERAL.
# - Otherwise, if any two sides are equal, output ISOSCELES.
# - Otherwise, output SCALENE.
# 
# Input Format
# Three integers, each on a new line.
# 
# Constraints
# - 1 <= X, Y, Z <= 1000
# 
# The sum of any two sides will be greater than the third.
# 
# Output Format
# One word: either "SCALENE" or "EQUILATERAL" or "ISOSCELES" (quotation marks excluded).
# 
# Sample Input
# 
# Sample Input 1
# 2
# 3
# 4
# 
# Sample Input 2
# 6
# 6
# 6  
# 
# Sample Output
# 
# Sample Output 1
# SCALENE
# 
# Sample Output 2
# EQUILATERAL  


read a
read b 
read c

if (($a == $b && $b == $c && $c == $b))
then
    echo 'EQUILATERAL'
elif (($a != $b && $a != $c && $b != $c))
then
    echo 'SCALENE'
else
    echo 'ISOSCELES'
fi