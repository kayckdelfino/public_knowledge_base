package Ex26;

import java.util.Arrays;
import java.util.Scanner;

public class MatrizBooleanAnd {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Insira o número de linhas e colunas da matriz:");
        int x = sc.nextInt();

        boolean[][] matriz = new boolean[x][x];
        System.out.println("\nInsira os valores da matriz booleana:");
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = sc.nextBoolean();
            }
        }

        System.out.println("\nMatriz:");
        for (int i = 0; i < matriz.length; i++) System.out.println(Arrays.toString(matriz[i]));
        System.out.println();

        boolean[][] matrizbooleana = new boolean[x][x];
        for (int i = 0; i < matrizbooleana.length; i++) {
            for (int j = 0; j < matrizbooleana[i].length; j++) {
                boolean b;
                if (matriz[i][j] == true && matriz[j][i] == true) b = true;
                else b = false;
                matrizbooleana[i][j]= b;
            }
        }

        System.out.println("\nMatriz booleana:");
        for (int i = 0; i < matrizbooleana.length; i++) System.out.println(Arrays.toString(matrizbooleana[i]));
    }
}
