package UDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Pone {

	private static int NUM_PORT = 9867;	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
		DatagramSocket serverSoket = new DatagramSocket();
		byte[] recieveData = new byte[10];
		byte[] sendData = new byte[10];
		while (true) {
			
			DatagramPacket receivePacket = new DatagramPacket(recieveData, recieveData.length);
			serverSoket.receive(receivePacket);
			String sentence = new String(receivePacket.getData());
			InetAddress IPAdress = receivePacket.getAddress();
			int port = receivePacket.getPort();
			System.out.println("RECEIVED : "+ IPAdress + " - From Adress: " + "PORT :" + port);
			String capitalized = sentence.toUpperCase();
			sendData = capitalized.getBytes();
			DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length,IPAdress , port);
			serverSoket.send(sendPacket);
		}
		}catch(Exception e) {}
			
		
		
	}

}
