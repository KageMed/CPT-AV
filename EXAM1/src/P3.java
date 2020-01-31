import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.sql.ResultSet;
import java.sql.SQLException;

public class P3 extends java.rmi.server.UnicastRemoteObject implements InterfaceRMI3{

    public P3()throws RemoteException {
        System.out.println("Server Address :"+address+" Port "+numPortRMI);
    }

    public static int numPortSocket = 2502;
    public static int numPortRMI = 3502;
    public static int numPortUDP = 4502;
    public static String address="127.0.0.1";
    public static JDBC jdbc ;
    public static int m;
    public static int s;

    public static void main(String[] args) {
        try {

            RMIServer();
            jdbc = new JDBC();
            ObjectInputStream in =  SocketServer();
            int mat = (int) in.readObject();
            int mat2 = (int) in.readObject();
            insert3(mat , mat2);
            insert3(mat*2 , mat2*2);
            insert3(mat + m  , mat2 + s);

        }catch (Exception e){
            System.out.println(e);
        }


    }

//    *********** SOCKET *****************

    public static ObjectInputStream SocketServer (){

        try {

            ServerSocket serverSocket = new ServerSocket(numPortSocket);
            System.out.println("Waiting for connection P2");
            Socket waiting = serverSocket.accept();
            ObjectInputStream in = new ObjectInputStream(waiting.getInputStream());
            return in ;

        }catch (Exception e){
            System.out.println("Erreur == > " + e.toString());
            return null;
        }

    }
    public static ObjectOutputStream SocketClient (){
        try {

            Socket client = new Socket("localhost", numPortSocket);
            System.out.println("Connected to localhost in port " + (numPortSocket ));
            ObjectOutputStream out = new ObjectOutputStream(client.getOutputStream());
            return out;
        }catch (Exception e){
            System.out.println("Erreur == > " + e.toString());
            return null;
        }
    }
    public static ObjectOutputStream SocketClientP2 (){
        try {

            Socket client = new Socket("localhost", P2.numPortSocket);
            System.out.println("Connected to localhost in port " + (P2.numPortSocket ));
            ObjectOutputStream out = new ObjectOutputStream(client.getOutputStream());
            return out;
        }catch (Exception e){
            System.out.println("Erreur == > " + e.toString());
            return null;
        }
    }
    public static ObjectOutputStream SocketClientP3 (){
        try {

            Socket client = new Socket("localhost", P3.numPortSocket);
            System.out.println("Connected to localhost in port " + (P3.numPortSocket ));
            ObjectOutputStream out = new ObjectOutputStream(client.getOutputStream());
            return out;
        }catch (Exception e){
            System.out.println("Erreur == > " + e.toString());
            return null;
        }
    }
    public static ObjectOutputStream SocketClientP4 (){
        try {

            Socket client = new Socket("localhost", P4.numPortSocket);
            System.out.println("Connected to localhost in port " + (P4.numPortSocket ));
            ObjectOutputStream out = new ObjectOutputStream(client.getOutputStream());
            return out;
        }catch (Exception e){
            System.out.println("Erreur == > " + e.toString());
            return null;
        }
    }


    //    *********** RMI **********

