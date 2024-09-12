# Challenge statement: https://www.hackerrank.com/challenges/python-sort-sort/problem
# 
# You are given a spreadsheet that contains a list of N athletes and their details (such as age, height, weight and so on). You are required to sort the data based on the Kth attribute and print the final resulting table. Follow the example given below for better understanding.
# 
# [image](https://s3.amazonaws.com/hr-assets/0/1514874268-6fabad07aa-AthleteSort2.png)
# 
# Note that K is indexed from 0 to M - 1, where M is the number of attributes.
# 
# Note: If two attributes are the same for different rows, for example, if two atheletes are of the same age, print the row that appeared first in the input.
# 
# Input Format
# The first line contains N and M separated by a space.
# The next N lines each contain M elements.
# The last line contains K.
# 
# Constraints
# 1 <= N, M <= 1000
# 0 <= K < M
# Each element <= 1000
# 
# Output Format
# Print the N lines of the sorted table. Each line should contain the space separated elements. Check the sample below for clarity.
# 
# Sample Input 0
# 5 3
# 10 2 5
# 7 1 0
# 9 9 9
# 1 23 12
# 6 5 9
# 1
# 
# Sample Output 0
# 7 1 0
# 10 2 5
# 6 5 9
# 9 9 9
# 1 23 12
# 
# Explanation 0
# The details are sorted based on the second attribute, since K is zero-indexed. 


if __name__ == '__main__':
    n, m = map(int, input().split())
    arr = [list(map(int, input().split())) for _ in range(n)]

    k = int(input())
    arr = sorted(arr, key=lambda x: x[k])

    for a in arr:
        print(*a)