import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class P4 extends  java.rmi.server.UnicastRemoteObject implements InterfaceRMI {

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

    @Override
    public void sendMessage(int a , int b , boolean amicaux) throws RemoteException{
    try {
        String x = "";
        InterfaceRMIP1 rmiServer;
        Registry registry;
        String address = "127.0.0.1";
        String rmiPort = "1098";
        String text = " HelloWorldFromTheOtherSide ";
        System.out.println("Sending from Client : " + text + " To address : " + address + " Port " + rmiPort);
        registry = LocateRegistry.getRegistry(address,1098);
        System.out.println("RMI registry found on port " + rmiPort);
        rmiServer= (InterfaceRMIP1) (registry.lookup("rmiServer"));
        System.out.println("Sending Message :" + x + " TO P1");

        rmiServer.receiveMessage("Entier : "+ a + " " + b + (amicaux?" sont " :"Ne sont pas" ) + " amicaux");

        for (int i = 0;i < a + b ; i++){
            if (i> 100 && i < 999){
                if ( Math.pow(i%10,3) + Math.pow( (i/10)%10,3) + Math.pow( (i/100)%10,3) == i )
                    rmiServer.receiveMessage("Entier Cubuque : " + i);
            }
        }
    }
    catch (Exception e){

        System.out.println(e.toString());
    }
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
