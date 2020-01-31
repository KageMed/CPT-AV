import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

import static java.lang.Integer.parseInt;

public class UDP {

    private DatagramSocket serverSoket;
    private byte[] recieveData;
    private int port;

    public UDP(int port) {

        try {
            this.serverSoket = new DatagramSocket(port);
            this.recieveData = new byte[10];
            this.port = port;
        } catch (Exception e) {
            System.out.println(e.toString());
        }

    }

    public String getRecieveData() {
        try {
            DatagramPacket receivePacket = new DatagramPacket(this.recieveData, this.recieveData.length);
            this.recieveData = new byte[10];
            this.serverSoket.receive(receivePacket);
            String sentence = new String(receivePacket.getData());
            InetAddress IPAdress = receivePacket.getAddress();
            int port = receivePacket.getPort();
            System.out.println(" SIZE : " + sentence.trim() +" - From Address : " + IPAdress +  " PORT : " + port);
            int m = parseInt( sentence.trim());
            String message = "";
            for (int j = 0; j < m ; j++) {
                receivePacket = new DatagramPacket(this.recieveData, this.recieveData.length);
                this.recieveData = new byte[10];
                this.serverSoket.receive(receivePacket);
                message = message + new String(receivePacket.getData()).charAt(0);
            }
            //System.out.println("m : " + message);
            return message;
        } catch (Exception e) {
            System.out.println(e.toString());
            return "erreur";
        }
    }
}
