import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.naming.Context;
import javax.naming.InitialContext;


import java.util.Properties;

import javax.ejb.Remote;

@Stateless
public class EJBMULBean implements InterfaceMUL {

	public void getString(String s , String s2) {
		String a = "";
		a = "" + a + ("Bonjour "+ s + " " + s2 + "\n");
		for (int i = 1 ; i < 10 ;i++){
			for (int j = 1 ; j <= 10 ;j++){
				
				if (j % 2 == 1) {
					a = "" + a + (j + "*" + i + "="  + j*i + "\t");
				}
				
			}
			a = a + "\n";
		}
		a = "" + a +("\n----------------------------------------------------\n");	
		
		for (int i = 1 ; i < 10 ;i++){
			for (int j = 1 ; j <= 10 ;j++){
				
				if (j % 2 == 0) {
					a = "" + a + (j + "*" + i + "="  + j*i + "\t");
				}
				
			}
			a = a + "\n";
		}
		
		System.out.println(a);
	}

	
}
