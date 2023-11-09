package src.Sorts;

import java.util.Arrays;

// Time Complexity  |  Comparisons                  |  Swaps
// Best Case: O(n)  |  Best Case: C(n) = n-1        |  Best Case: S(n) = 0
// Average Case: O(n^2) |  Average Case: C(n) = (n*(n-1))/4 |  Average Case: S(n) = (n*(n-1))/4
// Worst Case: O(n^2)  |  Worst Case: C(n) = (n*(n-1))/2  |  Worst Case: S(n) = (n*(n-1))/2
public class BubbleSortOptimized {
    private long comparisons = 0;
    private long swaps = 0;
    private long executionTime = 0;

    public long getComparisons() {
        return comparisons;
    }

    public long getSwaps() {
        return swaps;
    }

    public long getExecutionTime() {
        return executionTime;
    }

    public BubbleSortOptimized(int[] arr) {
        getStatistics(arr);
    }

    // Method used locally
    private void getStatistics(int[] arr) {
        int[] arrCopy = Arrays.copyOf(arr, arr.length);

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < (arrCopy.length - 1); i++) {
            boolean swapped = false;
            for (int j = (arrCopy.length - 1); j > i; j--) {
                this.comparisons++;
                if (arrCopy[j] < arrCopy[j - 1]) {
                    int temp = arrCopy[j];
                    arrCopy[j] = arrCopy[j - 1];
                    arrCopy[j - 1] = temp;
                    this.swaps++;
                    swapped = true;
                }
            }

            if (!swapped) break;
        }
        this.executionTime = System.currentTimeMillis() - startTime;
    }

    // Method that can be used externally
    public static int[] sort(int[] arr) {
        int[] arrCopy = Arrays.copyOf(arr, arr.length);

        for (int i = 0; i < (arrCopy.length - 1); i++) {
            boolean swapped = false;
            for (int j = (arrCopy.length - 1); j > i; j--) {
                if (arrCopy[j] < arrCopy[j - 1]) {
                    int temp = arrCopy[j];
                    arrCopy[j] = arrCopy[j - 1];
                    arrCopy[j - 1] = temp;
                    swapped = true;
                }
            }

            if (!swapped) break;
        }
        return arrCopy;
    }
}
