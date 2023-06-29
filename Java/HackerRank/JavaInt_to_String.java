/*
You are given an integer n, you have to convert it into a string.

Please complete the partially completed code in the editor. If your code successfully converts n into a string s the code will print "Good job". Otherwise it will print "Wrong answer".

n can range between -100 to 100 inclusive.

Sample Input 0
100

Sample Output 0
Good job
*/

package KayckGitHub.public_knowledge_base.Java.HackerRank;

import java.util.Scanner;

public class JavaInt_to_String {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        
        String s = Integer.toString(n);
        
        if (n == Integer.parseInt(s)) {
          System.out.println("Good job");
        } else {
            System.out.println("Wrong answer");
        }
    }
}