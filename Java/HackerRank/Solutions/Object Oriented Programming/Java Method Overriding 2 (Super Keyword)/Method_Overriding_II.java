/*
Challenge statement: https://www.hackerrank.com/challenges/java-method-overriding-2-super-keyword/problem

When a method in a subclass overrides a method in superclass, it is still possible to call the overridden method using super keyword. If you write super.func() to call the function func(), it will call the method that was defined in the superclass.

You are given a partially completed code in the editor. Modify the code so that the code prints the following text:

Hello I am a motorcycle, I am a cycle with an engine.
My ancestor is a cycle who is a vehicle with pedals.
*/

package KayckGitHub.public_knowledge_base.Java.HackerRank.Solutions;

class BiCycle {
    String define_me() {
        return "a vehicle with pedals.";
    }
}

class MotorCycle extends BiCycle {
    String define_me() {
        return "a cycle with an engine.";
    }

    MotorCycle() {
        System.out.println("Hello I am a motorcycle, I am " + define_me());

        String temp = super.define_me();

        System.out.println("My ancestor is a cycle who is " + temp);
    }

}

public class Method_Overriding_II {
    public static void main(String[] args) {
        MotorCycle M = new MotorCycle();
        M.define_me(); // Ignore
    }
}