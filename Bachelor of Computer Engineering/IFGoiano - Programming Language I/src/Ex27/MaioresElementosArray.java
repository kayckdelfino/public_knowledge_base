package Ex27;

import java.util.ArrayList;
import java.util.Scanner;

public class MaioresElementosArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Integer> array = new ArrayList<>();

        System.out.println("Insira números: (0 para parar)");
        boolean encerrar = false;
        do {
            int n = sc.nextInt();
            if (n != 0) {
                array.add(n);
            } else encerrar = true;
        } while (encerrar == false);

        System.out.println("Quantos números serão analisados?");
        int x = sc.nextInt();
        while (x > array.size()) {
            System.out.println("Este valor não deve ser maior que o tamanho do array! Insira novamente:");
            x = sc.nextInt();
        }

        System.out.println("\nArray original: " + array);

        int maior = Integer.MIN_VALUE;
        int indice = 0;
        System.out.print(x + " maiores números: ");
        do {
            for (int i = 0; i < array.size(); i++) {
                if (array.get(i) > maior) {
                    maior = array.get(i);
                    indice = i;
                }
            }
            System.out.print(maior + " ");
            array.remove(indice);
            maior = Integer.MIN_VALUE;
            x--;
        } while (x > 0);
    }
}
