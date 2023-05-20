/*
Tomando com o base o código em:

https://github.com/loiane/estrutura-dados-algoritmos-java/blob/master/src/com/loiane/estruturadados/lista/ListaEncadeada.java

crie os métodos para adicionar um item depois de um nó específico (buscar pelo valor) e outro método para remover um nó específico (buscar pelo valor).

*/

package ExCollections.ExLinkedList;

public class Main {
    public static void main(String[] args) {
        ListaEncadeada<Integer> lista = new ListaEncadeada<>();
        lista.adiciona(1);

        System.out.println("Tamanho = " + lista.getTamanho());
        System.out.println(lista);

        lista.adiciona(2);
        System.out.println(lista);

        lista.adiciona(3);
        System.out.println(lista);

        lista.adicionaDepoisDe(6, 2);
        System.out.println(lista);

        lista.removeElemento(6);
        System.out.println(lista);

        // lista.limpa();
        // System.out.println(lista);
    }
}