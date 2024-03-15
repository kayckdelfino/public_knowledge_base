package br.com.junitsetup.ex03;

/**
 * A class to calculate addition using recursion.
 */
public class AdditionRec {

    /**
     * Calculates the sum of two integers recursively.
     * 
     * @param n The first integer.
     * @param m The second integer.
     * @return The sum of n and m.
     */
    public static int calc(int n, int m) {
        if (m == 0) {
            // Base case: if m is 0, return n
            return n;
        } else {
            // Recursive case: increment n and decrement m until m becomes 0
            return calc(++n, --m);
        }
    }
}