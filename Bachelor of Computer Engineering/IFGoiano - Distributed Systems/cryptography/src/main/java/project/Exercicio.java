// Implemente as funções gerarCertificado(mensagem, secretKey)   ->    sig = SKjoão(H(data))
// e validarMensagem(mensagem, certificado, publicKey)           ->    PKjoão(sig) = H(data)
// • Utilize bibliotecas existentes para os mecanismos de criptografia assimétricas
// • Elabore casos de teste para
// • Pessoa A envia uma mensagem para pessoa B e a mensagem está íntegra
// • Pessoa A envia uma mensagem para pessoa B e a mensagem foi modificada

package project;

import java.security.Key;

public class Exercicio {
    public static byte[] gerarCertificado(byte[] textoPlano, Key chavePrivada) {
        String hash = Hash.executarSha1(textoPlano);

        return CriptografiaAssimetrica.cifrar(hash.getBytes(), chavePrivada);
    }

    public static boolean validarMensagem(byte[] textoPlano, byte[] certificado, Key chavePublica) {
        String hashCertificado = new String(CriptografiaAssimetrica.decifrar(certificado, chavePublica));

        return hashCertificado.equals(Hash.executarSha1(textoPlano));
    }
}
