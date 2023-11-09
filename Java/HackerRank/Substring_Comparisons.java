/*
Challenge statement: https://www.hackerrank.com/challenges/java-string-compare/problem

We define the following terms:

- Lexicographical Order, also known as alphabetic or dictionary order, orders characters as follows: A < B < ... < Y < Z < a < b < ... < y < z
For example, ball < cat, dog < dorm, Happy < happy, Zoo < ball.

- A substring of a string is a contiguous block of characters in the string. For example, the substrings of abc are a, b, c, ab, bc, and abc.

Given a string, s, and an integer, k, complete the function so that it finds the lexicographically smallest and largest substrings of length k.

Function Description
Complete the getSmallestAndLargest function in the editor below.

getSmallestAndLargest has the following parameters:
- string s: a string
- int k: the length of the substrings to find

Returns
- string: the string ' + "\n" + ' where and are the two substrings

Input Format
The first line contains a string denoting s.
The second line contains an integer denoting k.

Constraints
- 1 <= |s| <= 1000
- s consists of English alphabetic letters only (i.e., [a-zA-Z]).

Sample Input 0
welcometojava
3

Sample Output 0
ava
wel

Explanation 0
String s = "welcometojava" has the following lexicographically-ordered substrings of length k = 3: ["ava", "com", "elc", "eto", "jav", "lco", "met", "oja", "ome", "toj", "wel"]

We then return the first (lexicographically smallest) substring and the last (lexicographically largest) substring as two newline-separated values (i.e., ava\nwel).
The stub code in the editor then prints ava as our first line of output and wel as our second line of output.
*/

package KayckGitHub.public_knowledge_base.Java.HackerRank;

import java.util.Scanner;

public class Substring_Comparisons {
    public static String getSmallestAndLargest(String s, int k) {
        String smallest = s.substring(0, k);
        String largest = s.substring(0, k);

        for (int i = 1; i <= s.length() - k; i++) {
            String substr = s.substring(i, i + k);
            if (substr.compareTo(smallest) < 0) {
                smallest = substr;
            }
            if (substr.compareTo(largest) > 0) {
                largest = substr;
            }
        }

        return smallest + "\n" + largest;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int k = sc.nextInt();
        sc.close();

        System.out.println(getSmallestAndLargest(s, k));
    }
}