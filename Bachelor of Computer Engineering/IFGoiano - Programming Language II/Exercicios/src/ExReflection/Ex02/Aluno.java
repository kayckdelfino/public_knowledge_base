package ExReflection.Ex02;

public class Aluno {
    private String nome;
    private String codigo;
    private String telefone;
    private String endereco;
    private int ano_nascimento;
    private boolean online;
    
    public Aluno(){}

    public Aluno(String nome, String codigo, String telefone, String endereco, int ano_nascimento, boolean online) {
        this.nome = nome;
        this.codigo = codigo;
        this.telefone = telefone;
        this.endereco = endereco;
        this.ano_nascimento = ano_nascimento;
        this.online = online;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    public int getAno_nascimento() {
        return ano_nascimento;
    }
    public void setAno_nascimento(int ano_nascimento) {
        this.ano_nascimento = ano_nascimento;
    }
    public boolean isOnline() {
        return online;
    }
    public void setOnline(boolean online) {
        this.online = online;
    }

    @Override
    public String toString() {
        return "Aluno [nome=" + nome + ", codigo=" + codigo + ", telefone=" + telefone + ", endereco=" + endereco
                + ", ano_nascimento=" + ano_nascimento + ", online=" + online + "]";
    }
}