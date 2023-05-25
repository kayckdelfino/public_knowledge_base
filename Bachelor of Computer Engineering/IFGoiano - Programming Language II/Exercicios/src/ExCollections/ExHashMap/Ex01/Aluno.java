package ExCollections.ExHashMap.Ex01;

public class Aluno {
    String nome;
    String matricula;

    public Aluno(String nome, String matricula) {
        this.nome = nome;
        this.matricula = matricula;
    }

    @Override
    public String toString() {
        return "Aluno [nome=" + nome + ", matricula=" + matricula + "]";
    }

}