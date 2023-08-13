# Mr. Vincent works in a door mat manufacturing company. One day, he designed a new door mat with the following specifications:
# 
# - Mat size must be N x M. (N is an odd natural number, and M is 3 times N.)
# - The design should have 'WELCOME' written in the center.
# - The design pattern should only use |, . and - characters.
# 
# Sample Designs
# 
#     Size: 7 x 21 
#     ---------.|.---------
#     ------.|..|..|.------
#     ---.|..|..|..|..|.---
#     -------WELCOME-------
#     ---.|..|..|..|..|.---
#     ------.|..|..|.------
#     ---------.|.---------
#     
#     Size: 11 x 33
#     ---------------.|.---------------
#     ------------.|..|..|.------------
#     ---------.|..|..|..|..|.---------
#     ------.|..|..|..|..|..|..|.------
#     ---.|..|..|..|..|..|..|..|..|.---
#     -------------WELCOME-------------
#     ---.|..|..|..|..|..|..|..|..|.---
#     ------.|..|..|..|..|..|..|.------
#     ---------.|..|..|..|..|.---------
#     ------------.|..|..|.------------
#     ---------------.|.---------------
# 
# Input Format
# A single line containing the space separated values of N and M.
# 
# Constraints
# - 5 < N < 101
# - 15 < M < 303
# 
# Output Format
# Output the design pattern.
# 
# Sample Input
# 9 27
# 
# Sample Output
# ------------.|.------------
# ---------.|..|..|.---------
# ------.|..|..|..|..|.------
# ---.|..|..|..|..|..|..|.---
# ----------WELCOME----------
# ---.|..|..|..|..|..|..|.---
# ------.|..|..|..|..|.------
# ---------.|..|..|.---------
# ------------.|.------------


def main():
    n, m = map(int, input().split())
    print_door_mat(n, m)


def print_door_mat(rows, cols):
    pattern = [(".|." * (2 * i + 1)).center(cols, "-") for i in range(rows // 2)]
    
    welcome = "WELCOME".center(cols, "-")
    
    door_mat = "\n".join(pattern + [welcome] + pattern[::-1])
    
    print(door_mat)

    
if __name__ == "__main__":
    main()