package src.Maps;

import java.util.HashMap;

import src.Sorts.SelectionSort;

public class MapSelectionSort {
    public static HashMap<Integer, HashMap<String, HashMap<String, Long>>> map(HashMap<Integer, int[]> vectorA,
            HashMap<Integer, int[]> vectorB, HashMap<Integer, int[]> vectorC, int[] sizes) {
        // Logic to populate the HashMap for SelectionSort ({number of elements = {"vector" = {"comparisons" = long, "swaps" = long, "executionTime" = long}}})
        HashMap<Integer, HashMap<String, HashMap<String, Long>>> SelectionSortMap = new HashMap<>();

        for (int size : sizes) {
            // Getting statistics for each type of vector
            SelectionSort sA = new SelectionSort(vectorA.get(size));
            SelectionSort sB = new SelectionSort(vectorB.get(size));
            SelectionSort sC = new SelectionSort(vectorC.get(size));

            // Populating HashMaps
            SelectionSortMap.put(size, new HashMap<>());

            // Vector A
            HashMap<String, HashMap<String, Long>> SelectionSortMapIntermediateA = SelectionSortMap.get(size);
            SelectionSortMapIntermediateA.put("vectorA", new HashMap<>());
            HashMap<String, Long> SelectionSortMapInternalA = SelectionSortMapIntermediateA.get("vectorA");
            SelectionSortMapInternalA.put("comparisons", sA.getComparisons());
            SelectionSortMapInternalA.put("swaps", sA.getSwaps());
            SelectionSortMapInternalA.put("executionTime", sA.getExecutionTime());

            // Vector B
            HashMap<String, HashMap<String, Long>> SelectionSortMapIntermediateB = SelectionSortMap.get(size);
            SelectionSortMapIntermediateB.put("vectorB", new HashMap<>());
            HashMap<String, Long> SelectionSortMapInternalB = SelectionSortMapIntermediateB.get("vectorB");
            SelectionSortMapInternalB.put("comparisons", sB.getComparisons());
            SelectionSortMapInternalB.put("swaps", sB.getSwaps());
            SelectionSortMapInternalB.put("executionTime", sB.getExecutionTime());

            // Vector C
            HashMap<String, HashMap<String, Long>> SelectionSortMapIntermediateC = SelectionSortMap.get(size);
            SelectionSortMapIntermediateC.put("vectorC", new HashMap<>());
            HashMap<String, Long> SelectionSortMapInternalC = SelectionSortMapIntermediateC.get("vectorC");
            SelectionSortMapInternalC.put("comparisons", sC.getComparisons());
            SelectionSortMapInternalC.put("swaps", sC.getSwaps());
            SelectionSortMapInternalC.put("executionTime", sC.getExecutionTime());
        }

        return SelectionSortMap;
    }
}
