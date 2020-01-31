import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TST {

    public static void main(String[] args) {

        try {


        String url="jdbc:ucanaccess://C:/Users/GTI/Documents/Database1.accdb";

        //Class.forName("org.hsqldb.jdbc.JDBCDriver");
        Connection c= DriverManager.getConnection(url,"","");
        Statement st=c.createStatement();
                ResultSet rs=st.executeQuery("select * from TABLE1");

                while(rs.next()){
                System.out.println(rs.getString(1));
                }
    }catch (Exception x){
            System.out.println(x);
        }
    }
}
