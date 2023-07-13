/*
A prime number is a natural number greater than 1 whose only positive divisors are 1 and itself. For example, the first six prime numbers are 2, 3, 5, 7, 11, and 13.

Given a large integer, n, use the Java BigInteger class' isProbablePrime method to determine and print whether it's prime or not prime.

Input Format
A single line containing an integer, n (the number to be checked).

Constraints
- n contains at most 100 digits.

Output Format
If n is a prime number, print prime; otherwise, print not prime.

Sample Input
13

Sample Output
prime

Explanation
The only positive divisors of 13 are 1 and 13, so we print prime.
*/

package KayckGitHub.public_knowledge_base.Java.HackerRank;

import java.math.BigInteger;
import java.util.Scanner;

public class JavaPrimality_Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BigInteger n = sc.nextBigInteger();
        sc.close();

        if (n.isProbablePrime(10)) {
            System.out.println("prime");
        } else {
            System.out.println("not prime");
        }
    }
}