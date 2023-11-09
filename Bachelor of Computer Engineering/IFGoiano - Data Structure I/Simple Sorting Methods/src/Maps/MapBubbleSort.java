package src.Maps;

import java.util.HashMap;

import src.Sorts.BubbleSort;

public class MapBubbleSort {
    public static HashMap<Integer, HashMap<String, HashMap<String, Long>>> map(HashMap<Integer, int[]> vectorA,
            HashMap<Integer, int[]> vectorB, HashMap<Integer, int[]> vectorC, int[] sizes) {
        // Logic to populate the HashMap for BubbleSort ({number of elements = {"vector" = {"comparisons" = long, "swaps" = long, "executionTime" = long}}})
        HashMap<Integer, HashMap<String, HashMap<String, Long>>> BubbleSortMap = new HashMap<>();

        for (int size : sizes) {
            // Getting statistics for each type of vector
            BubbleSort bA = new BubbleSort(vectorA.get(size));
            BubbleSort bB = new BubbleSort(vectorB.get(size));
            BubbleSort bC = new BubbleSort(vectorC.get(size));

            // Populating HashMaps
            BubbleSortMap.put(size, new HashMap<>());

            // Vector A
            HashMap<String, HashMap<String, Long>> BubbleSortMapIntermediateA = BubbleSortMap.get(size);
            BubbleSortMapIntermediateA.put("vectorA", new HashMap<>());
            HashMap<String, Long> BubbleSortMapInternalA = BubbleSortMapIntermediateA.get("vectorA");
            BubbleSortMapInternalA.put("comparisons", bA.getComparisons());
            BubbleSortMapInternalA.put("swaps", bA.getSwaps());
            BubbleSortMapInternalA.put("executionTime", bA.getExecutionTime());

            // Vector B
            HashMap<String, HashMap<String, Long>> BubbleSortMapIntermediateB = BubbleSortMap.get(size);
            BubbleSortMapIntermediateB.put("vectorB", new HashMap<>());
            HashMap<String, Long> BubbleSortMapInternalB = BubbleSortMapIntermediateB.get("vectorB");
            BubbleSortMapInternalB.put("comparisons", bB.getComparisons());
            BubbleSortMapInternalB.put("swaps", bB.getSwaps());
            BubbleSortMapInternalB.put("executionTime", bB.getExecutionTime());

            // Vector C
            HashMap<String, HashMap<String, Long>> BubbleSortMapIntermediateC = BubbleSortMap.get(size);
            BubbleSortMapIntermediateC.put("vectorC", new HashMap<>());
            HashMap<String, Long> BubbleSortMapInternalC = BubbleSortMapIntermediateC.get("vectorC");
            BubbleSortMapInternalC.put("comparisons", bC.getComparisons());
            BubbleSortMapInternalC.put("swaps", bC.getSwaps());
            BubbleSortMapInternalC.put("executionTime", bC.getExecutionTime());
        }

        return BubbleSortMap;
    }
}
