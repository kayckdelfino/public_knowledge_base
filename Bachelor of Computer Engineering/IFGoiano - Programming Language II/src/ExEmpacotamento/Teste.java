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
[ ] Tomando como base o exercício que cria as classes Gerente, Vendedor e Assistente a partir de uma classe abstrata Funcionário, crie uma classe de testes que, no método main, solicite ao usuário que digite:
1 para criar um Gerente;
2 para criar um Vendedor;
3 para criar um Assistente e
0 para sair do programa.
[ ] Depois de criado o Funcionário, solicite ao usuário que digite o nome e o código de matrícula. Atribua os valores aos respectivos atributos do objeto criado.
[ ] Mostre então os dados (incluindo o salário calculado segundo as regras do exercício anterior referido) no console.
[ ] Crie um jar com os arquivos necessários para executar esse programa via linha de comandos.
*/

package ExEmpacotamento;

import java.util.Scanner;

public class Teste {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);    
        boolean fim = false;

        while(!fim){
            System.out.println("\nDigite 1 para criar um gerente.");
            System.out.println("Digite 2 para criar um vendedor.");
            System.out.println("Digite 3 para criar um assistente.");
            System.out.println("Digite 0 para fechar o programa.");

            int opcao = sc.nextInt();
            if(opcao == 0) {
                fim = true;
                System.out.println("\nPrograma encerrado!");
            }
            else{
                String nome;
                String matricula;
                double salario_base;
                double comissao;

                switch (opcao){
                    case 1:
                        System.out.println("\nDigite o nome do gerente:");
                        nome = sc.next();
                        System.out.println("Digite a matrícula do gerente:");
                        matricula = sc.next();
                        System.out.println("Digite o salário base do gerente:");
                        salario_base = sc.nextDouble();

                        Gerente g1 = new Gerente(nome, matricula, salario_base);
                        g1.calculaSalario();
                        break;
                    case 2:
                        System.out.println("\nDigite o nome do vendedor:");
                        nome = sc.next();
                        System.out.println("Digite a matrícula do vendedor:");
                        matricula = sc.next();
                        System.out.println("Digite o salário base do vendedor:");
                        salario_base = sc.nextDouble();
                        System.out.println("Digite a comissão do vendedor:");
                        comissao = sc.nextDouble();

                        Vendedor v1 = new Vendedor(nome, matricula, salario_base, comissao);
                        v1.calculaSalario();
                        break;
                    case 3:
                        System.out.println("\nDigite o nome do assistente:");
                        nome = sc.next();
                        System.out.println("Digite a matrícula do assistente:");
                        matricula = sc.next();
                        System.out.println("Digite o salário base do assistente:");
                        salario_base = sc.nextDouble();

                        Assistente a1 = new Assistente(nome, matricula, salario_base);
                        a1.calculaSalario();
                        break;
                }
            }
        }
        sc.close();
    }
}