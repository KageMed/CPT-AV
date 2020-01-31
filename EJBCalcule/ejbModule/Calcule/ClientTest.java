package Calcule;

import javax.naming.Context;
import javax.naming.InitialContext;

import EJB3B.InterfaceEJB3;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Properties;

public class ClientTest {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		try {
	    	Properties props = System.getProperties();
			props.put(Context.INITIAL_CONTEXT_FACTORY, "org.jnp.interfaces.NamingContextFactory");
			props.put(Context.URL_PKG_PREFIXES, "org.jboss.naming:org.jnp.interfaces");
			props.put(Context.PROVIDER_URL, "jnp://localhost:1099");
			System.out.println("after propsSSS");
			Context ctx =  new InitialContext(props);
			InterfaceEJB3 op = (InterfaceEJB3) ctx.lookup("BeanEJB3/remote");
			//op.show();
			System.out.println("after propsZ");
			Calcule op2 = (Calcule) ctx.lookup("CalculeBean/remote");
	        
	        System.out.println("DIV : " + op2.div(10, 2));
	        System.out.println("ADD : " + op2.add(10, 2));
	        System.out.println("after props2");
		}
    	catch(Exception e) {
    		System.out.println(e);
    	}
	       
		
	}

}
