package EJB3B;

import javax.swing.plaf.nimbus.State;
import java.rmi.RemoteException;
import java.sql.*;

public class JDBC {

    private Statement statement;
    static Statement st;

    public JDBC() {

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:orcl", "system", "ADMIn150865");
            this.statement = con.createStatement();
            st = this.statement;
            System.out.println("Connected to Oracle Database");
        } catch (Exception e) {
            System.out.println(e.toString());

        }
    }

    public void insert(int mat, int mat2) throws RemoteException {
        try {
            boolean rs = this.statement.execute("insert into exam values (" + mat + "," + mat2 + ")");
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }

    public void delete(int mat) throws RemoteException {
        try {
            boolean rs = this.statement.execute("delete from exam where mat = " + mat);
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }

    public String show() throws RemoteException {

        try {
            ResultSet rs = this.statement.executeQuery("select * from exam");
            String messsage = "";
            while (rs.next())
                messsage = messsage + "\n" +rs.getInt(1) + "  " + rs.getString(2)+ "  " + rs.getString(3) ;
            return  messsage;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return "";
        }

    }


}
