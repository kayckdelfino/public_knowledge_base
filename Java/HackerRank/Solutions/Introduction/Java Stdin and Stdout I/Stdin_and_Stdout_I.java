/*
Challenge statement: https://www.hackerrank.com/challenges/java-stdin-and-stdout-1/problem

Most HackerRank challenges require you to read input from stdin (standard input) and write output to stdout (standard output).

One popular way to read input from stdin is by using the Scanner class and specifying the Input Stream as System.in. For example:

Scanner scanner = new Scanner(System.in);
String myString = scanner.next();
int myInt = scanner.nextInt();
scanner.close();

System.out.println("myString is: " + myString);
System.out.println("myInt is: " + myInt);
The code above creates a Scanner object named  and uses it to read a String and an int. It then closes the Scanner object because there is no more input to read, and prints to stdout using System.out.println(String). So, if our input is:
Hi 5

Our code will print:
myString is: Hi
myInt is: 5

Alternatively, you can use the BufferedReader class.

Task
In this challenge, you must read  integers from stdin and then print them to stdout. Each integer must be printed on a new line. To make the problem a little easier, a portion of the code is provided for you in the editor below.

Input Format
There are  lines of input, and each line contains a single integer.

Sample Input
42
100
125

Sample Output
42
100
125
*/

package KayckGitHub.public_knowledge_base.Java.HackerRank.Solutions;

import java.util.Scanner;

public class Stdin_and_Stdout_I {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int int1 = sc.nextInt();
        int int2 = sc.nextInt();
        int int3 = sc.nextInt();
        
        System.out.println(int1);
        System.out.println(int2);
        System.out.println(int3);

        sc.close();
    }
}