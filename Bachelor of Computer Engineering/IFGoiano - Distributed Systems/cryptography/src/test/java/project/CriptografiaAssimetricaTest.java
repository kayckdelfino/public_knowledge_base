package project;

import static org.junit.jupiter.api.Assertions.*;

import java.security.KeyPair;

import org.junit.jupiter.api.Test;

public class CriptografiaAssimetricaTest {
  @Test
  void cifrarEDecifrarMensagem() throws Exception {
    KeyPair chaves = CriptografiaAssimetrica.gerarChaves();

    byte[] textoPlano = "mensagem".getBytes();

    byte[] textoCifrado = CriptografiaAssimetrica.cifrar(textoPlano, chaves.getPublic());
    byte[] textoDecifrado = CriptografiaAssimetrica.decifrar(textoCifrado, chaves.getPrivate());

    assertEquals(new String(textoDecifrado), "mensagem");
  }

  @Test
  void cifrarEDecifrarMensagemInvertendoAsChaves() throws Exception {
    KeyPair chaves = CriptografiaAssimetrica.gerarChaves();

    byte[] textoPlano = "mensagem".getBytes();

    byte[] textoCifrado = CriptografiaAssimetrica.cifrar(textoPlano, chaves.getPrivate());
    byte[] textoDecifrado = CriptografiaAssimetrica.decifrar(textoCifrado, chaves.getPublic());

    assertEquals(new String(textoDecifrado), "mensagem");
  }
}
