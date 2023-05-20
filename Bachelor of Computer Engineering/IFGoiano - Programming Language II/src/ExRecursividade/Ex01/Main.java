/*
[ ] Implemente um método recursivo que receba como entrada um número inteiro positivo N e retorne o seguinte cálculo:
1 + 2 + 3 + 4 + ... + N
*/

package ExRecursividade.Ex01;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite um número: ");
        int n = sc.nextInt();

        int soma = somaRecursiva(n);
        System.out.println(soma);

        sc.close();
    }

    static int somaRecursiva(int n) {
        if (n - 1 > 0) {
            return n + somaRecursiva(n - 1);
        } else return n;
    }
}