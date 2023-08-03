# Little Professor
# One of David’s first toys as a child, funny enough, was Little Professor, a “calculator” that would generate ten different math problems for David to solve. For instance, if the toy were to display 4 + 0 = , David would (hopefully) answer with 4. If the toy were to display 4 + 1 = , David would (hopefully) answer with 5. If David were to answer incorrectly, the toy would display EEE. And after three incorrect answers for the same problem, the toy would simply display the correct answer (e.g., 4 + 0 = 4 or 4 + 1 = 5).
# 
# In a file called professor.py, implement a program that:
# 
# - Prompts the user for a level, n. If the user does not input 1, 2, or 3, the program should prompt again.
# - Randomly generates ten (10) math problems formatted as X + Y = , wherein each of X and Y is a non-negative integer with n digits. No need to support operations other than addition (+).
# - Prompts the user to solve each of those problems. If an answer is not correct (or not even a number), the program should output EEE and prompt the user again, allowing the user up to three tries in total for that problem. If the user has still not answered correctly after three tries, the program should output the correct answer.
# - The program should ultimately output the user’s score: the number of correct answers out of 10.
# 
# Structure your program as follows, wherein get_level prompts (and, if need be, re-prompts) the user for a level and returns 1, 2, or 3, and generate_integer returns a randomly generated non-negative integer with level digits or raises a ValueError if level is not 1, 2, or 3:
# 
# import random
# 
# 
# def main():
#     ...
# 
# 
# def get_level():
#     ...
# 
# 
# def generate_integer(level):
#     ...
# 
# 
# if __name__ == "__main__":
#     main()
# 
# Hints
# - Note that you can raise an exception like ValueError with code like:
# raise ValueError
# 
# - Note that the random module comes with quite a few functions, per docs.python.org/3/library/random.html.
# 
# Demo
# $ python professor.py                                                           
# Level: 1                                                                        
# 2 + 8 = 10                                                                      
# 3 + 7 = 10                                                                      
# 9 + 4 = 10                                                                      
# EEE                                                                             
# 9 + 4 = 11                                                                      
# EEE                                                                             
# 9 + 4 = 12                                                                      
# EEE                                                                             
# 9 + 4 = 13
# 4 + 7 = 11                                                                      
# 6 + 4 = 10                                                                      
# 7 + 4 = 11                                                                      
# 1 + 4 = cat
# EEE                                                                             
# 1 + 4 = dog                                                                     
# EEE                                                                             
# 1 + 4 = bird                                                                    
# EEE                                                                             
# 1 + 4 = 5                                                                       
# 9 + 3 = 12                                                                      
# 2 + 2 = 4                                                                       
# 0 + 0 = 0                                                                       
# Score: 8

import random

def main():
    level = get_level()

    score = 10
    for _ in range(10):
        x = generate_integer(level)
        y = generate_integer(level)
        errors = 0

        while(errors < 3):
            try:
                    result = int(input(f"{x} + {y} = "))
                    if result != (x + y):
                        print("EEE")
                        errors += 1
                    else:
                        break
            except ValueError:
                print("EEE")
                errors += 1
                pass

        if errors == 3:
            print(f"{x} + {y} =", (x + y))
            score -= 1

    print("Score:", score)


def get_level():
    while True:
        try:
            level = int(input("Level: "))
            if level not in [1, 2, 3]: continue
            else: return level
        except ValueError:
            pass


def generate_integer(level):
    if level == 1: return random.randint(0, 9)
    elif level == 2: return random.randint(10, 99)
    else: return random.randint(100, 999)


if __name__ == "__main__":
    main()