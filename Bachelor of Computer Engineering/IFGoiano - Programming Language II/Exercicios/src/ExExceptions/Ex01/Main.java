/*
[ ] Crie uma classe que aceite a digitação de dois números e faça a divisão entre eles exibindo seu resultado. Sua classe deve tratar as seguintes exceções:

ArithmeticException quando ocorrer uma divisão por zero.
InputMismatchException quando o valor informado não é numerico.
*/

package ExExceptions.Ex01;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("Digite o primeiro número:");
            int n1 = sc.nextInt();

            System.out.println("Digite o segundo número:");
            int n2 = sc.nextInt();

            System.out.println(n1 / n2);
        } catch (ArithmeticException e) {
            System.out.println("Divisão por zero!");
        } catch (InputMismatchException e) {
            System.out.println("Tipo não numérico.");
        }

        sc.close();
    }
}