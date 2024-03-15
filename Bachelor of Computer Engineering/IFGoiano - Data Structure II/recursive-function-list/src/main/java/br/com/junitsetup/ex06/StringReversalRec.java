package br.com.junitsetup.ex06;

/**
 * A class to reverse a string using recursion.
 */
public class StringReversalRec {

    /**
     * Reverses a string recursively.
     * 
     * @param value The string to reverse.
     * @return The reversed string.
     */
    public static String reverse(String value) {
        if (value.isEmpty() || value.length() == 1) {
            // Base case: if the string is empty or has only one character, return the
            // string
            return value;
        } else {
            // Recursive case: concatenate the last character with the result of reversing
            // the substring without the first and last characters,
            // and then the first character
            return value.charAt(value.length() - 1) + reverse(value.substring(1, value.length() - 1)) + value.charAt(0);
        }
    }
}