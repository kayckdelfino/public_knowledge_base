package Modelos;

public class Professor extends Pessoa{
    private String disciplina;

    public Professor(String nome, String sobrenome, String disciplina) {
        super(nome, sobrenome);
        this.disciplina = disciplina;
    }

    public String getDisciplina() {
        return disciplina;
    }
    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }
}