import java.sql.*;
class P2{
    public static void main(String ar[]){
        try{
            String database="student.mdb";//Here database exists in the current directory

            String url="jdbc:ucanaccess://C:/Users/GTI/Documents/Database1.accdb";

            Class.forName("org.hsqldb.jdbc.JDBCDriver");
            Connection c=DriverManager.getConnection(url,"","");
            Statement st=c.createStatement();
            ResultSet rs=st.executeQuery("select * from TABLE1");

            while(rs.next()){
                System.out.println(rs.getString(1));
            }

        }catch(Exception ee){System.out.println(ee);}

    }}

    // C:/Users/GTI/Documents