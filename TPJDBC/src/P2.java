import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.*;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;



public class P2 extends java.rmi.server.UnicastRemoteObject implements InterfaceRMI{

    String address="127.0.0.1";
    static int port=1097;

    public P2()throws RemoteException {
        System.out.println("Server Address :"+address+" Port "+port);
    }

    @Override
    public void receiveMessage(String x)throws RemoteException{
        System.out.println(" >>>>  Sending Result to P1 ");
        try {
            outPut.writeObject(x);
        } catch (IOException e) {
            System.out.println(e);
        }
    }


    private static int NUM_PORT = 8070;
    private static ObjectOutputStream outPut = null;
    public static void main(String[] args) {
        // TODO Auto-generated method stub

        try {
            //4
            P2 serveur = new P2();
            System.out.println("Hi server RMI P2 is on :) ");
            Registry registry2 = LocateRegistry.createRegistry(port);
            System.out.println("Created RMI registry in port " + port);
            registry2.bind("rmiServer",serveur);
            Scanner e = new Scanner(System.in);
            ServerSocket serverSocket = new ServerSocket(NUM_PORT);
            System.out.println("Waiting for connection P1");
            Socket waiting = serverSocket.accept();
            ObjectInputStream in = new ObjectInputStream(waiting.getInputStream());
            Socket client = new Socket("localhost", NUM_PORT - 1);
            System.out.println("Connected to localhost in port " + (NUM_PORT - 1));
            ObjectOutputStream out = new ObjectOutputStream(client.getOutputStream());
            outPut = out;
            InterfaceRMIP4 rmiServer;

            Registry registry;
            String address = "127.0.0.1";
            String rmiPort = "1098";
            String text = " HelloWorldFromTheOtherSide ";
            System.out.println("Sending from Client : " + text + " To address : " + address + " Port " + rmiPort);
            registry = LocateRegistry.getRegistry(address,1098);
            System.out.println("RMI registry found on port " + rmiPort);
            rmiServer= (InterfaceRMIP4) (registry.lookup("rmiServer"));

            Registry registryP4;
            InterfaceRMIP4 rmiServerP4;
            String rmiPortP4 = "1099";
            System.out.println("Sending from Client : " + text + " To address : " + address + " Port " + rmiPortP4);
            registryP4 = LocateRegistry.getRegistry(address,1099);
            System.out.println("RMI registry found on port " + rmiPort);
            rmiServerP4 = (InterfaceRMIP4) (registryP4.lookup("rmiServer"));

            while (true) {
                int choix = (int) in.readObject();
                switch (choix){
                    case 1: {

                        int mat = (int) in.readObject();
                        String lastName = (String) in.readObject();
                        String firstName = (String) in.readObject();

                        System.out.println("P1 > " + "mat : " + mat + ", lastName : " + lastName + ", lastName : " + firstName);
                        rmiServer.insert(mat,lastName,firstName);
                        rmiServerP4.insert(mat,lastName,firstName);
                        break;
                    }
                    case 2: {

                        int mat = (int) in.readObject();
                        System.out.println("P1 > " + "mat : " + mat );
                        rmiServer.delete(mat);
                        rmiServerP4.delete(mat);
                        break;
                    }
                    case 3: {

                        System.out.println("P1 > Show list " );
                        rmiServer.show();
                        rmiServerP4.show();
                        break;
                    }

                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}