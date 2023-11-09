/*
Example:

Variables: x1, x2, x3, x4, x5 (x3, x4, and x5 are slack variables)
double[][] coefficients = new double[][]{{-3, -2, 0, 0, 0}, {2, 1, 1, 0, 0}, {1, 1, 0, 1, 0}, {1, 0, 0, 0, 1}}
double[] rightHandSide = new double[]{100, 80, 40}
String[] basicVariables = new String[]{"z", "x3", "x4", "x5"}


Input Values (TEST):

Decision Variables = 2
Constraints = 3
Coefficients = [
    -3, -2
    2, 1
    1, 1
    1, 0
]
Right-Hand Sides of Constraints = [
    100
    80
    40
]


Results (TEST):

Solution = [
    z = 180.00
    x2 = 60.00
    x5 = 20.00
    x1 = 20.00
]
*/

import java.util.Scanner;

public class Simplex {
    // Method to populate the coefficients of the problem in standard form
    static double[][] receiveCoefficients(Scanner sc) {
        System.out.println("=====================================================");
        System.out.println("How many decision variables does the problem have?");
        int variables = sc.nextInt();

        System.out.println("=====================================================");
        System.out.println("How many constraints does the problem have?");
        int constraints = sc.nextInt();

        // Creating a matrix of coefficients for the simplex method
        double[][] coefficients = new double[constraints + 1][variables + constraints];

        // Inserting values for decision variables
        System.out.println("=====================================================");
        System.out.println("Enter coefficients (only coefficients of decision variables):");
        for (int i = 0; i < (constraints + 1); i++) {
            System.out.println("=====================================================");
            System.out.println("Row " + i + ":");
            for (int j = 0; j < variables; j++) {
                System.out.println("Coefficient " + (j + 1) + ":");
                coefficients[i][j] = sc.nextDouble();
            }
        }

        // Inserting values for basic variables
        int counter = 0;
        for (int i = 0; i < (constraints + 1); i++) {
            for (int j = variables; j < (variables + constraints); j++) {
                if (counter == 0) {
                    coefficients[i][j] = 0;
                } else {
                    coefficients[i][j + counter - 1] = 1;
                    break;
                }
            }
            counter++;
        }

        return coefficients;
    }

    // Method to receive the right-hand side values of the constraints
    static double[] receiveRightHandSide(Scanner sc, double[][] coefficients) {
        double[] rightHandSide = new double[coefficients.length];

        System.out.println("=====================================================");
        System.out.println("Enter the values of the right-hand side of the constraints");
        rightHandSide[0] = 0; // Inserting the right-hand side of the objective function (always 0)
        for (int i = 1; i < coefficients.length; i++) {
            System.out.println("=====================================================");
            System.out.println("R" + i + ":");
            rightHandSide[i] = sc.nextDouble();
        }

        return rightHandSide;
    }

    // Method that returns the initial basic variables of the problem
    static String[] receiveBasicVariables(double[][] coefficients) {
        String[] basicVariables = new String[coefficients.length];
        basicVariables[0] = "z";

        // Inserting basic variables
        for (int i = 1; i < basicVariables.length; i++) {
            String s = String.format("x%d", (coefficients[0].length - coefficients.length + 1 + i));
            basicVariables[i] = s;
        }

        return basicVariables;
    }

    // Method to format the current values in a table
    static void table(double[][] coefficients, double[] rightHandSide, String[] basicVariables) {
        // Printing headers
        System.out.print(String.format("%s%-4s%-8s", "|", "", "B.V."));
        for (int i = 0; i < coefficients[0].length; i++) {
            System.out.print(String.format("%s%-4s%s%-7d", "|", "", "x", (i + 1)));
        }
        System.out.print(String.format("%s%-4s%-8s","|", "", "R.H."));
        System.out.println("|");

        // Printing table values
        for (int i = 0; i < coefficients.length; i++) {
            System.out.print(String.format("%s%-4s%-8s", "|", "", basicVariables[i]));
            for (int j = 0; j < coefficients[0].length; j++) {
                System.out.print(String.format("%s%-4s%-8.2f", "|", "", coefficients[i][j]));
            }
            System.out.print(String.format("%s%-4s%-8.2f", "|", "", rightHandSide[i]));
            System.out.println("|");
        }
    }

    // Check the stopping condition of the simplex method: If the coefficients in the first row are all non-negative, no further iterations are needed
    static boolean stoppingCondition(double[][] coefficients) {
        for(int i = 0; i < coefficients[0].length; i++) {
            if (coefficients[0][i] < 0) return false;
        }
        return true;
    }

