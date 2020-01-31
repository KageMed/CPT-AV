import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class P1 {

    private static int NUM_PORT = 8069;

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        try {
            Socket client = new Socket("localhost", NUM_PORT + 1);
            System.out.println("Connected to localhost in port " + (NUM_PORT + 1));
            ObjectOutputStream out = new ObjectOutputStream(client.getOutputStream());
            ServerSocket serverSocket = new ServerSocket(NUM_PORT);
            System.out.println("Waiting for connection P3");
            Socket waiting = serverSocket.accept();
            ObjectInputStream in = new ObjectInputStream(waiting.getInputStream());
            int b = 0;
            System.out.println("Waiting for connection TP0");
            Socket waitingOut = serverSocket.accept();
            ObjectInputStream inOut = new ObjectInputStream(waitingOut.getInputStream());
            //4
            while ( true ) {
                Scanner e = new Scanner(System.in);
                System.out.println("waiting for A : ");
                int message = (int) inOut.readObject();
                out.writeObject(message);
                message = (int) in.readObject();
                System.out.println("P3 > " + message);
                b = message;
                message = (int) in.readObject();
                System.out.println("P3 > " + message);

            }
            //5
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
