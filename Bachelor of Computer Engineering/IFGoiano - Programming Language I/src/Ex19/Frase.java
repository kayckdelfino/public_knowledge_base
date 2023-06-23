package Ex19;

import java.util.Scanner;

public class Frase {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite uma frase de até 50 caracteres:");
        String frase = sc.nextLine();

        while (frase.length() > 50) {
            System.out.println("A frase é muito longa!");
            frase = sc.nextLine();
        }
        sc.close();

        int espacos = 0;

        System.out.println();
        for (int i = 0; i < frase.length(); i++) {
            char c = frase.charAt(i);
            if (c == ' ') espacos++;
            else System.out.print(c);
        }

        System.out.println("\nA frase inserida possui " + espacos + " espaços.");
    }
}
