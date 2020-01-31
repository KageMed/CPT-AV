import java.io.ObjectOutputStream;
import java.net.Socket;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class P1 extends  java.rmi.server.UnicastRemoteObject implements InterfaceRMIP1 {

    String address = "127.0.0.1";
    static int port = 1098;

    public P1() throws RemoteException {
        System.out.println("Server Address :" + address +" Port " +port);
    }

    @Override
    public void receiveMessage(String x) throws RemoteException {
        System.out.println(" >>>>  Invoked Methode : "+ x);
    }



    private static int NUM_PORT = 8069;

    public static void main(String[] args) {
        // TODO Auto-generated method stub


        try {

            P1 serveur = new P1();
            System.out.println("Hi server RMI P1 is on :) ");
            Registry registry = LocateRegistry.createRegistry(port);
            System.out.println("Created RMI registry in port " + port);
            registry.bind("rmiServer",serveur);
            Socket client = new Socket("localhost", NUM_PORT + 1);
            System.out.println("Connected to localhost in port " + (NUM_PORT + 1));
            ObjectOutputStream out = new ObjectOutputStream(client.getOutputStream());
            Scanner e = new Scanner(System.in);
            //4
            while ( true ) {
                System.out.println("Insert N ");
                int message = e.nextInt();
                out.writeObject(message);
            }
            //5
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }


}
