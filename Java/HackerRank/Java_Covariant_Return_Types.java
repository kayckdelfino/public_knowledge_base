/*
Java allows for Covariant Return Types, which means you can vary your return type as long you are returning a subclass of your specified return type.

Method Overriding allows a subclass to override the behavior of an existing superclass method and specify a return type that is some subclass of the original return type. It is best practice to use the @Override annotation when overriding a superclass method.

Implement the classes and methods detailed in the diagram below:

image: (https://s3.amazonaws.com/hr-assets/0/1523891844-c66f1555af-class.png)

You will be given a partially completed code in the editor where the main method takes the name of a state (i.e., WestBengal, or AndhraPradesh) and prints the national flower of that state using the classes and methods written by you.

Note: Do not use access modifiers in your class declarations.

Resources
Covariant Return Type
Java Covariant Type

Input Format
The locked code reads a single string denoting the name of a subclass of State (i.e., WestBengal, Karnataka, or AndhraPradesh), then tests the methods associated with that subclass. You are not responsible for reading any input from stdin.

Output Format
Output is handled for you by the locked code, which creates the object corresponding to the input string's class name and then prints the name returned by that class' national flower's whatsYourName method. You are not responsible for printing anything to stdout.

Sample Input 0
AndhraPradesh

Sample Output 0
Lily

Explanation 0
An AndhraPradesh object's yourNationalFlower method returns an instance of the Lily class, and the Lily class' whatsYourName method returns Lily, which is printed by the hidden code checker.
*/

package KayckGitHub.public_knowledge_base.Java.HackerRank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//Complete the classes below
class Flower {
    String whatsYourName() {
        return "I have many names and types.";
    }
}

class Jasmine extends Flower {
    String whatsYourName() {
        return "Jasmine";
    }
}

class Lily extends Flower {
    String whatsYourName() {
        return "Lily";
    }
}

class Lotus extends Flower {
    String whatsYourName() {
        return "Lotus";
    }
}

class Region {
    Flower yourNationalFlower() {
        return new Flower();
    }
}

class WestBengal extends Region {
    Jasmine yourNationalFlower() {
        return new Jasmine();
    }
}

class Karnataka extends Region {
    Lotus yourNationalFlower() {
        return new Lotus();
    }
}

class AndhraPradesh extends Region {
    Lily yourNationalFlower() {
        return new Lily();
    }
}

public class Java_Covariant_Return_Types {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine().trim();
        Region region = null;
        switch (s) {
            case "WestBengal":
                region = new WestBengal();
                break;
            case "AndhraPradesh":
                region = new AndhraPradesh();
                break;
        }
        Flower flower = region.yourNationalFlower();
        System.out.println(flower.whatsYourName());
    }
}