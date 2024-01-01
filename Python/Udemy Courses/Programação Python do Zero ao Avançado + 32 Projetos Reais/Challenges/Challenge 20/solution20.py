# For this challenge, create a list of numbers from 1 to 10. Use a "for loop" to iterate over the list. If the current iteration number is even, print "Number [number] is even". If the number is odd, print "Number [number] is odd".


numbers = list(range(1,11))

for i in numbers:
    if i % 2 == 0:
        print(f"The number {i} is even")
    else:
        print(f"The number {i} is odd")