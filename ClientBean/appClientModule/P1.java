import java.util.List;
import java.util.Iterator;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;




public class P1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			
					
			Properties props = System.getProperties();
			props.put("java.naming.factory.initial","org.jnp.interfaces.NamingContextFactory");
			props.put("java.naming.factory.url.pkgs","org.jboss.naming:org.jnp.interfaces");
			props.put("java.naming.provider.url","localhost:1099");
			Context ctx = new InitialContext(props);
			
			InterfaceMUL p1 = (InterfaceMUL) ctx.lookup("EJBMULBean/remote");
			
			//stock.ajouter(new Produit("0", "Orange", 2212));
			System.out.println("Befosdfsdre Eacrh");
			
			String s = "SAADI";
			String s2 = "Sihem";
			p1.getString(s, s2);
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
}
