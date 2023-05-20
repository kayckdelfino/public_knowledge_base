package Ex08;

import java.util.Scanner;

public class Tabuada {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Número:");
        int n = sc.nextInt();

        System.out.println("\nTabuada:");
        for (int i = 1; i <= 10; i++) System.out.println(n + " x " + i + " = " + (n * i));
    }
}
