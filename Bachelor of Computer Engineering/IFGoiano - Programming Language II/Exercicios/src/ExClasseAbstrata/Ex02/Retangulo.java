package ExClasseAbstrata.Ex02;

public class Retangulo implements FormaGeometrica {
    double base;
    double altura;

    public Retangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }

    @Override
    public double calcularArea() {
        return this.base * this.altura;
    }

    @Override
    public double calcularPerimetro() {
        return 2 * (this.base + this.altura);
    }
}
