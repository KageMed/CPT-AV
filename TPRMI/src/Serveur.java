import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Serveur extends  java.rmi.server.UnicastRemoteObject implements InterfaceRMI{

    String address = "127.0.0.1";
    static int port = 1099;

    public Serveur() throws RemoteException{
        System.out.println("Server Address :" + address +" Port " +port);
    }

    @Override
    public void receiveMessage(String x) throws RemoteException {
        System.out.println("Invoiked Methode : "+ x);
    }

    @Override
    public int calcul(int a, int b) throws RemoteException {
        int somme = a + b;
        System.out.println("Invoked Methode calcul :" +somme);
        return  somme;
    }

    public static void main(String[] args) {

        try {
            Serveur serveur = new Serveur();
            System.out.println("Hi server is on :) ");
            Registry registry = LocateRegistry.createRegistry(port);
            System.out.println("Created RMI registry in port " + port);
            registry.bind("rmiServer",serveur);
        }catch ( Exception e){
            System.out.println(e.toString()); System.exit(1);
        }

    }
}
