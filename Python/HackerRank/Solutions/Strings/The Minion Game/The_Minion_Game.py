# Challenge statement: https://www.hackerrank.com/challenges/the-minion-game/problem
# 
# Kevin and Stuart want to play the 'The Minion Game'.
# 
# Game Rules
# 
# Both players are given the same string, S.
# Both players have to make substrings using the letters of the string S.
# Stuart has to make words starting with consonants.
# Kevin has to make words starting with vowels.
# The game ends when both players have made all possible substrings.
# 
# Scoring
# A player gets +1 point for each occurrence of the substring in the string S.
# 
# For Example:
# String S = BANANA
# Kevin's vowel beginning word = ANA
# Here, ANA occurs twice in BANANA. Hence, Kevin will get 2 Points.
# 
# For better understanding, see the image below:
# [banana.png](https://s3.amazonaws.com/hr-challenge-images/9693/1450330231-04db904008-banana.png)
# 
# Your task is to determine the winner of the game and their score.
# 
# Function Description
# Complete the minion_game in the editor below.
# 
# minion_game has the following parameters:
# - string string: the string to analyze
# 
# Prints
# - string: the winner's name and score, separated by a space on one line, or Draw if there is no winner
# 
# Input Format
# A single line of input containing the string S.
# Note: The string S will contain only uppercase letters: [A - Z].
# 
# Constraints
# 0 < len(S) <= 10^6
# 
# Sample Input
# BANANA
# 
# Sample Output
# Stuart 12
# 
# Note :
# Vowels are only defined as AEIOU. In this problem, Y is not considered a vowel.


def minion_game(string):
    # your code goes here
    vowels = "AEIOU"
    kevin_sc = 0
    stuart_sc = 0
    length = len(string)

    for i in range(length):
        if string[i] in vowels:
            kevin_sc += length - i
        else:
            stuart_sc += length - i

    if kevin_sc > stuart_sc:
        print(f"Kevin {kevin_sc}")
    elif stuart_sc > kevin_sc:
        print(f"Stuart {stuart_sc}")
    else:
        print("Draw")
    

if __name__ == '__main__':
    s = input()
    minion_game(s)