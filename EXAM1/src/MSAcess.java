import java.rmi.RemoteException;
import java.sql.*;

public class MSAcess {

    private Statement statement;

    public MSAcess() {

        try {
            String url = "jdbc:ucanaccess://C:/Users/GTI/Documents/Database1.accdb";
            Class.forName("org.hsqldb.jdbc.JDBCDriver");
            Connection c = DriverManager.getConnection(url, "", "");
            this.statement = c.createStatement();
            System.out.println("Connected to MS Database");
        } catch (Exception e) {
            System.out.println(e.toString());

        }
    }


    public void insert(int mat, String firstName, String lastName){
        try {
            boolean rs = statement.execute("insert into TABLE1 ( mat, FIRSTNAME , NAME ) values (" + mat +",'"+firstName+"'" +",'"+lastName+"')");

        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }


    public void delete(int mat) {
        try {
            boolean rs = statement.execute("delete from TABLE1 where mat = " + mat);

        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }


    public String show()  {

        try {
            ResultSet rs = this.statement.executeQuery("select * from TABLE1;");
            String messsage = "";
            while (rs.next())
                messsage = messsage + "\n" +rs.getInt(4) + "  " + rs.getString(2)+ "  " + rs.getString(3) ;
            return messsage;
        } catch (Exception e) {
            System.out.println(e.toString());
            return "";
        }

    }
}


