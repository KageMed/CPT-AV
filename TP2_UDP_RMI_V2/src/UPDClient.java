import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class UPDClient {

    public static void main(String[] args) {
    try{
        Scanner e = new Scanner(System.in);
        DatagramSocket clientSocket = new DatagramSocket();
        InetAddress IPadress = InetAddress.getByName("localhost");
        byte[] recieveData = new byte[10];
        byte[] sendData = new byte[10];
        System.out.println("Insert M : ");
        String sentence =  "= eqsmlcjqscmlqsk cqsk cqso fcqposckjqpdo \n ****** \n fsdpsdklv sd gsdfivjsdlkv sdlv sdv sdlkjvlsdkjv dlfisdj vs.next()";
        System.out.println(sentence);
        char[] chars = sentence.toCharArray();

        sendData = ("" + chars.length ).getBytes();
        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length,IPadress,9876);
        clientSocket.send(sendPacket);

        for (int i = 0; i < chars.length; i++) {
            sendData = ("" + chars[i] ).getBytes();
            sendPacket = new DatagramPacket(sendData, sendData.length,IPadress,9876);
            clientSocket.send(sendPacket);
        }


    }catch (Exception e){}


    }

}
