package Ex16;

import java.util.Scanner;

public class CampanhaModelo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] nomes = new String[10];
        int[] idades = new int[10];

        for (int i = 0; i < 10; i++) {
            System.out.println("Candidata " + (i + 1) + ":");
            System.out.println("Nome:");
            nomes[i] = sc.next();
            System.out.println("Idade:");
            idades[i] = sc.nextInt();
        }
        sc.close();

        System.out.println("\nCandidatas aptas a concorrer a vaga:");
        for (int i = 0; i < 10; i++) {
            if (idades[i] >= 18 && idades[i] <= 20) System.out.println(nomes[i]);
        }
    }
}
