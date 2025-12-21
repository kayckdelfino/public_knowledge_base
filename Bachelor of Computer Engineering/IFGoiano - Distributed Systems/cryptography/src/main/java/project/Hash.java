package project;

import java.security.MessageDigest;
import java.util.Formatter;

public class Hash {
  public static String executarSha1(byte[] textoPlano) {
    try {
      MessageDigest sha1 = MessageDigest.getInstance("SHA-1");

      sha1.reset();
      sha1.update(textoPlano);

      Formatter formatter = new Formatter();
      for (byte b : sha1.digest()) {
        formatter.format("%02x", b);
      }

      String hash = formatter.toString();
      formatter.close();

      return hash;
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

}
