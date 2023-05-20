package Ex11;

import java.util.Scanner;

public class IndicePoluicao {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String condicao;
        boolean encerrar = false;
        do {
            System.out.println("Insira o índice de poluição: (0,05 a 1)");
            double indice = sc.nextDouble();

            while (indice < 0.05 || indice > 1) {
                System.out.println("O valor inserido é incorreto.");
                indice = sc.nextDouble();
            }

            System.out.println();
            if (indice >= 0.05 && indice < 0.3) System.out.println("O índice de poluição está aceitável.");
            else if (indice >= 0.3 && indice < 0.4)
                System.out.println("As indústrias do grupo 1 devem suspender suas atividades.");
            else if (indice >= 0.4 && indice < 0.5)
                System.out.println("As indústrias dos grupo 1 e 2 devem suspender suas atividades.");
            else if (indice >= 0.5)
                System.out.println("As indústrias dos grupos 1, 2 e 3 devem paralisar suas atividades.");

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
