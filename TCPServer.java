import java.io.*;
import java.net.*;

public class TCPServer {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(12345); // Puerto del servidor

            while (true) {
                Socket clientSocket = serverSocket.accept();
                new ThreadServidor(clientSocket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
