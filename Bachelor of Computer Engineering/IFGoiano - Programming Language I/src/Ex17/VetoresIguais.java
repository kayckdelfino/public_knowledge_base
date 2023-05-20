package Ex17;

import java.util.Scanner;
import java.util.ArrayList;

public class VetoresIguais {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Integer> v1 = new ArrayList<>();
        ArrayList<Integer> v2 = new ArrayList<>();

        boolean encerrar = false;

        System.out.println("Insira números inteiros ao vetor V1: (0 pra parar)");
        do {
            int n = sc.nextInt();
            if (n != 0 && v1.size() < 50) {
                v1.add(n);
            } else encerrar = true;
        } while (encerrar == false);


        encerrar = false;
        System.out.println("Insira números inteiros ao vetor V2: (0 pra parar)");
        do {
            int n = sc.nextInt();
            if (n != 0 && v2.size() < 50) {
                v2.add(n);
            } else encerrar = true;
        } while (encerrar == false);

        int iguais = 0;
        if (v1.size() < v2.size()) {
            for (int i = 0; i < v1.size(); i++) {
                if (v1.get(i) == v2.get(i)) iguais++;
            }
        } else {
            for (int i = 0; i < v2.size(); i++) {
                if (v1.get(i) == v2.get(i)) iguais++;
            }
        }

        System.out.println("\nV1 = " + v1);
        System.out.println("V2 = " + v2);
        System.out.println("Os vetores V1 e V2 possuem " + iguais + " valores idênticos nas mesmas posições.");
    }
}
