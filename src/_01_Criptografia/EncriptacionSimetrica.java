package _01_Criptografia;

import javax.crypto.*;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class EncriptacionSimetrica {
    public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, InvalidKeyException {
        SecretKey secretKey = generarClave();
        String saludo = "Hola Mundo";

        String stringCodificado = devolverEncriptado(saludo, secretKey);
        System.out.println(stringCodificado);
        String stringDescodificado = desencriptar(stringCodificado, secretKey);
        System.out.println(stringDescodificado);
    }

    private static SecretKey generarClave() throws NoSuchAlgorithmException {
        KeyGenerator generadorClave = KeyGenerator.getInstance("AES");

        generadorClave.init(256);

        return generadorClave.generateKey();
    }

    private static String devolverEncriptado(String dato, SecretKey secretKey) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        // Objeto de cifrado
        Cipher cifrado = Cipher.getInstance("AES");
        // Inicializar objeto
        cifrado.init(Cipher.ENCRYPT_MODE, secretKey);

        byte[] bytesEncriptados = cifrado.doFinal(dato.getBytes());

        return Base64.getEncoder().encodeToString(bytesEncriptados);
    }

    private static String desencriptar(String datoEncriptado, SecretKey secretKey) throws NoSuchPaddingException, NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException, InvalidKeyException {
        Cipher cifrado = Cipher.getInstance("AES");

        cifrado.init(Cipher.DECRYPT_MODE, secretKey);

        byte[] bytesDesencriptados = cifrado.doFinal(Base64.getDecoder().decode(datoEncriptado));

        return new String(bytesDesencriptados);
    }
}
