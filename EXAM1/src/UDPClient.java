import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UDPClient {

    private DatagramSocket clientSocket;
    private InetAddress IPadress;
    private byte[] sendData;
    private int port ;

    public UDPClient(int port) {

        try {
            this.clientSocket = new DatagramSocket();
            this.IPadress = InetAddress.getByName("localhost");
            this.sendData = new byte[10];
            this.port = port;
        } catch (Exception e) {
            System.out.println(e.toString());
        }

    }

    public void sendData(String sentence) {
        try {
            char[] chars = sentence.toCharArray();
            this.sendData = new byte[10];
            this.sendData = ("" + chars.length ).getBytes();
            DatagramPacket sendPacket = new DatagramPacket(this.sendData, this.sendData.length,IPadress,this.port);
            this.clientSocket.send(sendPacket);
            for (int i = 0; i < chars.length; i++) {
                this.sendData = new byte[10];
                this.sendData = ("" + chars[i] ).getBytes();
                sendPacket = new DatagramPacket(this.sendData, this.sendData.length,IPadress,this.port);
                this.clientSocket.send(sendPacket);
                this.sendData = null;
            }

        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
