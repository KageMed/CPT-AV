import java.rmi.Remote;
import java.rmi.RemoteException;

public interface InterfaceRMI extends Remote {

    void receiveMessage(String x) throws RemoteException;
    int calcul(int a, int b) throws RemoteException;

}
