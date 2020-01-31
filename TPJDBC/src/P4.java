import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.sql.*;

class P4 extends java.rmi.server.UnicastRemoteObject implements InterfaceRMIP4{

        String address="127.0.0.1";
        static int port=1099;

        public P4()throws RemoteException {
        System.out.println("Server Address :"+address+" Port "+port);
        }


    private static InterfaceRMI rmiServerP2Static = null;
    private static Statement statement = null;

        public static void main(String ar[]){
            try{
                P4 serveur = new P4();
                System.out.println("Hi server RMI P4 is on :) ");
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

                String database="student.mdb";//Here database exists in the current directory

                String url="jdbc:ucanaccess://C:/Users/GTI/Documents/Database1.accdb";

                Class.forName("org.hsqldb.jdbc.JDBCDriver");
                Connection c=DriverManager.getConnection(url,"","");
                Statement st=c.createStatement();
                statement = st;
//                ResultSet rs=st.executeQuery("select * from TABLE1");
//
//                while(rs.next()){
//                System.out.println(rs.getString(1));
//                }

        }catch(Exception ee){System.out.println(ee);}

        }

    @Override
    public void insert(int mat, String firstName, String lastName) throws RemoteException {
        try {
            boolean rs = statement.execute("insert into TABLE1 ( mat, FIRSTNAME , NAME ) values (" + mat +",'"+firstName+"'" +",'"+lastName+"')");
            rmiServerP2Static.receiveMessage("ROW INSERTED");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int mat) throws RemoteException {
        try {
            boolean rs = statement.execute("delete from TABLE1 where mat = " + mat);
            rmiServerP2Static.receiveMessage("ROW DELETED");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void show() throws RemoteException {

        try {
            ResultSet rs = statement.executeQuery("select * from TABLE1;");
            String messsage = "";
            while (rs.next())
                messsage = messsage + "\n" +rs.getInt(4) + "  " + rs.getString(2)+ "  " + rs.getString(3) ;
            rmiServerP2Static.receiveMessage(messsage);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void update(int mat) throws RemoteException {
        try {
            boolean rs = statement.execute("update etudiant set mat = 100 where mat = " + mat);
            rmiServerP2Static.receiveMessage("ROW DELETED");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

// C:/Users/GTI/Documents