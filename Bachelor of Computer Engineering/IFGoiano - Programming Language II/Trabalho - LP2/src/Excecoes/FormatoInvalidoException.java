package Excecoes;

public class FormatoInvalidoException extends Exception {
    public FormatoInvalidoException() {
        super();
    }

    public FormatoInvalidoException(String mensagem) {
        super(mensagem);
    }

    public FormatoInvalidoException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }

    public FormatoInvalidoException(Throwable causa) {
        super(causa);
    }
}