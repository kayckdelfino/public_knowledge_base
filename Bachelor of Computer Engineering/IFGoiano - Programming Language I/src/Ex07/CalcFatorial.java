package Ex07;

import java.util.Scanner;

public class CalcFatorial {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Quantos fatoriais serão calculados?");
        int x = sc.nextInt();

        int[] n = new int[x];

        System.out.println("Informe os inteiros:");
        for (int i = 0; i < n.length; i++) {
            System.out.println("N" + (i + 1));
            n[i] = sc.nextInt();
            while (n[i] < 0) {
                System.out.println("Não existe fatorial de número negativo!");
                System.out.println("N" + (i + 1));
                n[i] = sc.nextInt();
            }
        }

        System.out.println();
        for (int i = 0; i < n.length; i++) {
            int fatorial = 1;
            int num = n[i];
            while (n[i] > 0) {
                fatorial *= n[i];
                n[i]--;
            }
            System.out.println(num + "! = " + fatorial);
        }
    }
}

