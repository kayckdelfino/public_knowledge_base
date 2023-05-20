/*
Dado um array de inteiros e o seu número de elementos, inverta a posição dos seus elementos usando um método recursivo.
*/

package ExRecursividade.Ex04;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        inverte(nums, 0, 9);
        System.out.println(Arrays.toString(nums));
      }
    
      public static void inverte(int v[], int esq, int dir) {
        int t;
        if (esq >= dir) return;
        t = v[esq];
        v[esq] = v[dir];
        v[dir] = t;
        inverte(v, esq + 1, dir - 1);
      }
}