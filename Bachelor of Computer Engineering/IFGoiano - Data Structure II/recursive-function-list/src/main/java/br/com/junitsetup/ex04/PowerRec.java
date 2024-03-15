package br.com.junitsetup.ex04;

/**
 * A class to calculate exponentiation using recursion.
 */
public class PowerRec {

    /**
     * Calculates the power of an integer to another integer recursively.
     * 
     * @param x The base integer.
     * @param y The exponent integer.
     * @return The result of x raised to the power of y.
     */
    public static double calc(int x, int y) {
        if (y == 0) {
            // Base case: if the exponent is 0, return 1.0
            return 1.0;
        } else if (y == 1) {
            // Base case: if the exponent is 1, return the base integer x
            return x;
        }

        if (y > 0) {
            // Recursive case: if the exponent is positive, multiply x by calc(x, y-1)
            return x * calc(x, y - 1);
        } else {
            // Recursive case: if the exponent is negative, calculate the reciprocal
            return 1.0 / calc(x, -y);
        }
    }
}