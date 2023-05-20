package Ex22;

import java.util.Scanner;

public class Caracteres {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] alfabeto = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "x", "w", "y", "z"};
        String c1;
        String c2;

        System.out.println("Insira o primeiro caractere:");
        c1 = sc.next();

        while(c1.length() != 1){
            System.out.println("Erro ao inserir! Por favor, repita.");
            c1 = sc.next();
        }

        int posicaoc1 = 0;
        for(String x : alfabeto){
            if(c1.equalsIgnoreCase(x)) break;
            else posicaoc1++;
        }

        System.out.println("Insira o segundo caractere:");
        c2 = sc.next();

        while(c2.length() != 1){
            System.out.println("Erro ao inserir! Por favor, repita.");
            c2 = sc.next();
        }

        int posicaoc2 = 0;
        for (String x : alfabeto) {
            if (c2.equalsIgnoreCase(x)) break;
            else posicaoc2++;
        }

        int diferenca = posicaoc2 - posicaoc1;
        if (diferenca > 0)
            System.out.print("\nExistem " + (diferenca - 1) + " letras entre " + c1.toUpperCase() + " e " + c2.toUpperCase() + ".");
        else System.out.print("Erro!");
    }
}
