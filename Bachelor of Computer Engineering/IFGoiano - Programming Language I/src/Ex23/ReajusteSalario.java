package Ex23;

import java.util.Scanner;

public class ReajusteSalario {

    static double reajuste(double salario, double aumento) {
        return salario * aumento;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Qual o salário atual?");
        double salario = sc.nextDouble();

        System.out.println("Qual a porcentagem de acréscimo ou decréscimo?");
        double aumento = sc.nextDouble();
        sc.close();

        aumento = (1 + (aumento / 100));

        System.out.println("\nNovo salário = " + reajuste(salario, aumento));
    }
}
