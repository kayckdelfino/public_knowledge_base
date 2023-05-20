package Ex25;

import java.util.Arrays;
import java.util.Scanner;

public class MatrizTransposta {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Programa: Transposta matriz quadrada.");

        System.out.println("Insira o número de linhas e colunas da matriz:");
        int x = sc.nextInt();

        int[][] matriz = new int[x][x];

        System.out.println("\nInsira os valores da matriz:");
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = sc.nextInt();
            }
        }

        int[][] transposta = new int[x][x];

        for (int i = 0; i < transposta.length; i++) {
            for (int j = 0; j < transposta[i].length; j++) {
                transposta[i][j] = matriz[j][i];
            }
        }

        System.out.println("\nMatriz original:");
        for (int i = 0; i < matriz.length; i++) System.out.println(Arrays.toString(matriz[i]));

        System.out.println("\nTransposta:");
        for (int i = 0; i < matriz.length; i++) System.out.println(Arrays.toString(transposta[i]));
    }
}
