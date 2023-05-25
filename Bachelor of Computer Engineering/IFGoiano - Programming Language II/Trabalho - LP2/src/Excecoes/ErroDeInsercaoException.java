package Excecoes;

public class ErroDeInsercaoException extends Exception {
    public ErroDeInsercaoException() {
        super();
    }

    public ErroDeInsercaoException(String mensagem) {
        super(mensagem);
    }

    public ErroDeInsercaoException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }

    public ErroDeInsercaoException(Throwable causa) {
        super(causa);
    }
}