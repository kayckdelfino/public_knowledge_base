# Guessing Game
# I’m thinking of a number between 1 and 100…
# 
# What is it?
# In a file called game.py, implement a program that:
# 
# - Prompts the user for a level, n. If the user does not input a positive integer, the program should prompt again.
# - Randomly generates an integer between 1 and n, inclusive, using the random module.
# - Prompts the user to guess that integer. If the guess is not a positive integer, the program should prompt the user again.
#   - If the guess is smaller than that integer, the program should output Too small! and prompt the user again.
#   - If the guess is larger than that integer, the program should output Too large! and prompt the user again.
#   - If the guess is the same as that integer, the program should output Just right! and exit.
# 
# Hints
# - Note that the random module comes with quite a few functions, per docs.python.org/3/library/random.html.
# 
# Demo
# $ python game.py
# Level: 1
# Guess: 1
# Just right!
# $ python game.py
# Level: 10
# Guess: 5
# Too large!
# Guess: 3
# Just right!
# $ python game.py
# Level: cat
# Level: 10
# Guess: cat
# Guess: dog
# Guess: 5
# Too large!
# Guess: 2
# Too small!
# Guess: 3
# Just right!

import random

level_stored = False
while True:
    try:
        if not level_stored:
            level = int(input("Level: "))
            if level < 0: continue
            else: level_stored = True
        else:
            number = random.randint(1, level)
            guess = int(input("Guess: "))
            if guess < 0: continue
            else:
                if guess < number: print("Too small!")
                elif guess > number: print("Too large!")
                else:
                    print("Just right!")
                    break
    except ValueError:
        pass