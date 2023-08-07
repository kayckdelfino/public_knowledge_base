# Pizza Py
# Perhaps the most popular place for pizza in Harvard Square is Pinocchio’s Pizza & Subs, aka Noch’s, known for its Sicilian pizza, which is “a deep-dish or thick-crust pizza.”
# 
# Students tend to buy pizza by the slice, but Pinocchio’s also has whole pizzas on its menu too, per this CSV file of Sicilian pizzas, sicilian.csv, below:
# 
# Sicilian Pizza,Small,Large
# Cheese,$25.50,$39.95
# 1 item,$27.50,$41.95
# 2 items,$29.50,$43.95
# 3 items,$31.50,$45.95
# Special,$33.50,$47.95
# 
# See regular.csv for a CSV file of regular pizzas as well.
# 
# Of course, a CSV file isn’t the most customer-friendly format to look at. Prettier might be a table, formatted as ASCII art, like this one:
# 
# +------------------+---------+---------+
# | Sicilian Pizza   | Small   | Large   |
# +==================+=========+=========+
# | Cheese           | $25.50  | $39.95  |
# +------------------+---------+---------+
# | 1 item           | $27.50  | $41.95  |
# +------------------+---------+---------+
# | 2 items          | $29.50  | $43.95  |
# +------------------+---------+---------+
# | 3 items          | $31.50  | $45.95  |
# +------------------+---------+---------+
# | Special          | $33.50  | $47.95  |
# +------------------+---------+---------+
# 
# In a file called pizza.py, implement a program that expects exactly one command-line argument, the name (or path) of a CSV file in Pinocchio’s format, and outputs a table formatted as ASCII art using tabulate, a package on PyPI at pypi.org/project/tabulate. Format the table using the library’s grid format. If the user does not specify exactly one command-line argument, or if the specified file’s name does not end in .csv, or if the specified file does not exist, the program should instead exit via sys.exit.
# 
# Hints
# - Recall that the csv module comes with quite a few methods, per docs.python.org/3/library/csv.html, among which are reader, per docs.python.org/3/library/csv.html#csv.reader, and DictReader, per docs.python.org/3/library/csv.html#csv.DictReader.
# - Note that open can raise a FileNotFoundError, per docs.python.org/3/library/exceptions.html#FileNotFoundError.
# - Note that the tabulate package comes with just one function, per pypi.org/project/tabulate. You can install the package with:
# pip install tabulate
# 
# Demo
# $ python pizza.py
# Too few command-line arguments
# $ python pizza.py foo
# Not a CSV file
# $ python pizza.py foo bar
# Too many command-line arguments
# $ python pizza.py regular.csv
# +-----------------+---------+---------+
# | Regular Pizza   | Small   | Large   |
# +=================+=========+=========+
# | Cheese          | $13.50  | $18.95  |
# +-----------------+---------+---------+
# | 1 topping       | $14.75  | $20.95  |
# +-----------------+---------+---------+
# | 2 toppings      | $15.95  | $22.95  |
# +-----------------+---------+---------+
# | 3 toppings      | $16.95  | $24.95  |
# +-----------------+---------+---------+
# | Special         | $18.50  | $26.95  |
# +-----------------+---------+---------+

from tabulate import tabulate
import sys
import csv

if len(sys.argv) < 2: sys.exit("Too few command-line arguments")
elif len(sys.argv) > 2: sys.exit("Too many command-line arguments")
elif ".csv" not in sys.argv[1]: sys.exit("Not a CSV file")

pizza_list = []
try:
    with open(f"{sys.argv[1]}") as file:
        reader = csv.reader(file)
        for type, small_price, large_price in reader:
            pizza_list.append([type, small_price, large_price])
except FileNotFoundError:
    sys.exit("File does not exist")
else:
    print(tabulate(pizza_list, headers="firstrow", tablefmt="grid"))