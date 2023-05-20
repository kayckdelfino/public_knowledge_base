package Ex12;

import java.util.Scanner;
import java.util.ArrayList;

public class MaiorMenorArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Double> numeros = new ArrayList<>();

        System.out.println("Insira números: (0 para parar)");

        boolean encerrar = false;
        do {
            double n = sc.nextDouble();
            if (n != 0) {
                numeros.add(n);
            } else encerrar = true;
        } while (encerrar == false);

        double menor = Double.MAX_VALUE;
        double maior = - Double.MAX_VALUE;
        for (double i : numeros) {
            menor = i < menor ? i : menor;
            maior = i > maior ? i : maior;
        }

        System.out.println("Maior número inserido: " + maior);
        System.out.println("Menor número inserido: " + menor);
    }
}
