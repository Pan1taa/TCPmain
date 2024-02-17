import java.io.*;
import java.net.*;
import java.util.*;

public class ThreadServidor extends Thread {
    private Socket clientSocket;

    public ThreadServidor(Socket socket) {
        this.clientSocket = socket;
    }

    public void run() {
        try {
            ObjectInputStream inFromClient = new ObjectInputStream(clientSocket.getInputStream());
            ObjectOutputStream outToClient = new ObjectOutputStream(clientSocket.getOutputStream());

            Llista receivedList = (Llista) inFromClient.readObject();
            List<Integer> sortedList = new ArrayList<>(new TreeSet<>(receivedList.getNumberList()));
            outToClient.writeObject(new Llista(receivedList.getNom(), sortedList));

            clientSocket.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
