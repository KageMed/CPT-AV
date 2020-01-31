import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class P3 {

    public static void main(String[] args) {
        try {
            DatagramSocket serverSoket = new DatagramSocket(9876);
            byte[] recieveData = new byte[10];
            byte[] sendData = new byte[10];
            InterfaceRMI rmiServer;
            Registry registry;
            String address = "127.0.0.1";
            String rmiPort = "1099";
            String text = " HelloWorldFromTheOtherSide ";
            System.out.println("Sending from Client : " + text + " To address : " + address + " Port " + rmiPort);
            registry = LocateRegistry.getRegistry(address,1099);
            System.out.println("RMI registry found on port " + rmiPort);
            rmiServer= (InterfaceRMI) (registry.lookup("rmiServer"));
            Scanner e = new Scanner(System.in);

            while (true) {
                DatagramPacket receivePacket = new DatagramPacket(recieveData, recieveData.length);
                serverSoket.receive(receivePacket);
                String sentence = new String(receivePacket.getData());
                InetAddress IPAdress = receivePacket.getAddress();
                int port = receivePacket.getPort();
                System.out.println(" RECEIVED : " + IPAdress + " - From Address : " + " PORT : " + port);
                int m = parseInt(sentence.trim());
                receivePacket = new DatagramPacket(recieveData, recieveData.length);
                serverSoket.receive(receivePacket);
                sentence = new String(receivePacket.getData());
                IPAdress = receivePacket.getAddress();
                port = receivePacket.getPort();
                System.out.println(" RECEIVED : " + IPAdress + " - From Address : " + " PORT : " + port);
                int message = parseInt(sentence.trim());
                rmiServer.receiveMessage("" + message +" " + m);
                int x = rmiServer.produit(m,message);
            }

        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
