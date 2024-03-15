package _02_SSL;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;
import java.io.IOException;
import java.io.OutputStream;

public class ServidorSSL {
    public static void main(String[] args) throws IOException {

        System.setProperty("javax.net.ssl.keyStore","C:\\Users\\Neii\\IdeaProjects\\CriptografiaTeoria\\AlmacenSrv");
        System.setProperty("javax.net.ssl.keyStorePassword","1234567");

        SSLServerSocketFactory factory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();

        SSLServerSocket serverSocket = (SSLServerSocket) factory.createServerSocket(123);

        SSLSocket cliente = (SSLSocket) serverSocket.accept();


        OutputStream outputStream = cliente.getOutputStream();
        outputStream.write(("Hola\n").getBytes());
        outputStream.flush();

    }
}
