# Challenge statement: https://www.hackerrank.com/challenges/np-mean-var-and-std/problem
# 
# mean
# The mean tool computes the arithmetic mean along the specified axis.
# 
# import numpy
# 
# my_array = numpy.array([ [1, 2], [3, 4] ])
# 
# print numpy.mean(my_array, axis = 0)        #Output : [ 2.  3.]
# print numpy.mean(my_array, axis = 1)        #Output : [ 1.5  3.5]
# print numpy.mean(my_array, axis = None)     #Output : 2.5
# print numpy.mean(my_array)                  #Output : 2.5
# By default, the axis is None. Therefore, it computes the mean of the flattened array.
# 
# var
# The var tool computes the arithmetic variance along the specified axis.
# 
# import numpy
# 
# my_array = numpy.array([ [1, 2], [3, 4] ])
# 
# print numpy.var(my_array, axis = 0)         #Output : [ 1.  1.]
# print numpy.var(my_array, axis = 1)         #Output : [ 0.25  0.25]
# print numpy.var(my_array, axis = None)      #Output : 1.25
# print numpy.var(my_array)                   #Output : 1.25
# By default, the axis is None. Therefore, it computes the variance of the flattened array.
# 
# std
# The std tool computes the arithmetic standard deviation along the specified axis.
# 
# import numpy
# 
# my_array = numpy.array([ [1, 2], [3, 4] ])
# 
# print numpy.std(my_array, axis = 0)         #Output : [ 1.  1.]
# print numpy.std(my_array, axis = 1)         #Output : [ 0.5  0.5]
# print numpy.std(my_array, axis = None)      #Output : 1.11803398875
# print numpy.std(my_array)                   #Output : 1.11803398875
# By default, the axis is None. Therefore, it computes the standard deviation of the flattened array.
# 
# Task
# You are given a 2-D array of size N X M.
# Your task is to find:
# 
# 1. The mean along axis 1
# 2. The var along axis 0
# 3. The std along axis None
# 
# Input Format
# The first line contains the space separated values of N and M.
# The next N lines contains M space separated integers.
# 
# Output Format
# First, print the mean.
# Second, print the var.
# Third, print the std.
# 
# Sample Input
# 2 2
# 1 2
# 3 4
# 
# Sample Output
# [ 1.5  3.5]
# [ 1.  1.]
# 1.11803398875


if __name__ == "__main__":
    import numpy as np

    n, m = map(int, input().split())

    arr = []
    for _ in range(n):
        arr.append(np.array(input().split(), int))
                   
    print(np.mean(arr, axis = 1), 
          np.var(arr, axis = 0), 
          round(np.std(arr), 11), 
          sep = "\n")