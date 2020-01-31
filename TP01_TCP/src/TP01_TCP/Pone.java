package TP01_TCP;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Pone {
	private static int NUM_PORT = 8069;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 try {
	            Socket client = new Socket("localhost", NUM_PORT + 1);
	            System.out.println("Connected to localhost in port " + (NUM_PORT + 1));

	            ObjectOutputStream out = new ObjectOutputStream(client.getOutputStream());
	            

	            //4
	            Scanner e = new Scanner(System.in);
	            System.out.println("Insert A ");  
	            int message = e.nextInt();
	            out.writeObject(message);
	            ServerSocket serverSocket = new ServerSocket(NUM_PORT);
	            System.out.println("Waiting for connection P3");  
	            Socket waiting = serverSocket.accept();
	            ObjectInputStream in = new ObjectInputStream(waiting.getInputStream());
	            message = (int) in.readObject();
	            System.out.println("P3 > " + message);
	            message = (int) in.readObject();
	            System.out.println("P3 > " + message);

	            //5
	            in.close();
	            out.close();
	            client.close();
	        } catch (IOException | ClassNotFoundException e) {
	            e.printStackTrace();
	        }
	}

}
