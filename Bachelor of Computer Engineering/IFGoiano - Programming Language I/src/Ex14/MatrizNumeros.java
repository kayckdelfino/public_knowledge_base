package Ex14;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class MatrizNumeros {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Integer> numeros = new ArrayList<>();

        System.out.println("Insira números inteiros: (0 para parar)");
        boolean encerrar = false;

        do {
            int n = sc.nextInt();
            if (n != 0) {
                numeros.add(n);
            } else encerrar = true;
        } while (encerrar == false);
        sc.close();

        double proporcao = Math.sqrt(numeros.size());
        proporcao = Math.ceil(proporcao);

        int[][] matriz = new int[(int) proporcao][(int) proporcao];
        int posicao = 0;

        for (int i = 0; i < proporcao; i++) {
            for (int j = 0; j < proporcao; j++) {
                if (posicao >= numeros.size()) matriz[i][j] = 0;
                else matriz[i][j] = numeros.get(posicao);
                posicao++;
            }
        }

        System.out.println("\nMatriz Resultante:");
        for (int i = 0; i < proporcao; i++) System.out.println(Arrays.toString(matriz[i]));
    }
}
