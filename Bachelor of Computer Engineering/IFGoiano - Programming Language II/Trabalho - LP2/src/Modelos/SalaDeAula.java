package Modelos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SalaDeAula {
    private String identificacao;
    private ArrayList<Aluno> alunos;
    private Professor professor;
    
    public SalaDeAula(String identificacao, ArrayList<Aluno> alunos, Professor professor) {
        this.identificacao = identificacao;
        this.alunos = alunos;
        this.professor = professor;
    }
    public SalaDeAula(String identificacao, ArrayList<Aluno> alunos) {
        this.identificacao = identificacao;
        this.alunos = alunos;
    }

    public String getIdentificacao() {
        return identificacao;
    }


    public void setIdentificacao(String identificacao) {
        this.identificacao = identificacao;
    }


    public ArrayList<Aluno> getAlunos() {
        return alunos;
    }


    public void setAlunos(ArrayList<Aluno> alunos) {
        this.alunos = alunos;
    }


    public Professor getProfessor() {
        return professor;
    }


    public void setProfessor(Professor professor) {
        this.professor = professor;
    }


    // Método pra inserir um novo aluno à sala de aula
    public void inserirAluno(Aluno aluno){
        this.alunos.add(aluno);
    }

    // Método pra remover um aluno da sala de aula, baseado no nome
    public void removerAluno(String nome){
        for(Aluno a : this.alunos){
            if(a.getNome().equals(nome)) this.alunos.remove(a);
        }
    }

    // Método pra definir o professor da sala de aula
    public void alterarProfessor(Professor professor) {
        this.professor = professor;
    }

    // Método pra ordenar os alunos da sala de aula em ordem alfabética
    public void ordenarAlunosPorNome(){
        Collections.sort(alunos, new Comparator<Aluno>() {
            @Override
            public int compare(Aluno a1, Aluno a2) {
                return a1.getNome().compareTo(a2.getNome());
            }
        });
    }

    // Método pra ordenar os alunos da sala de aula por matrícula
    public void ordenarAlunosPorMatricula(){
        Collections.sort(this.alunos);
    }


    // Extra (não foi pedido no trabalho)
    public void imprimeSala(){
        System.out.println("Número da sala = " + this.identificacao);
        for(Aluno a : this.alunos){
            System.out.println("Aluno [nome=" + a.getNome() + " sobrenome=" + a.getSobrenome() + " matricula=" + a.getMatricula() + "]");
        }
        System.out.println("Professor [nome=" + this.professor.getNome() + " sobrenome=" + this.professor.getSobrenome() + " disciplina=" + this.professor.getDisciplina() + "]");
    }
}