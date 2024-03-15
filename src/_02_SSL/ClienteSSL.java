package _02_SSL;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ClienteSSL {
    public static void main(String[] args) throws IOException {
        System.setProperty("javax.net.ssl.trustStore", "C:\\Users\\Neii\\IdeaProjects\\CriptografiaTeoria\\CertificadoServ.cer");
        System.setProperty("javax.net.ssl.trustStorePassword", "890123");

        SSLSocketFactory factory = (SSLSocketFactory) SSLSocketFactory.getDefault();

        SSLSocket conexion = (SSLSocket) factory.createSocket("localhost",123);

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
        System.out.println(bufferedReader.readLine());
    }
}
