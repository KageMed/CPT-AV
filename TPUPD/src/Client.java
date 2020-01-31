import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {
        try {
            DatagramSocket clientSocket = new DatagramSocket();
            InetAddress IPadress = InetAddress.getByName("localhost");
            byte[] recieveData = new byte[10];
            byte[] sendData = new byte[10];
            System.out.println("Sentence :");
            Scanner e = new Scanner(System.in);
            String sentence = e.next();
            sendData = sentence.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length,IPadress,9876);
            clientSocket.send(sendPacket);
            DatagramPacket receivePacket = new DatagramPacket(recieveData, recieveData.length);
            clientSocket.receive(receivePacket);
            String modifiedString = new String(receivePacket.getData());
            System.out.println("ORGINIAL Sentence :"+ sentence);
            System.out.print("from server: " + receivePacket.getAddress() + " PORT " + receivePacket.getPort() );
            System.out.print(" After modifications: "+ modifiedString );
            clientSocket.close();
        }catch(Exception e) {}

    }

}
