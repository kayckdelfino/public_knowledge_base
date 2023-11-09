package src.Sorts;

import java.util.Arrays;

// Time Complexity  |  Comparisons                      |  Swaps
// Best Case: O(n^2)  |  Best Case: C(n) = (n*(n-1))/2  |  Best Case: S(n) = n-1
// Average Case: O(n^2) |  Average Case: C(n) = (n*(n-1))/2 |  Average Case: S(n) = n-1
// Worst Case: O(n^2)  |  Worst Case: C(n) = (n*(n-1))/2   |  Worst Case: S(n) = n-1
public class SelectionSort {
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

    public SelectionSort(int[] arr) {
        getStatistics(arr);
    }

    // Method used locally
    private void getStatistics(int[] arr) {
        int[] arrCopy = Arrays.copyOf(arr, arr.length);
    
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < (arrCopy.length - 1); i++) {
            int smallerIndex = i;
            for (int j = i + 1; j < arrCopy.length; j++) {
                this.comparisons++;
                if (arrCopy[j] < arrCopy[smallerIndex])
                    smallerIndex = j;
            }
            if (i != smallerIndex) { 
                int smallerNumber = arrCopy[smallerIndex];
                arrCopy[smallerIndex] = arrCopy[i];
                arrCopy[i] = smallerNumber;
                this.swaps++;
            }
        }
        this.executionTime = System.currentTimeMillis() - startTime;
    }
    

    // Method that can be used externally
    public static int[] sort(int[] arr) {
        int[] arrCopy = Arrays.copyOf(arr, arr.length);
    
        for (int i = 0; i < (arrCopy.length - 1); i++) {
            int smallerIndex = i;
            for (int j = i + 1; j < arrCopy.length; j++) {
                if (arrCopy[j] < arrCopy[smallerIndex])
                    smallerIndex = j;
            }
            if (i != smallerIndex) { 
                int smallerNumber = arrCopy[smallerIndex];
                arrCopy[smallerIndex] = arrCopy[i];
                arrCopy[i] = smallerNumber;
            }
        }

        return arrCopy;
    }
}
