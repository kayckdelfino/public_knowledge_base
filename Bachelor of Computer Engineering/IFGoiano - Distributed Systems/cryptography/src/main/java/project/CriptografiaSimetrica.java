package project;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class CriptografiaSimetrica {

  public static SecretKey gerarChave() {
    try {
      KeyGenerator keyGenerator = KeyGenerator.getInstance("DES");
      return keyGenerator.generateKey();
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  public static byte[] cifrar(byte[] mensagem, SecretKey chave) {
    return executar(mensagem, Cipher.ENCRYPT_MODE, chave);
  }

  public static byte[] decifrar(byte[] mensagem, SecretKey chave) {
    return executar(mensagem, Cipher.DECRYPT_MODE, chave);
  }

  private static byte[] executar(byte[] mensagem, int cypherMode, SecretKey chave) {
    try {
      Cipher cifraDES = getCipher();
      cifraDES.init(cypherMode, chave);

      return cifraDES.doFinal(mensagem);
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  private static Cipher getCipher() throws Exception {
    return Cipher.getInstance("DES/ECB/PKCS5Padding");
  }
}
