package TP01_TCP;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Pthree {
	private static int NUM_PORT = 8071;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
            
            //4

            
            ServerSocket serverSocket = new ServerSocket(NUM_PORT);
            System.out.println("Waiting for connection P2");  
            Socket waiting = serverSocket.accept();
            ObjectInputStream in = new ObjectInputStream(waiting.getInputStream());
            int A,B;
            A = (int) in.readObject();
            System.out.println("P2 > " + A);
            
            B = (int) in.readObject();
            System.out.println("P2 > " + B);  
            
            //5
            Socket client = new Socket("localhost", NUM_PORT - 2);
            System.out.println("Connected to localhost in port " + (NUM_PORT - 2));

            ObjectOutputStream out = new ObjectOutputStream(client.getOutputStream());
            out.writeObject(A + B);
            int produit = 1;
            for (int i = 1;i<=A+B;i++)
            {
            	
            	if (isPrime(i)) { produit = produit * i; }
            	
            }
            out.writeObject(produit);
            
            in.close();
            out.close();
            client.close();
            serverSocket.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
	}
	
	static boolean isPrime(int n) {
	    for(int i=2;i<n;i++) {
	        if(n%i==0)
	            return false;
	    }
	    return true;
	}
	

}
