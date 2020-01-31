import java.rmi.Remote;
import java.rmi.RemoteException;

public interface InterfaceRMI3 extends Remote {
    void insert(int mat ,int mat2) throws RemoteException;
    void insert2(int mat ,int mat2) throws RemoteException;
    void delete(int mat) throws RemoteException;
    void show() throws RemoteException;



}
