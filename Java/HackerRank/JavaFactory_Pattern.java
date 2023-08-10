/*
According to Wikipedia, a factory is simply an object that returns another object from some other method call, which is assumed to be "new".

In this problem, you are given an interface Food. There are two classes Pizza and Cake which implement the Food interface, and they both contain a method getType().

The main function in the Main class creates an instance of the FoodFactory class. The FoodFactory class contains a method getFood(String) that returns a new instance of Pizza or Cake according to its parameter.

You are given the partially completed code in the editor. Please complete the FoodFactory class.

Sample Input 1
cake

Sample Output 1
The factory returned class Cake
Someone ordered a Dessert!

Sample Input 2
pizza

Sample Output 2
The factory returned class Pizza
Someone ordered Fast Food!
*/

package KayckGitHub.public_knowledge_base.Java.HackerRank;

import java.util.Scanner;

interface Food {
    public String getType();
}

class Pizza implements Food {
    public String getType() {
        return "Someone ordered a Fast Food!";
    }
}

class Cake implements Food {
    public String getType() {
        return "Someone ordered a Dessert!";
    }
}

class FoodFactory {
    public Food getFood(String order) {
        if (order.equalsIgnoreCase("cake")) {
            return new Cake();
        } else if (order.equalsIgnoreCase("pizza")) {
            return new Pizza();
        } else {
            return null;
        }
    } // End of getFood method
} // End of factory class

public class JavaFactory_Pattern {
    public static void main(String args[]) {
        try (Scanner sc = new Scanner(System.in)) {
            // creating the factory
            FoodFactory foodFactory = new FoodFactory();

            // factory instantiates an object
            Food food = foodFactory.getFood(sc.nextLine());

            System.out.println("The factory returned " + food.getClass());
            System.out.println(food.getType());
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}