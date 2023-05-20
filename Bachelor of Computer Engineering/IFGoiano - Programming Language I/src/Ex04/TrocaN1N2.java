package Ex04;

import java.util.Scanner;

public class TrocaN1N2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Informe dois números inteiros:");

        System.out.println("A:");
        int a = sc.nextInt();
        System.out.println("B:");
        int b = sc.nextInt();

        int aux = a;
        a = b;
        b = aux;

        System.out.println("\nA = " + a);
        System.out.println("B = " + b);
    }
}
