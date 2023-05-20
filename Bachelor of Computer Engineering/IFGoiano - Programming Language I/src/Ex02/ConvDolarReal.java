package Ex02;

import java.util.Scanner;

public class ConvDolarReal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Qual a cotação atual do dólar? ");
        float cot = sc.nextFloat();

        System.out.println("Informe um valor em dólares: ");
        float dol = sc.nextFloat();

        System.out.println(String.format("O valor em reais será: %.2f", (dol * cot)));
    }
}
