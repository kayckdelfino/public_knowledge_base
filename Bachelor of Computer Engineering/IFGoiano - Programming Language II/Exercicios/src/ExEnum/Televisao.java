/*
[ ] Crie um Enum Java que contenha valores de 4 modelos de televisão disponíveis em uma loja. Cada modelo deve ser identificado no enum com um código (número arbitrário)
[ ] Crie uma classe de teste que peça para o usuário digitar um código numérico e mostre o nome do modelo baseado nesse valor no console.
[ ] Crie um método nessa classe de testes que mostre todos os nomes e todos os valores correspondentes dos modelos disponíveis.
*/

package ExEnum;

import java.util.Scanner;

public class Televisao{
    public enum Tv{
        MODELO_1(1),
        MODELO_2(2),
        MODELO_3(3),
        MODELO_4(4);
        
        private int x;

        public int getX(){
            return x;
        }

        Tv(int x){
            this.x = x;
        }
    }

    static void mostraModelos(){
        for(Televisao.Tv Tv : Televisao.Tv.values()){
            System.out.println(Tv + " chave: " + Tv.getX());
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite um valor:");
        int x = sc.nextInt();

        for(Tv tv : Tv.values()){
            if(tv.getX() == x) System.out.println("Modelo do valor digitado: " + tv + "\n");
        }

        mostraModelos();

        sc.close();
    }
}