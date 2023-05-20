/*
[ ] Crie um programa que solicite ao usuário a digitação de um número entre 0 e 100. Continue solicitando até que ele digite um valor fora do intervalo (exiba uma mensagem no console dizendo que o programa foi encerrado). Use um map para contar quantas vezes o usuário digita o mesmo número (use o número como chave e o contador de repetições como valor).
[ ] Percorra o map do exercício anterior, substituindo o valor em cada chave de acordo com a seguinte regra:
0 a 5 = 5
6 ou mais = 10
[ ] Transforme o map do exercício anterior em um list de forma que o índice dessa lista seja a chave do map e o valor nos respectivos índices sejam os valores em cada chave do map.
*/

package ExCollections.ExHashMap.Ex02;

import java.util.HashMap;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<Integer, Integer> lista = new HashMap<>();

        // Primeira parte

        System.out.println("Digite valores entre 0 e 100:");
        boolean condicao = true;
        while (condicao) {
            int i = sc.nextInt();
            if (i >= 0 && i <= 100) {
                if (!lista.containsKey(i)) {
                    lista.put(i, 1);
                } else {
                    int contagem = lista.get(i);
                    lista.replace(i, contagem, contagem + 1);
                }
            } else {
                System.out.println("\nPrograma encerrado!");
                condicao = false;
            }
        }

        for (Integer i : lista.keySet()) {
            System.out.println("Número " + i + " foi inserido " + lista.get(i) + " vezes.");
        }
        System.out.println();

        // Terceira parte

        ArrayList<Integer> lista2 = new ArrayList<>();

        for (int i = 0; i < 101; i++) {
            if (lista.containsKey(i))
                lista2.add(lista.get(i));
            else
                lista2.add(0);
        }

        for (int i : lista2)
            System.out.println(i);

            sc.close();
    }
}