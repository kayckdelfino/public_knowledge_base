package ExCollections.ExLinkedList;

public class ListaEncadeada<T> {
    private No<T> inicio;
    private No<T> ultimo;
    private int tamanho = 0;

    public void adiciona(T elemento) {
        No<T> celula = new No<T>(elemento);
        if (this.tamanho == 0) {
            this.inicio = celula;
        } else {
            this.ultimo.setProximo(celula);
        }
        this.ultimo = celula;
        this.tamanho++;
    }

    public int getTamanho() {
        return this.tamanho;
    }

    public void limpa() {

        for (No<T> atual = this.inicio; atual != null;) {
            No<T> proximo = atual.getProximo();
            atual.setElemento(null);
            atual.setProximo(null);
            atual = proximo;
        }

        this.inicio = null;
        this.ultimo = null;
        this.tamanho = 0;
    }

    @Override
    public String toString() {

        // [1, 2, 3, 4]

        if (this.tamanho == 0) {
            return "[]";
        }

        StringBuilder builder = new StringBuilder("[");
        // builder.append("ListaEncadeada [inicio=").append(inicio).append("]");

        No<T> atual = this.inicio;
        for (int i = 0; i < this.tamanho - 1; i++) {
            builder.append(atual.getElemento()).append(",");
            atual = atual.getProximo();
        }
        builder.append(atual.getElemento()).append("]");
        /*
         * builder.append(atual.getElemento()).append(",");
         * while (atual.getProximo() != null) {
         * atual = atual.getProximo();
         * builder.append(atual.getElemento()).append(",");
         * }
         */

        return builder.toString();
    }

    public void adicionaDepoisDe(T elemento, T elExistente) {
        No<T> atual = this.inicio;
        while (atual != null) {
            if (atual.getElemento().equals(elExistente)) {
                No<T> celula = new No<T>(elemento);
                celula.setProximo(atual.getProximo());
                atual.setProximo(celula);
                if (ultimo == elExistente) {
                    this.ultimo = celula;
                }
                this.tamanho++;
                return;
            }
            atual = atual.getProximo();
        }
    }

    public void removeElemento(T elExistente) {
        No<T> atual = this.inicio;
        No<T> anterior = null;

        while (atual != null && !atual.getElemento().equals(elExistente)) {
            anterior = atual;
            atual = atual.getProximo();
        }

        if (atual != null) {
            if (anterior == null) {
                this.inicio = atual.getProximo();
            } else {
                anterior.setProximo(atual.getProximo());
            }
            if (this.ultimo == atual) {
                this.ultimo = anterior;
            }
            this.tamanho--;
        }
    }
}