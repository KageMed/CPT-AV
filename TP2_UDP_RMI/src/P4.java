import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class P4 extends  java.rmi.server.UnicastRemoteObject implements InterfaceRMI{

    String address = "127.0.0.1";
    static int port = 1099;

    public P4() throws RemoteException{
        System.out.println("Server Address :" + address +" Port " +port);
    }

    @Override
    public void receiveMessage(String x) throws RemoteException {
        System.out.println("Received Message : "+ x);
    }

    @Override
    public int calcul(int a, int b) throws RemoteException {
        int somme = a + b;
        System.out.println("Invoked Methode calcul :" +somme);
        return  somme;
    }

    @Override
    public int produit(int a, int b) throws RemoteException {
        int somme = a * b;
        System.out.println("Invoked Methode Produit :" +somme);
        return  somme;
    }

    public static void main(String[] args) {

        try {
            P4 serveur = new P4();
            System.out.println("Hi server RMI P4 is on :) ");
            Registry registry = LocateRegistry.createRegistry(port);
            System.out.println("Created RMI registry in port " + port);
            registry.bind("rmiServer",serveur);
        }catch ( Exception e){
            System.out.println(e.toString()); System.exit(1);
        }

    }
}
