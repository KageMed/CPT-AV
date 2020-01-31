import java.rmi.Remote;
import java.rmi.RemoteException;

public interface InterfaceRMIP2 extends Remote {

    void receiveMessage(String x) throws RemoteException;
	
	
}
