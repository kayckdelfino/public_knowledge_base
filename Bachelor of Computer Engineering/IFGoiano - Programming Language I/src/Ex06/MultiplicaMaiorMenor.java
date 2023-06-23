package Ex06;

import java.util.Scanner;

public class MultiplicaMaiorMenor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] n = new int[3];
        System.out.println("Informe três números inteiros maiores que 0:");

        for (int i = 0; i < n.length; i++) {
            System.out.println("N" + (i + 1));
            n[i] = sc.nextInt();
            while (n[i] <= 0) {
                System.out.println("Valor inválido, insira um valor positivo:");
                System.out.println("N" + (i + 1));
                n[i] = sc.nextInt();
            }
        }
        sc.close();

        int menor = Integer.MAX_VALUE, maior = Integer.MIN_VALUE;
        for (int j : n) {
            menor = j < menor ? j : menor;
            maior = j > maior ? j : maior;
        }

        System.out.println(String.format("Maior valor dividido pelo menor = %.2f", ((float) maior / (float) menor)));
        System.out.println("Menor valor vezes o maior = " + (menor * maior));
    }
}