    static void simplex(double[][] coefficients, double[] rightHandSide, String[] basicVariables) {
        // Calculate the index of the pivot column
        int pivotColumnIndex = 0;
        double smallest = coefficients[0][0];
        for (int i = 1; i < coefficients[0].length; i++) {
            if (coefficients[0][i] < smallest) {
                smallest = coefficients[0][i];
                pivotColumnIndex = i;
            }
        }

        // Calculate the quotients by dividing the right-hand side by the coefficients in the pivot column
        double[] quotients = new double[coefficients.length - 1];
        for (int i = 0; i < quotients.length; i++) {
            double ratio = rightHandSide[i + 1] / coefficients[i + 1][pivotColumnIndex];
            quotients[i] = ratio;
        }

        // Calculate the index of the pivot row
        int pivotRowIndex = 0;
        smallest = Double.MAX_VALUE;
        for (int i = 0; i < quotients.length; i++) {
            if (quotients[i] < smallest && quotients[i] > 0) {
                smallest = quotients[i];
                pivotRowIndex = i + 1;
            }
        }
        
        // Set the pivot coefficient
        double pivotCoefficient = coefficients[pivotRowIndex][pivotColumnIndex];

        // Update the pivot row
        for (int i = 0; i <= coefficients.length; i++) {
            coefficients[pivotRowIndex][i] = coefficients[pivotRowIndex][i] / pivotCoefficient;
        }

        // Update the right-hand side of the pivot row
        rightHandSide[pivotRowIndex] = rightHandSide[pivotRowIndex] / pivotCoefficient;

        // Update the other rows
        for (int i = 0; i < coefficients.length; i++) {
            double pivotColumnCoefficient = coefficients[i][pivotColumnIndex];
            for (int j = 0; j < coefficients[0].length; j++) {
                if (i == pivotRowIndex) break;
                else {
                    double oldCoefficient = coefficients[i][j];
                    double newValuePivotRow = coefficients[pivotRowIndex][j];

                    coefficients[i][j] = oldCoefficient - (pivotColumnCoefficient * newValuePivotRow);
                }
            }
            // Update the right-hand side of the other rows
            if (i != pivotRowIndex) rightHandSide[i] = rightHandSide[i] - (pivotColumnCoefficient * rightHandSide[pivotRowIndex]);
        }

        // Update basic variables
        basicVariables[pivotRowIndex] = String.format("x%d", pivotColumnIndex + 1);
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        // Receive values and store them
        double[][] coefficients = receiveCoefficients(sc);
        String[] basicVariables = receiveBasicVariables(coefficients);
        double[] rightHandSide = receiveRightHandSide(sc, coefficients);

        // Check the stopping condition of the simplex method and execute it, showing the table at each iteration
        boolean stoppingConditionMet = stoppingCondition(coefficients);
        System.out.println("============================================================================================");
        System.out.println("INITIAL STATE:");
        System.out.println("============================================================================================");
        table(coefficients, rightHandSide, basicVariables);

        int iterationCount = 1;
        while (!stoppingConditionMet) {
            simplex(coefficients, rightHandSide, basicVariables);
            System.out.println("============================================================================================");
            System.out.println("ITERATION " + iterationCount + ":");
            System.out.println("============================================================================================");
            table(coefficients, rightHandSide, basicVariables);
            stoppingConditionMet = stoppingCondition(coefficients);
            iterationCount++;

            // Check for excessive iterations
            if (iterationCount == 100) break;
        }

        // Show the conclusion of the problem
        if (stoppingConditionMet) {
            System.out.println("============================================================================================");
            System.out.println("OPTIMAL SOLUTION FOUND:\n");

            for (int i = 0; i < coefficients.length; i++) {
                System.out.print(String.format("%s%-5s%-6s%-4s%-8.2f", "|", "", basicVariables[i], "=", rightHandSide[i]));
                System.out.println("|");
            }

            System.out.println("\nVARIABLES THAT ARE NOT PART OF THE OBJECTIVE FUNCTION CAN BE IGNORED");
            System.out.println("============================================================================================");
        } else {
            System.out.println("============================================================================================");
            System.out.println("THE PROGRAM COULD NOT FIND THE OPTIMAL SOLUTION, ITERATION LIMIT EXCEEDED");
            System.out.println("EXITING...");
            System.out.println("============================================================================================");
        }
    }
}
