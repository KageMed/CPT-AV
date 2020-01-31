package ClientP3;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;

import Calcule.Calcule;

public class CTEST {
	public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        Properties props = System.getProperties();
        props.put(Context.INITIAL_CONTEXT_FACTORY, "org.jnp.interfaces.NamingContextFactory");
        props.put(Context.URL_PKG_PREFIXES, "org.jboss.naming:org.jnp.interfaces");
        props.put(Context.PROVIDER_URL, "jnp://localhost:1099");
        System.out.println("after propss");
        Context ctx =  new InitialContext(props);
        Calcule op = (Calcule) ctx.lookup("CalculeBean/remote");
        System.out.println("****" + op.add(2, 2));
	}
}
