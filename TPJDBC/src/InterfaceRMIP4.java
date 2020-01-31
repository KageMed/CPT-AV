import javax.naming.Context;
import javax.naming.InitialContext;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Properties;

public interface InterfaceRMIP4 extends Remote {

    void insert(int mat ,String firstName ,String lastName) throws RemoteException;
    void delete(int mat) throws RemoteException;
    void show() throws RemoteException;

}
