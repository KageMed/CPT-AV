import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.*;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class P2 extends java.rmi.server.UnicastRemoteObject implements InterfaceRMIP2 {

	private static int NUM_PORT = 8070;
    private static ObjectOutputStream outPut = null;
    String address="127.0.0.1";
    static int port=1097;
    
    public P2()throws RemoteException {
        System.out.println("Server Address :"+address+" Port "+port);
    }
    
    public void receiveMessage(String x)throws RemoteException{
        System.out.println(" >>>>  Sending Result to P3 ");
        try {
            outPut.writeObject(x);
        } catch (IOException e) {
            System.out.println(e);
        }
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
            //4
            P2 serveur = new P2();
            System.out.println("Hi server RMI P2 is on :) ");
            Registry registry2 = LocateRegistry.createRegistry(port);
            System.out.println("Created RMI registry in port " + port);
            registry2.bind("rmiServer",serveur);
            Socket client = new Socket("localhost", 8079);
            System.out.println("Connected to localhost in port " + (NUM_PORT - 1));
            ObjectOutputStream out = new ObjectOutputStream(client.getOutputStream());
            outPut = out;
            
        } catch (Exception e) {
            e.printStackTrace();
        }


	}

}
