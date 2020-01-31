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
                System.out.println(" RECEIVED : " + sentence +" - From Address : " + IPAdress +  " PORT : " + port);
                int m = parseInt(sentence.trim());
                receivePacket = new DatagramPacket(recieveData, recieveData.length);
                serverSoket.receive(receivePacket);
                sentence = new String(receivePacket.getData());
                IPAdress = receivePacket.getAddress();
                port = receivePacket.getPort();
                System.out.println(" RECEIVED : " + sentence +" - From Address : " + IPAdress +  " PORT : " + port);
                int message = parseInt(sentence.trim());
                boolean amical = amical(m,message);
                if (amical){
                    System.out.println("Amicaux");
                }else{
                    System.out.println("Non Amicaux");
                }
                rmiServer.receiveMessage("" + message +" " + m);
                int x = rmiServer.produit(m,message);
                rmiServer.sendMessage(m,message,amical);
            }

        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

     static boolean amical(int nb1, int nb2){
        int somme = sommeDiviseur(nb1);
        return (nb1 + nb2 == somme &&
                sommeDiviseur(nb2) == somme);
    }

     static int sommeDiviseur(int nb1){
        int somme = 0;
        for (int i = 1; i <= nb1; ++i){
            if ((nb1 % i) == 0){
                somme += i;
            }
        }
        return somme;
    }

}
