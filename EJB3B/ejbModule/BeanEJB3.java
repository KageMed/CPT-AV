import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.naming.Context;
import javax.naming.InitialContext;

import java.util.Properties;

import javax.ejb.Remote;

@Stateful
public class BeanEJB3 implements  InterfaceEJB3{

	public String insert(int mat, String lastName, String firstName) {
		// TODO Auto-generated method stub
		System.out.print("INSERT CALLED BY ********");
		String message = "INSERT";
		return message;
		
	}

	public String delete(int mat) {
		// TODO Auto-generated method stub
		String message = "INSERT";
		return message;
		
	}

	public String show() {
		// TODO Auto-generated method stub
		System.out.print("SHOW CALLED BY ********");
		JDBC jdbc = new JDBC();
		
		try {
            String message = jdbc.show();
            System.out.print(message);
            return message;

        } catch (Exception e) {
            System.out.println(e);;
        }
		return "Show ";
	}
   	
}