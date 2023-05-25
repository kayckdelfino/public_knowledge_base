/*
[ ] Crie uma hierarquia de classes que represente as formas geométricas círculo, quadrado, triângulo e retângulo.
[ ] Para todas essas formas, implemente métodos para o cálculo de área e perímetro.
[ ] Inclua como atributo nas respectivas classes as variáveis necessárias para se fazerem os cálculos.
[ ] aproveite atributos e métodos o máximo possível usando abstrações.
*/

package ExClasseAbstrata.Ex02;

public class Teste {
    public static void main(String[] args) {
        Circulo c1 = new Circulo(5);
        System.out.println(String.format("Área do Círculo: %.2f", c1.calcularArea()));
    }
}
