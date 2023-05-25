/*
[ ] Implemente um método recursivo que receba como entrada dois números inteiros x e k e retorne o valor da operação xk. Não utilize o método Math.pow() do Java. Utilize apenas multiplicação.
*/

package ExRecursividade.Ex03;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite x: ");
        int x = sc.nextInt();
        sc.nextLine();
        System.out.println("Digite k: ");
        int k = sc.nextInt();
    
        int resultado = potencia(x, k);
        System.out.println(resultado);

        sc.close();
      }
    
      static int potencia(int x, int k) {
        if (k == 0)
          return 1;
        else
          return x * potencia(x, k - 1);
      }
}