package Ex21;

import java.util.Scanner;

public class VetorMedia {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Quantos números serão inseridos?");
        System.out.println("Insira inteiros postivos.");
        int x = sc.nextInt();

        int[] vetor = new int[x];

        for (int i = 0; i < x; i++) {
            System.out.println("N" + (i + 1) + ":");
            int n = sc.nextInt();
            vetor[i] = n;
        }
        sc.close();

        double media = 0;
        int maior = Integer.MIN_VALUE;
        for (int i : vetor) {
            media += i;
            maior = i > maior ? i : maior;
        }
        media /= x;

        System.out.println("\nMédia = " + media);
        System.out.println("Maior valor = " + maior);
    }
}
