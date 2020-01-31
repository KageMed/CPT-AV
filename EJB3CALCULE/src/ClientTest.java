import javax.naming.Context;
import javax.naming.InitialContext;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Properties;

public class ClientTest {

    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        Properties props = System.getProperties();
        props.put(Context.INITIAL_CONTEXT_FACTORY, "org.jnp.interfaces.NamingContextFactory");
        props.put(Context.URL_PKG_PREFIXES, "org.jboss.naming:org.jnp.interfaces");
        props.put(Context.PROVIDER_URL, "jnp://localhost:1099");
        System.out.println("after props");
        Context ctx = new InitialContext(props);
        Calcule op = (Calcule) ctx.lookup("CalculeBean/remote");
        System.out.println("La somme de x et de y est       >>" + op.add(3, 3));
        System.out.println("La mul de x et de y est       >>" + op.mul(3, 3));
        System.out.println("La div de x et de y est       >>" + op.div(3, 3));


    }

}
