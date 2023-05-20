package Ex03;

import java.util.Scanner;

public class RelacionaInteiros {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Informe três números inteiros:");

        int[] n = new int[3];
        System.out.println("N1:");
        n[0] = sc.nextInt();
        System.out.println("N2:");
        n[1] = sc.nextInt();
        System.out.println("N3:");
        n[2] = sc.nextInt();

        // Testes
        int j = 0;
        int k = 1;
        for (int i = 0; i < n.length; i++) {
            System.out.println();
            if (n[j] == n[k]) System.out.println(n[j] + " é igual a " + n[k] + ".");
            if (n[j] != n[k]) System.out.println(n[j] + " é diferente de " + n[k] + ".");
            if (n[j] > n[k]) System.out.println(n[j] + " é maior que " + n[k] + ".");
            if (n[j] < n[k]) System.out.println(n[j] + " é menor que " + n[k] + ".");
            if (n[j] >= n[k]) System.out.println(n[j] + " é maior ou igual a " + n[k] + ".");
            if (n[j] <= n[k]) System.out.println(n[j] + " é menor ou igual a " + n[k] + ".");

            j++;
            if (k == 2) j = 0;
            else k++;
        }

    }
}
