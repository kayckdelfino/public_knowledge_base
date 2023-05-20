package Ex05;

import java.util.Scanner;

public class CalcModulo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Informe um número inteiro:");
        int n = sc.nextInt();

        int modulo = n < 0 ? (n * (-1)) : n;

        System.out.println("\nSeu módulo é: " + modulo);
    }
}
