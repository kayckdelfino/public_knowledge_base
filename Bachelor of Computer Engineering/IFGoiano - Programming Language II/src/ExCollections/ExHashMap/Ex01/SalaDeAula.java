/*
[ ] Crie uma classe SalaDeAula que contenha uma coleção de alunos. Cada aluno deve ter um nome e uma matrícula. Crie métodos na sala de aula para buscar um aluno pela sua matrícula. Crie um método para imprimir todos os alunos matriculados na sala de aula. Dica: use a coleção como HashMap.
[ ] Crie um programa que tenha um HashMap com 10 pares de chave-valor. Crie um método que extraia os valores do HashMap e os guarde em um ArrayList.
*/

package ExCollections.ExHashMap.Ex01;

import java.util.HashMap;

public class SalaDeAula {
    HashMap<Integer, Aluno> alunos = new HashMap<Integer, Aluno>();

    public Aluno buscaAluno(String matricula) {
        try {
            for (Aluno a : this.alunos.values()) {
                if (a.matricula.equals(matricula)) {
                    return a;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void imprimeSala() {
        try {
            for (Aluno a : this.alunos.values()) {
                System.out.println(a.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}