import java.rmi.Remote;
import java.rmi.RemoteException;

public interface InterfaceRMI extends Remote {

    void receiveMessage(String x) throws RemoteException;

}
