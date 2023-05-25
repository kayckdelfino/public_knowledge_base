package Excecoes;

public class ErroDeBuscaException extends Exception {
    public ErroDeBuscaException() {
        super();
    }

    public ErroDeBuscaException(String mensagem) {
        super(mensagem);
    }

    public ErroDeBuscaException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }

    public ErroDeBuscaException(Throwable causa) {
        super(causa);
    }
}