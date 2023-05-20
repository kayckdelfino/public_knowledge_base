package Ex10;

import java.util.Scanner;

public class LeInteiro {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String condicao;
        boolean encerrar = false;
        do {
            System.out.println("Informe um número inteiro:");
            int n = sc.nextInt();

            if ((n % 2) == 0) System.out.print("O número " + n + " é par");
            else System.out.print("O número " + n + " é ímpar");

            if (n < 0) System.out.print(" e negativo.");
            else System.out.print(" e positivo.");

            System.out.println("\nDeseja encerrar o programa? (S/N)");
            condicao = sc.next();

            while (condicao.equalsIgnoreCase("S") != true && condicao.equalsIgnoreCase("N") != true) {
                System.out.println("Resposta inválida.");
                condicao = sc.next();
            }
            if (condicao.equalsIgnoreCase("S") == true) encerrar = true;
        } while (encerrar == false);
    }
}
