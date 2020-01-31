import java.rmi.Remote;
import java.rmi.RemoteException;

public interface InterfaceRMI extends Remote {

    void receiveMessage(String x) throws RemoteException;
    int calcul(int a, int b) throws RemoteException;
    int produit(int a, int b) throws RemoteException;

    void sendMessage(int a , int b , boolean amicaux) throws RemoteException;

}
