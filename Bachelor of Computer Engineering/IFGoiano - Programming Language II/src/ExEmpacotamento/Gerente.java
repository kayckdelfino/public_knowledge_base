package ExEmpacotamento;

public class Gerente extends Funcionario {
    public Gerente(String nome, String matricula, double salario_base) {
        super(nome, matricula, salario_base);
    }

    @Override
    public void calculaSalario() {
        System.out.println("Salário do Gerente: " + (2 * this.getSalario_base()));
    }
}