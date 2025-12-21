package project;

import static org.junit.jupiter.api.Assertions.*;

import java.security.KeyPair;

import org.junit.jupiter.api.Test;

public class ExercicioTest {
    @Test
    // Pessoa A envia uma mensagem para pessoa B e a mensagem está íntegra
    void validarMensagemSucesso() throws Exception {
        KeyPair chaves = CriptografiaAssimetrica.gerarChaves();

        byte[] mensagemEnviada = "mensagem".getBytes();
        byte[] certificadoGerado = Exercicio.gerarCertificado(mensagemEnviada, chaves.getPrivate());

        assertTrue(Exercicio.validarMensagem(mensagemEnviada, certificadoGerado, chaves.getPublic()));
    }

    @Test
    // Pessoa A envia uma mensagem para pessoa B e a mensagem foi modificada
    void validarMensagemErro() throws Exception {
        KeyPair chaves = CriptografiaAssimetrica.gerarChaves();

        byte[] mensagemEnviada = "mensagem".getBytes();
        byte[] certificadoGerado = Exercicio.gerarCertificado(mensagemEnviada, chaves.getPrivate());

        byte[] mensagemModificada = "mensagem modificada".getBytes();

        assertFalse(Exercicio.validarMensagem(mensagemModificada, certificadoGerado, chaves.getPublic()));
    }
}
