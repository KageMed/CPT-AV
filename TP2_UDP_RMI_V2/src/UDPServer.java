import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import static java.lang.Integer.parseInt;

public class UDPServer {

    public static void main(String[] args) {

        try {

            String message = "Hello From the other side";
            int i = 0;
            byte[] messageByte = message.getBytes();
            for (i = 0; i<messageByte.length;i++) {
               // System.out.print(new String(messageByte[i])));
            }

            DatagramSocket serverSoket = new DatagramSocket(9876);
            DatagramSocket serverSoket2 = new DatagramSocket(9886);
            byte[] recieveData = new byte[10];
            byte[] sendData = new byte[10];
            DatagramPacket receivePacket = new DatagramPacket(recieveData, recieveData.length);
            serverSoket.receive(receivePacket);
            String sentence = new String(receivePacket.getData());
            InetAddress IPAdress = receivePacket.getAddress();
            int port = receivePacket.getPort();
            System.out.println(" RECEIVED : " + sentence.trim() +" - From Address : " + IPAdress +  " PORT : " + port);
            int m = parseInt( sentence.trim());
            for (int j = 0; j < m ; j++) {
                receivePacket = new DatagramPacket(recieveData, recieveData.length);
                serverSoket.receive(receivePacket);
                sentence = new String(receivePacket.getData());
                System.out.print(new String(receivePacket.getData()).trim().charAt(0));
            }


        }catch (Exception E){}

    }

}
