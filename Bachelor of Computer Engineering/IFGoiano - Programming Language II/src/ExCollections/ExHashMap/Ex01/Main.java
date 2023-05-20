/*
[ ] Crie uma classe SalaDeAula que contenha uma coleção de alunos. Cada aluno deve ter um nome e uma matrícula. Crie métodos na sala de aula para buscar um aluno pela sua matrícula. Crie um método para imprimir todos os alunos matriculados na sala de aula. Dica: use a coleção como HashMap.
[ ] Crie um programa que tenha um HashMap com 10 pares de chave-valor. Crie um método que extraia os valores do HashMap e os guarde em um ArrayList.
*/

package ExCollections.ExHashMap.Ex01;

public class Main {
    public static void main(String[] args) {
        SalaDeAula s1 = new SalaDeAula();
        s1.alunos.put(1, new Aluno("Kayck", "001"));
        s1.alunos.put(2, new Aluno("João", "002"));
        s1.alunos.put(3, new Aluno("Marcos", "003"));

        // s1.imprimeSala();
        System.out.println(s1.buscaAluno("002"));

    }
}