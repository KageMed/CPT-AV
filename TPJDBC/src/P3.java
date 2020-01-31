import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.sql.*;

class P3 extends  java.rmi.server.UnicastRemoteObject implements InterfaceRMIP4 {

    String address = "127.0.0.1";
    static int port = 1098;
    static InterfaceRMI rmiServerP2Static = null;

    public P3() throws RemoteException {
        System.out.println("Server Address :" + address +" Port " +port);
    }

    private static Statement statement = null;


    public static void main(String args[]) {
        try {
            P3 serveur = new P3();
            System.out.println("Hi server RMI P3 is on :) ");
            Registry registry = LocateRegistry.createRegistry(port);
            System.out.println("Created RMI registry in port " + port);
            registry.bind("rmiServer",serveur);

            InterfaceRMI rmiServerP2;
            Registry registryP2;
            String address = "127.0.0.1";
            String rmiPort = "1097";
            String text = " HelloWorldFromTheOtherSide ";
            System.out.println("Sending from Client : " + text + " To address : " + address + " Port " + rmiPort);
            registryP2 = LocateRegistry.getRegistry(address,1097);
            System.out.println("RMI registry found on port " + rmiPort);
            rmiServerP2= (InterfaceRMI) (registryP2.lookup("rmiServer"));
            rmiServerP2Static = rmiServerP2;
            //step1 load the driver class
            Class.forName("oracle.jdbc.driver.OracleDriver");

            //step2 create  the connection object
            Connection con = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:orcl", "system", "ADMIn150865");

            //step3 create the statement object
            Statement stmt = con.createStatement();
            statement = stmt;

            //step4 execute query
            //ResultSet rs = stmt.executeQuery("select * from BANQUE");

           // while (rs.next())
           //     System.out.println(rs.getInt(1) + "  " + rs.getString(2) );

            //step5 close the connection object
            //con.close();
            while (true);

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    @Override
    public void insert(int mat, String firstName, String lastName) throws RemoteException {
        try {
            boolean rs = statement.execute("insert into etudiant values (" + mat +",'"+firstName+"'" +",'"+lastName+"')");
            rmiServerP2Static.receiveMessage("ROW INSERTED");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int mat) throws RemoteException {
        try {
            boolean rs = statement.execute("delete from etudiant where mat = " + mat);
            rmiServerP2Static.receiveMessage("ROW DELETED");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void show() throws RemoteException {

        try {
            ResultSet rs = statement.executeQuery("select * from etudiant");
            String messsage = "";
            while (rs.next())
                messsage = messsage + "\n" +rs.getInt(1) + "  " + rs.getString(2)+ "  " + rs.getString(3) ;
            rmiServerP2Static.receiveMessage(messsage);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}