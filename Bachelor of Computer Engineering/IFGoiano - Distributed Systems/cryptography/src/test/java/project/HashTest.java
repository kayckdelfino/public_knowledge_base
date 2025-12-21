package project;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class HashTest {
  @Test
  void gerarHashValido() {
    byte[] textoPlano = "mensagem".getBytes();

    String hash = Hash.executarSha1(textoPlano);

    assertEquals(hash, "d3d357c16c68e1ed1b1b3ea80cf91cb613c6bf55");
  }

  @Test
  void gerarHashParaMesmoValor() {
    byte[] textoPlanoPrimeiro = "mensagem".getBytes();
    byte[] textoPlanoSegundo = "mensagem".getBytes();

    String hashPrimeiro = Hash.executarSha1(textoPlanoPrimeiro);
    String hashSegundo = Hash.executarSha1(textoPlanoSegundo);

    assertTrue(hashPrimeiro.equals(hashSegundo));
  }
}
