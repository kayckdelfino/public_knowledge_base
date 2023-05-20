package ExEmpacotamento;

public class Assistente extends Funcionario {
    public Assistente(String nome, String matricula, double salario_base) {
        super(nome, matricula, salario_base);
    }

    @Override
    public void calculaSalario() {
        System.out.println("Salário do Assistente: " + this.getSalario_base());
    }
}