    public static void RMIServer (){
        try {

            P3 serveur = new P3();
            System.out.println("Hi server RMI P2 is on :) ");
            Registry registry2 = LocateRegistry.createRegistry(numPortRMI);
            System.out.println("Created RMI registry in port " + numPortRMI);
            registry2.bind("rmiServer",  serveur);

        }catch (Exception e){
            System.out.println("Erreur == > " + e.toString());
        }
    }
    public static InterfaceRMI RMIClient (){
        try {

            InterfaceRMI rmiServer;
            Registry registry;
            String address = "127.0.0.1";
            String rmiPort = P1.numPortRMI + "";
            String text = " HelloWorldFromTheOtherSide ";
            System.out.println("Sending from Client : " + text + " To address : " + address + " Port " + rmiPort);
            registry = LocateRegistry.getRegistry(address,P1.numPortRMI);
            System.out.println("RMI registry found on port " + rmiPort);
            rmiServer= (InterfaceRMI) (registry.lookup("rmiServer"));
            return  rmiServer;

        }catch (Exception e){
            System.out.println("Erreur == > " + e.toString());
            return null;
        }
    }
    public static InterfaceRMI2 RMIClient2 (){
        try {

            InterfaceRMI2 rmiServer;
            Registry registry;
            String address = "127.0.0.1";
            String rmiPort = P2.numPortRMI + "";
            String text = " HelloWorldFromTheOtherSide ";
            System.out.println("Sending from Client : " + text + " To address : " + address + " Port " + rmiPort);
            registry = LocateRegistry.getRegistry(address,P2.numPortRMI );
            System.out.println("RMI registry found on port " + rmiPort);
            rmiServer= (InterfaceRMI2) (registry.lookup("rmiServer"));
            return  rmiServer;

        }catch (Exception e){
            System.out.println("Erreur == > " + e.toString());
            return null;
        }
    }
    public static InterfaceRMI3 RMIClient3 (){
        try {

            InterfaceRMI3 rmiServer;
            Registry registry;
            String address = "127.0.0.1";
            String rmiPort = P3.numPortRMI + "";
            String text = " HelloWorldFromTheOtherSide ";
            System.out.println("Sending from Client : " + text + " To address : " + address + " Port " + rmiPort);
            registry = LocateRegistry.getRegistry(address,P3.numPortRMI);
            System.out.println("RMI registry found on port " + rmiPort);
            rmiServer= (InterfaceRMI3) (registry.lookup("rmiServer"));
            return  rmiServer;

        }catch (Exception e){
            System.out.println("Erreur == > " + e.toString());
            return null;
        }
    }
    public static InterfaceRMI4 RMIClient4 (){
        try {

            InterfaceRMI4 rmiServer;
            Registry registry;
            String address = "127.0.0.1";
            String rmiPort = P4.numPortRMI + "";
            String text = " HelloWorldFromTheOtherSide ";
            System.out.println("Sending from Client : " + text + " To address : " + address + " Port " + rmiPort);
            registry = LocateRegistry.getRegistry(address,P4.numPortRMI);
            System.out.println("RMI registry found on port " + rmiPort);
            rmiServer= (InterfaceRMI4) (registry.lookup("rmiServer"));
            return  rmiServer;

        }catch (Exception e){
            System.out.println("Erreur == > " + e.toString());
            return null;
        }
    }

    @Override
    public void show() throws RemoteException {


        try {
            System.out.println("show");
            UDPClient udpClient = new UDPClient(P1.numPortUDP);

            String message = jdbc.show();
            udpClient.sendData("Show From P3 " + message);

        } catch (Exception e) {
            System.out.println(e);;
        }


    }

    @Override
    public void delete(int mat) throws RemoteException {
        try {
            System.out.println("show");
            UDPClient udpClient = new UDPClient(P1.numPortUDP);
            jdbc.delete(mat);
            udpClient.sendData("delete From P3 ");

        } catch (Exception e) {
            System.out.println(e);;
        }
    }

    @Override
    public void insert(int mat,int mat2) throws RemoteException {
        try {
            System.out.println("insert");
            jdbc.insert(mat,mat2);
            m = mat;
            s = mat2;

        } catch (Exception e) {
            System.out.println(e);;
        }
    }

    @Override
    public void insert2(int mat,int mat2) throws RemoteException {
        try {
            System.out.println("insert");
            jdbc.insert(mat,mat2);

        } catch (Exception e) {
            System.out.println(e);;
        }
    }

    public static void insert3(int mat,int mat2) throws RemoteException {
        try {
            System.out.println("insert");
            jdbc.insert(mat,mat2);

        } catch (Exception e) {
            System.out.println(e);;
        }
    }


}
