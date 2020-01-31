import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.*;
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
            DatagramSocket clientSocket = new DatagramSocket();
            InetAddress IPadress = InetAddress.getByName("localhost");
            byte[] recieveData = new byte[10];
            byte[] sendData = new byte[10];

            while (true){
                int message = (int) in.readObject();
                System.out.println("P1 > " + message);
                System.out.println("Insert M : ");
                String sentence = e.next();
                sendData = sentence.getBytes();
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length,IPadress,9876);
                clientSocket.send(sendPacket);
                sendData = (""+message).getBytes();
                sendPacket = new DatagramPacket(sendData, sendData.length,IPadress,9876);
                clientSocket.send(sendPacket);
                System.out.println("Waiting  P1 Next N ");

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}

