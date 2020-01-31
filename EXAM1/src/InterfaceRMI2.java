import java.rmi.Remote;
import java.rmi.RemoteException;

public interface InterfaceRMI2 extends Remote {
    void insert(int mat ,String firstName ,String lastName) throws RemoteException;
    void delete(int mat) throws RemoteException;
    void show() throws RemoteException;
}
