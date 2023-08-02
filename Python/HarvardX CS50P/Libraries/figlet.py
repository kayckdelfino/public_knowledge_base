# Frank, Ian and Glen’s Letters
# FIGlet, named after Frank, Ian, and Glen’s letters, is a program from the early 1990s for making large letters out of ordinary text, a form of ASCII art:
# 
#  _ _ _          _   _     _
# | (_) | _____  | |_| |__ (_)___
# | | | |/ / _ \ | __| '_ \| / __|
# | | |   <  __/ | |_| | | | \__ \
# |_|_|_|\_\___|  \__|_| |_|_|___/
# 
# Among the fonts supported by FIGlet are those at figlet.org/examples.html.
# 
# FIGlet has since been ported to Python as a module called pyfiglet.
# 
# In a file called figlet.py, implement a program that:
# 
# - Expects zero or two command-line arguments:
#     - Zero if the user would like to output text in a random font.
#     - Two if the user would like to output text in a specific font, in which case the first of the two should be -f or --font, and the second of the two should be the name of the font.
# - Prompts the user for a str of text.
# - Outputs that text in the desired font.
# 
# If the user provides two command-line arguments and the first is not -f or --font or the second is not the name of a font, the program should exit via sys.exit with an error message.
# 
# Hints
# - You can install pyfiglet with:
# pip install pyfiglet
# 
# - The documentation for pyfiglet isn’t very clear, but you can use the module as follows:
# from pyfiglet import Figlet
# 
# figlet = Figlet()
# 
# - You can then get a list of available fonts with code like this:
# figlet.getFonts()
# 
# - You can set the font with code like this, wherein f is the font’s name as a str:
# figlet.setFont(font=f)
# 
# - And you can output text in that font with code like this, wherein s is that text as a str:
# print(figlet.renderText(s))
# 
# - Note that the random module comes with quite a few functions, per docs.python.org/3/library/random.html.
# 
# Demo
# $ python figlet.py
# Input: hello, world
# Output:
#  _          _ _                             _     _                             
# | |__   ___| | | ___    __      _____  _ __| | __| |                            
# | '_ \ / _ \ | |/ _ \   \ \ /\ / / _ \| '__| |/ _` |                            
# | | | |  __/ | | (_) |   \ V  V / (_) | |  | | (_| |                            
# |_| |_|\___|_|_|\___( )   \_/\_/ \___/|_|  |_|\__,_|                            
#                     |/                                                          
#                                                                                 
# $ python figlet.py -f slant
# Input: hello, world
# Output:
#     __         ____                               __    __                      
#    / /_  ___  / / /___       _      ______  _____/ /___/ /                      
#   / __ \/ _ \/ / / __ \     | | /| / / __ \/ ___/ / __  /                       
#  / / / /  __/ / / /_/ /     | |/ |/ / /_/ / /  / / /_/ /                        
# /_/ /_/\___/_/_/\____( )    |__/|__/\____/_/  /_/\__,_/                         
#                      |/                                                         
# 

from pyfiglet import Figlet
import sys
import random

figlet = Figlet()

if len(sys.argv) == 1:
    f = random.choice(figlet.getFonts())
elif len(sys.argv) == 3:
    if sys.argv[1] == "-f" or sys.argv[1] == "--font":
        f = sys.argv[2]
        if f not in figlet.getFonts(): sys.exit("Invalid usage")
    else: sys.exit("Invalid usage")
else:
    sys.exit("Invalid usage")


figlet.setFont(font=f)
print("Output:", figlet.renderText(input("Input: ")), sep="\n")