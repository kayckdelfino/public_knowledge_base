package src;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import src.Maps.MapBubbleSort;
import src.Maps.MapBubbleSortOptimized;
import src.Maps.MapInsertionSort;
import src.Maps.MapSelectionSort;

public class Main {
    static final int[] sizes = {1000, 5000, 10000, 15000, 20000, 25000, 30000, 35000, 40000, 45000, 50000};
    static final String[] sortingMethods = {"BubbleSort", "BubbleSortOptimized", "InsertionSort", "SelectionSort"};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("===========================================================");
        System.out.println("\t--- PROGRAM STARTED ---");
        System.out.println("CALCULATING STATISTICS, PLEASE WAIT!");
        System.out.println("===========================================================");

        // HashMaps to store array size (key) and array (value) with their respective logic
        ArrayList<HashMap<Integer, int[]>> vectorList = generateVectors(sizes);
        HashMap<Integer, int[]> vectorA = vectorList.get(0);
        HashMap<Integer, int[]> vectorB = vectorList.get(1);
        HashMap<Integer, int[]> vectorC = vectorList.get(2);

        // Populating all HashMaps with statistics for each sorting method
        HashMap<Integer, HashMap<String, HashMap<String, Long>>> BubbleSortMap = MapBubbleSort.map(vectorA, vectorB, vectorC, sizes);
        HashMap<Integer, HashMap<String, HashMap<String, Long>>> BubbleSortOptimizedMap = MapBubbleSortOptimized.map(vectorA, vectorB, vectorC, sizes);
        HashMap<Integer, HashMap<String, HashMap<String, Long>>> InsertionSortMap = MapInsertionSort.map(vectorA, vectorB, vectorC, sizes);
        HashMap<Integer, HashMap<String, HashMap<String, Long>>> SelectionSortMap = MapSelectionSort.map(vectorA, vectorB, vectorC, sizes);

        // Populating a list with all the statistics maps
        ArrayList<HashMap<Integer, HashMap<String, HashMap<String, Long>>>> statisticsList = new ArrayList<>();
        statisticsList.add(BubbleSortMap);
        statisticsList.add(BubbleSortOptimizedMap);
        statisticsList.add(InsertionSortMap);
        statisticsList.add(SelectionSortMap);

