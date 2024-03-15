package _01_Criptografia;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.*;
import java.util.Base64;

public class EncripatcionAsimetrica {
    public static void main(String[] args) throws NoSuchAlgorithmException, IllegalBlockSizeException, NoSuchPaddingException, BadPaddingException, InvalidKeyException {
        String saludo = "Hola";
        KeyPair keyPair = generarClave();
        PublicKey clavePublica = keyPair.getPublic();
        PrivateKey clavePrivada = keyPair.getPrivate();
        String codificado = stringEncriptado(saludo, clavePublica);
        System.out.println(codificado);
        String descodificado = desencriptar(codificado, clavePrivada);
        System.out.println(descodificado);
    }

    private static KeyPair generarClave() throws NoSuchAlgorithmException {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(2048);

        return keyPairGenerator.generateKeyPair();
    }

    private static String stringEncriptado(String dato, PublicKey clavePublica) throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException, NoSuchPaddingException, NoSuchAlgorithmException {
        Cipher cifrado = Cipher.getInstance("RSA");
        cifrado.init(Cipher.ENCRYPT_MODE, clavePublica);

        byte[] encriptado = cifrado.doFinal(dato.getBytes());

        return Base64.getEncoder().encodeToString(encriptado);
    }

    private static String desencriptar(String datoEncriptado, PrivateKey privateKey) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        Cipher cifrado = Cipher.getInstance("RSA");
        cifrado.init(Cipher.DECRYPT_MODE, privateKey);

        byte[] desencriptado = cifrado.doFinal(Base64.getDecoder().decode(datoEncriptado));

        return new String(desencriptado);
    }

}
