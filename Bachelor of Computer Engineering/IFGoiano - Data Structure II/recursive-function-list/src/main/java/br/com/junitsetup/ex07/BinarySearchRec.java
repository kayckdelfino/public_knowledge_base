package br.com.junitsetup.ex07;

/**
 * A class to perform binary search on an array using recursion.
 */
public class BinarySearchRec {

    /**
     * Performs binary search on a sorted array recursively.
     * 
     * @param array  The sorted array of integers.
     * @param target The target value to search for.
     * @param start  The starting index of the search range.
     * @param end    The ending index of the search range.
     * @return The index of the target value if found, otherwise -1.
     */
    public static int search(int[] array, int target, int start, int end) {
        if (start > end) {
            // Base case: if the start index is greater than the end index, target is not
            // found
            return -1;
        }

        int middle = (start + end) / 2;

        if (array[middle] == target) {
            // Base case: if the middle element is the target, return its index
            return middle;
        } else if (array[middle] > target) {
            // If the middle element is greater than the target, search the left half
            return search(array, target, start, middle - 1);
        } else {
            // If the middle element is less than the target, search the right half
            return search(array, target, middle + 1, end);
        }
    }
}