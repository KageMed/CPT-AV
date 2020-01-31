

import java.util.List;
import java.util.Iterator;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;


import com.et.GestionDeStock;
import com.et.GestionDeStockBean;
import com.et.Produit;

import Calcule.Calcule;
import EJB3B.InterfaceEJB3;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
try {
	Properties props = System.getProperties();
	props.put(Context.INITIAL_CONTEXT_FACTORY, "org.jnp.interfaces.NamingContextFactory");
	props.put(Context.URL_PKG_PREFIXES, "org.jboss.naming:org.jnp.interfaces");
	props.put(Context.PROVIDER_URL, "jnp://localhost:1099");
	System.out.println("after props");
	Context ctx =  new InitialContext(props);
	InterfaceEJB3 op = (InterfaceEJB3) ctx.lookup("BeanEJB3/remote");
	op.show();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}


