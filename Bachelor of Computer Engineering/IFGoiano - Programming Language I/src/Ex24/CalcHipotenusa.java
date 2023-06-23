package Ex24;

import java.util.Scanner;

public class CalcHipotenusa {

    static double hipotenusa(double cat_oposto, double cat_adjascente) {
        return (Math.sqrt(Math.pow(cat_oposto, 2) + Math.pow(cat_adjascente, 2)));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Programa: Calcula hipotenusa.");

        System.out.println("\nInsira o valor do cateto oposto:");
        double cat_oposto = sc.nextDouble();

        System.out.println("Insira o valor do cateto adjascente:");
        double cat_adjascente = sc.nextDouble();
        sc.close();

        System.out.println("\nO valor da hipotenusa é: " + hipotenusa(cat_oposto, cat_adjascente));
    }
}
