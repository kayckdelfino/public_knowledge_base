package Ex30;

import java.util.Arrays;
import java.util.Scanner;

public class MoveArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Quantos números serão inseridos?");
        int x = sc.nextInt();

        int[] n = new int[x];

        for (int i = 0; i < x; i++) {
            n[i] = sc.nextInt();
        }
        sc.close();

        Arrays.sort(n);
        System.out.println(Arrays.toString(n));
    }
}