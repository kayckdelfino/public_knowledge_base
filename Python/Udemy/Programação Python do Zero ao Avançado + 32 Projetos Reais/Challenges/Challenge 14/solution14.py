# For this challenge, I want you to create a loop that prints the numbers 1 to 10, but stops printing once it reaches 5 using the "break" command. Then create a second loop that prints the numbers 1 through 10, but skips printing the number 5 using the "continue" command.


print("Loop with break:")
for number in range(1, 11):
    if number > 5:
        break
    print(number)

print("\nLoop with continue:")
for number in range(1, 11):
    if number == 5:
        continue
    print(number)