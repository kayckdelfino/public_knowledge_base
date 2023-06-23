package Ex01;

import java.util.Scanner;

public class CalcEstoqueMedio {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Quantidade mínima da peça: ");
        int min = sc.nextInt();

        System.out.println("Quantidade máxima da peça: ");
        int max = sc.nextInt();

        sc.close();
        System.out.println("Estoque médio: " + ((float) min + (float) max) / 2);
    }
}