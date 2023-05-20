/*
[ ] Crie uma classe que contenha um array de inteiros de 10 posições. Feito isso, permita que o usuário digite valores inteiros a fim de preencher este array até que se digite o valor 0. Uma vez digitado o valor 0, o mesmo deve ser inserido no vetor e a digitação de novos elementos deve ser interrompida. Feita toda a coleta dos dados, exiba-os no console. 
Sua classe deve tratar as seguintes exceções:

ArrayIndexOutOfBoundsException quando o usuário informar mais que 10 valores.
InputMismatchException quando o usuário informar um valor que não é numerico.
*/

package ExExceptions.Ex02;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] array = new int[10];
        
        try (Scanner sc = new Scanner(System.in)) {
            try {
                int index = 0;
                int input;
                
                do{
                    if(index > 9) throw new IndexOutOfBoundsException("Excedeu o limite do array!");

                    System.out.println("Digite o " + (index + 1) + "º número: ");
                    input = sc.nextInt();

                    array[index] = input;
                    index++;
                } while (input !=0 );
                System.out.println(Arrays.toString(array));
            } catch (IndexOutOfBoundsException iobe) {
                System.out.println(iobe.getMessage());
            } catch (InputMismatchException ime) {
                System.out.println("Valor não numérico.");
            }
        }
    }
}