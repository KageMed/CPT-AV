import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class P2 {

    private static int NUM_PORT = 8070;
    public static void main(String[] args) {
        // TODO Auto-generated method stub

        try {
            //4
            Scanner e = new Scanner(System.in);
            ServerSocket serverSocket = new ServerSocket(NUM_PORT);
            System.out.println("Waiting for connection P1");
            Socket waiting = serverSocket.accept();
            ObjectInputStream in = new ObjectInputStream(waiting.getInputStream());
            Socket client = new Socket("localhost", NUM_PORT + 1);
            System.out.println("Connected to localhost in port " + (NUM_PORT + 1));
            ObjectOutputStream out = new ObjectOutputStream(client.getOutputStream());

            System.out.println("Waiting for connection TP0");
            Socket waitingOut = serverSocket.accept();
            ObjectInputStream inOut = new ObjectInputStream(waitingOut.getInputStream());

            while (true){
                int message = (int) in.readObject();
                System.out.println("P1 > " + message);
                System.out.println("Waiting FOR  B ");
                int message2 = (int) inOut.readObject();
                out.writeObject(message);
                out.writeObject(message2);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

}

