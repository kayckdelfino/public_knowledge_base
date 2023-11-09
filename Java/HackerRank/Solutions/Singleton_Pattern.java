/*
Challenge statement: https://www.hackerrank.com/challenges/java-singleton/problem

"The singleton pattern is a design pattern that restricts the instantiation of a class to one object. This is useful when exactly one object is needed to coordinate actions across the system."
- Wikipedia: Singleton Pattern

Complete the Singleton class in your editor which contains the following components:
1. A private Singleton non parameterized constructor.
2. A public String instance variable named str.
3. Write a static method named getSingleInstance that returns the single instance of the Singleton class.
Once submitted, our hidden Solution class will check your code by taking a String as input and then using your Singleton class to print a line.

Input Format
You will not be handling any input in this challenge.

Output Format
You will not be producing any output in this challenge.

Sample Input
hello world

Sample Output
Hello I am a singleton! Let me say hello world to you
*/

package KayckGitHub.public_knowledge_base.Java.HackerRank.Solutions;

// Solution:
class Singleton {
    private static Singleton instance;

    public String str;

    private Singleton() {
    }

    public static Singleton getSingleInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}

// Demo:
public class Singleton_Pattern {
    public static void main(String[] args) {
        Singleton singleton = Singleton.getSingleInstance();
        singleton.str = "Hello, Singleton!";

        Singleton anotherSingleton = Singleton.getSingleInstance();
        System.out.println(anotherSingleton.str); // Imprime "Hello, Singleton!"
    }
}