package Ex09;

import java.util.Scanner;

public class CalcSalario {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String condicao;
        boolean encerrar = false;
        do {
            System.out.println("Código do operário:");
            int c = sc.nextInt();

            System.out.println("Número de horas trabalhadas:");
            int n = sc.nextInt();

            int e;
            int salexcedente;
            int sal;
            if (n > 50) {
                e = n - 50;
                salexcedente = e * 20;
                sal = 50 * 10;
            } else {
                e = 0;
                salexcedente = e * 20;
                sal = n * 10;
            }

            System.out.println("\nOperário:" + c);
            System.out.println("Salário total = " + (sal + salexcedente));
            System.out.println("Salário excedente = " + salexcedente);

            System.out.println("\nDeseja encerrar o programa? (S/N)");
            condicao = sc.next();

            while (condicao.equalsIgnoreCase("S") != true && condicao.equalsIgnoreCase("N") != true) {
                System.out.println("Resposta inválida.");
                condicao = sc.next();
            }
            if (condicao.equalsIgnoreCase("S") == true) encerrar = true;
        } while (encerrar == false);
        sc.close();
    }
}
