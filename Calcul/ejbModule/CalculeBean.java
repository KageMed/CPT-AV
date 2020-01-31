import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.naming.Context;
import javax.naming.InitialContext;


import java.util.Properties;

import javax.ejb.Remote;

@Stateless
public class CalculeBean implements  Calcule{
    public int add (int x , int y){
        return x+y;
    }
    public int mul (int x , int y){
        return x*y;
    }
    public int div (int x , int y){
        return x/y;
    }
    

    public String insert (int mat , String lastName,String firstName){
    	try {
	    	Properties props = System.getProperties();
			props.put(Context.INITIAL_CONTEXT_FACTORY, "org.jnp.interfaces.NamingContextFactory");
			props.put(Context.URL_PKG_PREFIXES, "org.jboss.naming:org.jnp.interfaces");
			props.put(Context.PROVIDER_URL, "jnp://localhost:1099");
			System.out.println("after props");
			Context ctx =  new InitialContext(props);
			InterfaceEJB3 op = (InterfaceEJB3) ctx.lookup("BeanEJB3B/remote");
			return  op.insert(mat, lastName, firstName);
			}
    	catch(Exception e) {
    		System.out.println(e);
    	}
    	return "";
    }
    public String show () {
    	try {
	    	Properties props = System.getProperties();
			props.put(Context.INITIAL_CONTEXT_FACTORY, "org.jnp.interfaces.NamingContextFactory");
			props.put(Context.URL_PKG_PREFIXES, "org.jboss.naming:org.jnp.interfaces");
			props.put(Context.PROVIDER_URL, "jnp://localhost:1099");
			System.out.println("after props");
			Context ctx =  new InitialContext(props);
			InterfaceEJB3 op = (InterfaceEJB3) ctx.lookup("BeanEJB3/remote");
			op.show();
		}
    	catch(Exception e) {
    		System.out.println(e);
    	}
    	return "";
    }
    public String delete (int mat) {
    	try {
	    	Properties props = System.getProperties();
			props.put(Context.INITIAL_CONTEXT_FACTORY, "org.jnp.interfaces.NamingContextFactory");
			props.put(Context.URL_PKG_PREFIXES, "org.jboss.naming:org.jnp.interfaces");
			props.put(Context.PROVIDER_URL, "jnp://localhost:1099");
			System.out.println("after props");
			Context ctx =  new InitialContext(props);
			InterfaceEJB3 op = (InterfaceEJB3) ctx.lookup("BeanEJB3/remote");
			return "" + op.delete(mat);
			}
    	catch(Exception e) {
    		System.out.println(e);
    	}
    	return "";
    }
    
    public void receive(String m) {
    	
    }

    public void a() {
		// TODO Auto-generated method stub
		
	}
}