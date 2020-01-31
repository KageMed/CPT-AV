
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.*;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class P1 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		InterfaceRMIP2 rmiServer;

        Registry registry;
        String address = "127.0.0.1";
        String rmiPort = "1097";
        String text = " HelloWorldFromTheOtherSide ";
        System.out.println("Sending from Client : " + text + " To address : " + address + " Port " + rmiPort);
        registry = LocateRegistry.getRegistry(address,1097);
        System.out.println("RMI registry found on port " + rmiPort);
        rmiServer= (InterfaceRMIP2) (registry.lookup("rmiServer"));
        Scanner e = new Scanner(System.in);
		while ( true ) {

            System.out.println("Choose : ");
            System.out.println("1 - Insertion");
            System.out.println("2 -  delete");
            System.out.println("3 -  show list");
            int choix = e.nextInt();
            rmiServer.receiveMessage("" + choix);
            switch (choix){
                case 1:{
                System.out.print("Insert Mat :");
                int mat = e.nextInt();
                e.nextLine();
                System.out.print("Insert LastName :");
                String lastName = e.nextLine();
                System.out.print("Insert FirstName :");
                String fristName = e.nextLine();
                rmiServer.receiveMessage("" + mat);
                rmiServer.receiveMessage(lastName);
                rmiServer.receiveMessage(fristName);
                break;
                }
                case 2:{
                    System.out.print("Insert Mat :");
                    int mat = e.nextInt();
                    rmiServer.receiveMessage("" + mat);
                    break;
                }
                case 3:{
                    break;
                }
            }}


}
	
}
