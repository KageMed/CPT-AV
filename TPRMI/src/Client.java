import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {

    public static void main(String[] args) {
        InterfaceRMI rmiServer;
        Registry registry;
        String address = "127.0.0.1";
        String port = "1099";
        String text = "HelloWorldFromTheOtherSide";
        System.out.println("Sending from Client : "+ text + "To address :"+ address + " Port " + port);
        try {

            registry = LocateRegistry.getRegistry(address,1099);
            System.out.println("RMI registry found on port "+port);
            rmiServer= (InterfaceRMI) (registry.lookup("rmiServer"));
            rmiServer.receiveMessage(text);
            int x = rmiServer.calcul(10,15);

        }catch (Exception e){
            System.out.println("Exception");
        }

    }
}
