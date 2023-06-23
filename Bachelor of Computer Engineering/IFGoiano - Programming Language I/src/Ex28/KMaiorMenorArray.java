package Ex28;

import java.util.ArrayList;
import java.util.Scanner;

public class KMaiorMenorArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Integer> array = new ArrayList<>();

        System.out.println("Insira números: (0 para parar)");
        boolean encerrar = false;
        do {
            int n = sc.nextInt();
            if (n != 0) {
                array.add(n);
            } else encerrar = true;
        } while (encerrar == false);

        System.out.println("\nArray original: " + array);

        System.out.println("N-ésimo maior valor:");
        int n = sc.nextInt();
        while (n > array.size()) {
            System.out.println("Este valor não deve ser maior que o tamanho do array! Insira novamente:");
            n = sc.nextInt();
        }

        int[] removidos = new int[n];
        int indice = 0, maior, aux = n, tam = 0;
        do {
            maior = Integer.MIN_VALUE;
            for (int i = 0; i < array.size(); i++) {
                if (array.get(i) > maior) {
                    maior = array.get(i);
                    indice = i;
                }
            }
            removidos[tam] = array.get(indice);
            tam++;
            array.remove(indice);
            aux--;
        } while (aux > 0);

        for (int removido : removidos) {
            array.add(removido);
        }

        System.out.println("M-ésimo menor valor:");
        int m = sc.nextInt();
        while (m > array.size()) {
            System.out.println("Este valor não deve ser maior que o tamanho do array! Insira novamente:");
            m = sc.nextInt();
        }
        sc.close();

        indice = 0;
        aux = m;
        int menor;
        do {
            menor = Integer.MAX_VALUE;
            for (int i = 0; i < array.size(); i++) {
                if (array.get(i) < menor) {
                    menor = array.get(i);
                    indice = i;
                }
            }
            array.remove(indice);
            aux--;
        } while (aux > 0);

        System.out.println();
        System.out.println(n + "º maior valor: " + maior);
        System.out.println(m + "º menor valor: " + menor);
    }
}

