package Modelos;

public class Aluno extends Pessoa implements Comparable<Aluno> {
    private int matricula;

    public Aluno(String nome, String sobrenome, int matricula) {
        super(nome, sobrenome);
        this.matricula = matricula;
    }

    public int getMatricula() {
        return matricula;
    }
    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    // Parte do passo (C)
    @Override
    public int compareTo(Aluno outroAluno) {
        if(this.matricula < outroAluno.matricula) return -1;
        if (this.matricula > outroAluno.matricula) return 1;
        else return 0;
    }
}