        // Provide the user with options for graphical plots
        selectOption(sc, statisticsList);
        sc.close();
    }

    // Method to ask the user for an option
    private static void selectOption(Scanner sc, ArrayList<HashMap<Integer, HashMap<String, HashMap<String, Long>>>> statisticsList) {
        int option = -1;
        while (option != 0) {
            displayMenu();
            try {
                option = sc.nextInt();
                sc.nextLine();
                if (option == 0) {
                    System.out.println("Exiting the program.");
                } else if (option >= 1 && option <= 10) {
                    switch (option) {
                        case 1:
                            plotGraph(statisticsList, "vectorA", "comparisons", sizes, sortingMethods);
                            break;
                        case 2:
                            plotGraph(statisticsList, "vectorA", "swaps", sizes, sortingMethods);
                            break;
                        case 3:
                            plotGraph(statisticsList, "vectorA", "executionTime", sizes, sortingMethods);
                            break;
                        case 4:
                            plotGraph(statisticsList, "vectorB", "comparisons", sizes, sortingMethods);
                            break;
                        case 5:
                            plotGraph(statisticsList, "vectorB", "swaps", sizes, sortingMethods);
                            break;
                        case 6:
                            plotGraph(statisticsList, "vectorB", "executionTime", sizes, sortingMethods);
                            break;
                        case 7:
                            plotGraph(statisticsList, "vectorC", "comparisons", sizes, sortingMethods);
                            break;
                        case 8:
                            plotGraph(statisticsList, "vectorC", "swaps", sizes, sortingMethods);
                            break;
                        case 9:
                            plotGraph(statisticsList, "vectorC", "executionTime", sizes, sortingMethods);
                            break;
                        case 10:
                            plotGraph(statisticsList, "vectorA", "comparisons", sizes, sortingMethods);
                            plotGraph(statisticsList, "vectorA", "swaps", sizes, sortingMethods);
                            plotGraph(statisticsList, "vectorA", "executionTime", sizes, sortingMethods);
                            plotGraph(statisticsList, "vectorB", "comparisons", sizes, sortingMethods);
                            plotGraph(statisticsList, "vectorB", "swaps", sizes, sortingMethods);
                            plotGraph(statisticsList, "vectorB", "executionTime", sizes, sortingMethods);
                            plotGraph(statisticsList, "vectorC", "comparisons", sizes, sortingMethods);
                            plotGraph(statisticsList, "vectorC", "swaps", sizes, sortingMethods);
                            plotGraph(statisticsList, "vectorC", "executionTime", sizes, sortingMethods);
                            break;
                    }
                } else {
                    System.out.println("Invalid option. Please choose again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter an integer.");
                sc.nextLine();
            }
        }
    }

    // Method to display the menu of options
    private static void displayMenu() {
        System.out.println("===========================================================");
        System.out.println("\t--- Menu ---");
        System.out.println("0. Exit");
        System.out.println("\t--- Best Case ---");
        System.out.println("1. Comparisons");
        System.out.println("2. Swaps");
        System.out.println("3. Execution Time");
        System.out.println("\t--- Worst Case ---");
        System.out.println("4. Comparisons");
        System.out.println("5. Swaps");
        System.out.println("6. Execution Time");
        System.out.println("\t--- Average Case ---");
        System.out.println("7. Comparisons");
        System.out.println("8. Swaps");
        System.out.println("9. Execution Time");
        System.out.println("\t--- General ---");
        System.out.println("10. All Graphs");
        System.out.println("===========================================================");
        System.out.print("Choose an option: ");
    }

    // Method to plot the selected type of graph
    private static void plotGraph(ArrayList<HashMap<Integer, HashMap<String, HashMap<String, Long>>>> statisticsList, String vector, String statistic, int[] sizes, String[] sortingMethods) {
        XYSeriesCollection dataset = new XYSeriesCollection();

        for (int i = 0; i < sortingMethods.length; i++) {
            XYSeries series = new XYSeries(sortingMethods[i]);

            for (int j = 0; j < sizes.length; j++) {
                int size = sizes[j];
                long value = statisticsList.get(i).get(size).get(vector).get(statistic);
                series.add(size, value);
            }
            dataset.addSeries(series);
        }

        JFreeChart chart = ChartFactory.createXYLineChart(
                vector,
                "number of elements",
                statistic,
                dataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                false);

        XYPlot plot = chart.getXYPlot();
        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        plot.setRenderer(renderer);

        JFrame frame = new JFrame(vector);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().add(new ChartPanel(chart) {
            @Override
            public Dimension getPreferredSize() {
                return new Dimension(800, 600);
            }
        });

        frame.pack();
        frame.setVisible(true);
    }

    // Method used to generate vectors with their logic for all values in the "sizes" array
    private static ArrayList<HashMap<Integer, int[]>> generateVectors(int[] sizes) {
        ArrayList<HashMap<Integer, int[]>> vectorList = new ArrayList<>();
        HashMap<Integer, int[]> vectorA = new HashMap<>(); // A = sorted in ascending order
        HashMap<Integer, int[]> vectorB = new HashMap<>(); // B = sorted in descending order
        HashMap<Integer, int[]> vectorC = new HashMap<>(); // C = random order

        for (int size : sizes) {
            // Insert a pair with a random array into vectorC
            vectorC.put(size, getRandomVector(size));

            // Sort and insert a copy of vectorC into vectorA
            int[] vectorAsc = Arrays.copyOf(vectorC.get(size), size);
            Arrays.sort(vectorAsc);
            vectorA.put(size, vectorAsc);

            // Reverse the sorted array and insert a copy into vectorB
            int[] vectorDesc = Arrays.copyOf(vectorAsc, size);
            reverseArray(vectorDesc);
            vectorB.put(size, vectorDesc);
        }
        // Add all three HashMaps to the list
        vectorList.add(vectorA);
        vectorList.add(vectorB);
        vectorList.add(vectorC);

        return vectorList;
    }

    // Method used to reverse the order of elements in an array
    private static void reverseArray(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[n - i - 1];
            arr[n - i - 1] = temp;
        }
    }

    // Method used to create an array (size n) of random numbers
    private static int[] getRandomVector(int n) {
        int[] v = new int[n];

        for (int i = 0; i < n; i++) {
            v[i] = (int) Math.round(Math.random() * 1000000);
        }

        return v;
    }
}