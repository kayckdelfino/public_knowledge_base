package ExEmpacotamento;

public class Vendedor extends Funcionario {
    private double comissao;

    public double getComissao() {
        return comissao;
    }

    public void setComissao(double comissao) {
        this.comissao = comissao;
    }

    public Vendedor(String nome, String matricula, double salario_base, double comissao) {
        super(nome, matricula, salario_base);
        this.comissao = comissao;
    }

    @Override
    public void calculaSalario() {
        System.out.println("Salário do Vendedor: " + (this.getSalario_base() + this.getComissao()));
    }
}