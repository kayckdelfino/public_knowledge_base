package br.com.junitsetup.ex02;

/**
 * A class to calculate multiplication using recursion.
 */
public class MultiplicationRec {

    /**
     * Calculates the product of two integers recursively.
     * 
     * @param n The first integer.
     * @param m The second integer.
     * @return The product of n and m.
     */
    public static int calc(int n, int m) {
        if (n == 0 || m == 0) {
            // If either n or m is 0, the product is 0
            return 0;
        } else if (n < 0 && m < 0) {
            // If both n and m are negative, make both positive and call recursively
            return calc(-n, -m);
        } else if (n < 0) {
            // If only n is negative, make it positive and negate the result
            return -calc(-n, m);
        } else if (m < 0) {
            // If only m is negative, make it positive and negate the result
            return -calc(n, -m);
        } else if (m == 1) {
            // Base case: if m is 1, return n
            return n;
        } else {
            // Recursive case: add n to the result of multiplying n by m-1
            return n + calc(n, m - 1);
        }
    }
}