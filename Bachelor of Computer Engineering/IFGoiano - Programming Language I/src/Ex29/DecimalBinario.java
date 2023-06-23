package Ex29;

import java.util.Scanner;

public class DecimalBinario {
    static void binario(int decimal) {
        if (decimal > 0) {
            binario(decimal / 2);
            System.out.print((decimal % 2) + " ");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Insira um número para transformá-lo em binário:");
        int x = sc.nextInt();
        sc.close();

        System.out.println("\nEm binário:");
        binario(x);
    }
}
