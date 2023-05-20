package Ex18;

import java.util.Scanner;
import java.util.Random;

public class Sorteio {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rd = new Random();

        int sorteado = rd.nextInt(101);
        int tentativas = 0;
        int palpite;

        System.out.println("Jogo: Acerte o número de 0 a 100.");
        do {
            System.out.println("Tentativa:");
            palpite = sc.nextInt();
            if (palpite < sorteado) System.out.println("O número sorteado é maior que " + palpite);
            else System.out.println("O número sorteado é menor que " + palpite);
            tentativas++;
        } while (palpite != sorteado);

        System.out.println("\nVocê acertou! O número sorteado era " + sorteado);
        System.out.println("Foram feitas " + tentativas + " tentativas");
    }
}
