package src.Maps;

import java.util.HashMap;

import src.Sorts.InsertionSort;

public class MapInsertionSort {
    public static HashMap<Integer, HashMap<String, HashMap<String, Long>>> map(HashMap<Integer, int[]> vectorA,
            HashMap<Integer, int[]> vectorB, HashMap<Integer, int[]> vectorC, int[] sizes) {
        // Logic to populate the HashMap for InsertionSort ({number of elements = {"vector" = {"comparisons" = long, "swaps" = long, "executionTime" = long}}})
        HashMap<Integer, HashMap<String, HashMap<String, Long>>> InsertionSortMap = new HashMap<>();

        for (int size : sizes) {
            // Getting statistics for each type of vector
            InsertionSort iA = new InsertionSort(vectorA.get(size));
            InsertionSort iB = new InsertionSort(vectorB.get(size));
            InsertionSort iC = new InsertionSort(vectorC.get(size));

            // Populating HashMaps
            InsertionSortMap.put(size, new HashMap<>());

            // Vector A
            HashMap<String, HashMap<String, Long>> InsertionSortMapIntermediateA = InsertionSortMap.get(size);
            InsertionSortMapIntermediateA.put("vectorA", new HashMap<>());
            HashMap<String, Long> InsertionSortMapInternalA = InsertionSortMapIntermediateA.get("vectorA");
            InsertionSortMapInternalA.put("comparisons", iA.getComparisons());
            InsertionSortMapInternalA.put("swaps", iA.getSwaps());
            InsertionSortMapInternalA.put("executionTime", iA.getExecutionTime());

            // Vector B
            HashMap<String, HashMap<String, Long>> InsertionSortMapIntermediateB = InsertionSortMap.get(size);
            InsertionSortMapIntermediateB.put("vectorB", new HashMap<>());
            HashMap<String, Long> InsertionSortMapInternalB = InsertionSortMapIntermediateB.get("vectorB");
            InsertionSortMapInternalB.put("comparisons", iB.getComparisons());
            InsertionSortMapInternalB.put("swaps", iB.getSwaps());
            InsertionSortMapInternalB.put("executionTime", iB.getExecutionTime());

            // Vector C
            HashMap<String, HashMap<String, Long>> InsertionSortMapIntermediateC = InsertionSortMap.get(size);
            InsertionSortMapIntermediateC.put("vectorC", new HashMap<>());
            HashMap<String, Long> InsertionSortMapInternalC = InsertionSortMapIntermediateC.get("vectorC");
            InsertionSortMapInternalC.put("comparisons", iC.getComparisons());
            InsertionSortMapInternalC.put("swaps", iC.getSwaps());
            InsertionSortMapInternalC.put("executionTime", iC.getExecutionTime());
        }

        return InsertionSortMap;
    }
}
