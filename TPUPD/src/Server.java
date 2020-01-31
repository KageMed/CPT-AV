import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Server {

    public static void main(String[] args) {
        try {
            DatagramSocket serverSoket = new DatagramSocket(9876);
            byte[] recieveData = new byte[10];
            byte[] sendData = new byte[10];
            while (true) {
                DatagramPacket receivePacket = new DatagramPacket(recieveData, recieveData.length);
                serverSoket.receive(receivePacket);
                String sentence = new String(receivePacket.getData());
                InetAddress IPAdress = receivePacket.getAddress();
                int port = receivePacket.getPort();
                System.out.println("RECEIVED : " + IPAdress + " - From Address: " + "PORT :" + port);
                String capitalized = sentence.toUpperCase();
                sendData = capitalized.getBytes();
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAdress, port);
                serverSoket.send(sendPacket);
            }
        } catch (Exception e) {
        }

    }

}
