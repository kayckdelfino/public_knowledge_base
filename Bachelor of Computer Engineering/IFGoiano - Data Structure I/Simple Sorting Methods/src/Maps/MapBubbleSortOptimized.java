package src.Maps;

import java.util.HashMap;

import src.Sorts.BubbleSortOptimized;

public class MapBubbleSortOptimized {
    public static HashMap<Integer, HashMap<String, HashMap<String, Long>>> map(HashMap<Integer, int[]> vectorA, 
            HashMap<Integer, int[]> vectorB, HashMap<Integer, int[]> vectorC, int[] sizes) {
        // Logic to populate the HashMap for BubbleSortOptimized ({number of elements = {"vector" = {"comparisons" = int, "swaps" = int, "executionTime" = int}}})
        HashMap<Integer, HashMap<String, HashMap<String, Long>>> BubbleSortOptimizedMap = new HashMap<>();

        for (int size : sizes) {
            // Getting statistics for each type of vector
            BubbleSortOptimized boA = new BubbleSortOptimized(vectorA.get(size));
            BubbleSortOptimized boB = new BubbleSortOptimized(vectorB.get(size));
            BubbleSortOptimized boC = new BubbleSortOptimized(vectorC.get(size));

            // Populating HashMaps
            BubbleSortOptimizedMap.put(size, new HashMap<>());

            // Vector A
            HashMap<String, HashMap<String, Long>> BubbleSortOptimizedMapIntermediateA = BubbleSortOptimizedMap.get(size);
            BubbleSortOptimizedMapIntermediateA.put("vectorA", new HashMap<>());
            HashMap<String, Long> BubbleSortOptimizedMapInternalA = BubbleSortOptimizedMapIntermediateA.get("vectorA");
            BubbleSortOptimizedMapInternalA.put("comparisons", boA.getComparisons());
            BubbleSortOptimizedMapInternalA.put("swaps", boA.getSwaps());
            BubbleSortOptimizedMapInternalA.put("executionTime", boA.getExecutionTime());

            // Vector B
            HashMap<String, HashMap<String, Long>> BubbleSortOptimizedMapIntermediateB = BubbleSortOptimizedMap.get(size);
            BubbleSortOptimizedMapIntermediateB.put("vectorB", new HashMap<>());
            HashMap<String, Long> BubbleSortOptimizedMapInternalB = BubbleSortOptimizedMapIntermediateB.get("vectorB");
            BubbleSortOptimizedMapInternalB.put("comparisons", boB.getComparisons());
            BubbleSortOptimizedMapInternalB.put("swaps", boB.getSwaps());
            BubbleSortOptimizedMapInternalB.put("executionTime", boB.getExecutionTime());

            // Vector C
            HashMap<String, HashMap<String, Long>> BubbleSortOptimizedMapIntermediateC = BubbleSortOptimizedMap.get(size);
            BubbleSortOptimizedMapIntermediateC.put("vectorC", new HashMap<>());
            HashMap<String, Long> BubbleSortOptimizedMapInternalC = BubbleSortOptimizedMapIntermediateC.get("vectorC");
            BubbleSortOptimizedMapInternalC.put("comparisons", boC.getComparisons());
            BubbleSortOptimizedMapInternalC.put("swaps", boC.getSwaps());
            BubbleSortOptimizedMapInternalC.put("executionTime", boC.getExecutionTime());
        }

        return BubbleSortOptimizedMap;
    }
}
