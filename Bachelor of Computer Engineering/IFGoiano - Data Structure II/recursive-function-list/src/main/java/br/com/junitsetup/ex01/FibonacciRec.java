package br.com.junitsetup.ex01;

/**
 * A class to calculate the nth Fibonacci number recursively.
 */
public class FibonacciRec {

    /**
     * Calculates the nth Fibonacci number recursively.
     * 
     * @param n The index of the Fibonacci number to calculate.
     * @return The nth Fibonacci number.
     * @throws IllegalArgumentException if n is negative.
     */
    public static int calc(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("N cannot be negative");
        } else if (n <= 1) {
            return 1;
        } else {
            // Fibonacci calculation recursively
            return calc(n - 1) + calc(n - 2);
        }
    }
}