package project;

import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;

import javax.crypto.Cipher;

public class CriptografiaAssimetrica {

  public static byte[] cifrar(byte[] textoPlano, Key chavePrivada) {
    return executar(textoPlano, Cipher.ENCRYPT_MODE, chavePrivada);
  }

  public static byte[] decifrar(byte[] textoPlano, Key chavePrivada) {
    return executar(textoPlano, Cipher.DECRYPT_MODE, chavePrivada);
  }

  private static byte[] executar(byte[] mensagem, int cypherMode, Key chave) {
    try {
      Cipher cifraRSA = getCipher();
      cifraRSA.init(cypherMode, chave);

      return cifraRSA.doFinal(mensagem);
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  public static KeyPair gerarChaves() {
    try {
      SecureRandom secureRandom = new SecureRandom();
      KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");

      keyPairGenerator.initialize(2048, secureRandom);

      return keyPairGenerator.generateKeyPair();
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  private static Cipher getCipher() throws Exception {
    return Cipher.getInstance("RSA");
  }

}
