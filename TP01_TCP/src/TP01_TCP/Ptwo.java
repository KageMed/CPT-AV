package TP01_TCP;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Ptwo {
	private static int NUM_PORT = 8070;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
                        //4

            Scanner e = new Scanner(System.in);
            ServerSocket serverSocket = new ServerSocket(NUM_PORT);
            System.out.println("Waiting for connection P1");
            Socket waiting = serverSocket.accept();
            System.out.println("Insert B "); 
            ObjectInputStream in = new ObjectInputStream(waiting.getInputStream());
            int message = (int) in.readObject();
            
            int message2 = e.nextInt();
            Socket client = new Socket("localhost", NUM_PORT + 1);
            System.out.println("Connected to localhost in port " + (NUM_PORT + 1));

            ObjectOutputStream out = new ObjectOutputStream(client.getOutputStream());

            out.writeObject(message);
            out.writeObject(message2);
            
            
            
            System.out.println("P1 > " + message);
            

            //5
            in.close();
            out.close();
            client.close();
            serverSocket.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
		
	}

}
