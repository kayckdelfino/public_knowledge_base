/*
You are given a class Solution and an inner class Inner.Private. The main method of class Solution takes an integer num as input. The powerof2 in class Inner.Private checks whether a number is a power of 2. You have to call the method powerof2 of the class Inner.Private from the main method of the class Solution.

Constraints
- 1 <= num <= 2^30

Sample Input
8

Sample Output
8 is power of 2
An instance of class: Solution.Inner.Private has been created
*/

package KayckGitHub.public_knowledge_base.Java.HackerRank;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Method;

public class JavaCanYouAccess {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine().trim());
        Object o;

        // Write your code here
        Inner inner = new Inner();
        o = inner.new Private();

        Method powerof2 = o.getClass().getDeclaredMethod("powerof2", int.class);
        powerof2.setAccessible(true);

        System.out.println(num + " is " + powerof2.invoke(o, num));
        // End of code
        System.out.println("An instance of class: " + o.getClass().getCanonicalName() + " has been created");
        
        // Not part of the solution
        System.out.println(((Inner.Private) o).powerof2(num));
    }

    static class Inner {
        private class Private {
            private String powerof2(int num) {
                return ((num & num - 1) == 0) ? "power of 2" : "not a power of 2";
            }
        }
    }
}