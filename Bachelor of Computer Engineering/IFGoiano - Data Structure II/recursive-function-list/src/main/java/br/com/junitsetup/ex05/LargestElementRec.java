package br.com.junitsetup.ex05;

/**
 * A class to find the largest element in an array using recursion.
 */
public class LargestElementRec {

    /**
     * Finds the largest element in an array recursively.
     * 
     * @param array      The array of integers.
     * @param index      The current index being evaluated.
     * @param currentMax The current maximum value found so far.
     * @return The largest element in the array.
     */
    public static int calc(int[] array, int index, int currentMax) {
        if (index == array.length) {
            // Base case: if the index reaches the end of the array, return the current
            // maximum
            return currentMax;
        } else {
            // Recursive case: update the current maximum if the current element is greater
            if (array[index] > currentMax) {
                currentMax = array[index];
            }
            return calc(array, index + 1, currentMax);
        }
    }
}