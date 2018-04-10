import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;

public class CipherSuitesInfoGenerator {

  public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchPaddingException {

    SSLContext context = SSLContext.getDefault();
    SSLSocketFactory sf = context.getSocketFactory();
    String[] cipherSuites = sf.getSupportedCipherSuites();

    String cipherName = "TLS_SSL_RSA_WITH_AES_256_CBC_SHA";
    System.out.println(Arrays.toString(cipherSuites));
    for (String s : cipherSuites) {
      if (s.equals(cipherName)) {
        System.out.println(cipherName + " is supported");

        try {
          Cipher cipher = Cipher.getInstance(cipherName);
          System.out.println(cipher.getAlgorithm());
        } catch (Exception e) {
          System.out.println(e.getMessage());
        }

        break;
      }

    }
  }
}
