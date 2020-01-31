import java.rmi.Remote;
import java.rmi.RemoteException;

public interface InterfaceRMIP1 extends Remote {

    public void receiveMessage(String x) throws RemoteException;

}
