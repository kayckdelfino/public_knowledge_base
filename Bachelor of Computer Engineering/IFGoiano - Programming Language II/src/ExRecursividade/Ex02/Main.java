/*
[ ] Implemente um método recursivo que receba como entrada um número inteiro positivo N e retorne o seguinte cálculo:
1+1/2+1/3+1/4 + ... + 1/N
*/

package ExRecursividade.Ex02;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite um número: ");
        int n = sc.nextInt();
    
        float soma = somaFracaoRecursiva(n);
        System.out.println(soma);

        sc.close();
      }
    
      static float somaFracaoRecursiva(float n) {
        if (n - 1 > 0) {
          return (1 / n) + somaFracaoRecursiva(n - 1);
        } else return (1 / n);
      }
}