package Ex20;

import java.util.Scanner;

public class FraseVogal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Insira uma frase:");
        String frase = sc.nextLine();

        System.out.println("\nVogais:");
        for (int i = 0; i < frase.length(); i++) {
            char c = frase.charAt(i);
            if (c == 'a' || c == 'A' || c == 'e' || c == 'E' || c == 'i' || c == 'I' || c == 'o' || c == 'O' || c == 'u' || c == 'U')
                System.out.print(c);
        }
    }
}
