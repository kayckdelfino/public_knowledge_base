/*
[ ] Crie uma hierarquia de classes para representar os diferentes tipos de funcionários de um escritório que tem os seguintes cargos: gerente, assistente, vendedor.
[ ] Escreva uma classe base abstrata chamada Funcionario que declara um método abstrato: double calculaSalario()
[ ] Esta classe também deve definir os seguintes atributos: nome (tipo String), matricula (tipo String) e salario_base (tipo double).
[ ] Use encapsulamento e forneça um construtor que recebe os valores correspondentes a serem armazenados nos respectivos atributos.
[ ] Esta classe abstrata deverá ser estendida pelas outras classes representativas dos tipos de funcionários, portanto devem ser escritas as classes Gerente, Assistente e Vendedor.
[ ] Em cada classe deve-se sobrescrever o método calculaSalario de forma que cálculo do salário seja feito assim:
O gerente recebe duas vezes o salário_base
o assistente recebe o salário_base
o vendedor recebe o salário_base mais uma comissão definida no construtor de sua classe
[ ] Crie uma classe Teste com um método main que cria um objeto de cada tipo e os armazena em uma lista
[ ] Calcule a folha salarial dos três funcionários e imprima o valor total
*/

package ExClasseAbstrata.Ex01;

public class Teste {
    public static void main(String[] args) {
        Assistente a1 = new Assistente("Assistente", "001", 1000);
        Gerente g1 = new Gerente("Gerente", "002", 1500);
        Vendedor v1 = new Vendedor("Vendedor", "003", 800, 200);

        a1.calculaSalario();
        g1.calculaSalario();
        v1.calculaSalario();
    }
}
