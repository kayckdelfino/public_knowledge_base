/*
Challenge statement: https://www.hackerrank.com/challenges/java-substring/problem

Given a string, s, and two indices, start and end, print a substring consisting of all characters in the inclusive range from start to end - 1. You'll find the String class' substring method helpful in completing this challenge.

Input Format
The first line contains a single string denoting s.
The second line contains two space-separated integers denoting the respective values of start and end.

Constraints
- 1 <= |s| <= 100
- 0 <= start <= end <= n
- String s consists of English alphabetic letters (i.e., [a-zA-Z]) only.

Output Format
Print the substring in the inclusive range from start to end - 1.

Sample Input
Helloworld
3 7

Sample Output
lowo

Explanation
In the diagram below, the substring is highlighted:
0 1 2 [3 4 5 6] 7 8 9
H e l [l o w o] r l d
*/

package KayckGitHub.public_knowledge_base.Java.HackerRank.Solutions;

import java.util.Scanner;

public class Substring {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int start = sc.nextInt();
        int end = sc.nextInt();
        sc.close();
        
        String substring = s.substring(start, end);
        System.out.println(substring);
    }
}