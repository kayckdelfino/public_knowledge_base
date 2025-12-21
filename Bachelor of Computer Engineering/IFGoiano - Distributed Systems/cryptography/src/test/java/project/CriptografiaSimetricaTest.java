package project;

import static org.junit.jupiter.api.Assertions.*;

import javax.crypto.SecretKey;

import org.junit.jupiter.api.Test;

public class CriptografiaSimetricaTest {

  @Test
  void cifrarEDecifrarMensagem() {
    SecretKey chave = CriptografiaSimetrica.gerarChave();

    byte[] textoPlano = "mensagem".getBytes();

    byte[] textoCifrado = CriptografiaSimetrica.cifrar(textoPlano, chave);
    byte[] textoDecifrado = CriptografiaSimetrica.decifrar(textoCifrado, chave);

    assertEquals(new String(textoDecifrado), "mensagem");
  }

}
