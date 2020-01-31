package ClientP3;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

import Calcule.Calcule;

public class ClientP3 {
    private static int NUM_PORT = 8079;
    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        Properties props = System.getProperties();
        props.put(Context.INITIAL_CONTEXT_FACTORY, "org.jnp.interfaces.NamingContextFactory");
        props.put(Context.URL_PKG_PREFIXES, "org.jboss.naming:org.jnp.interfaces");
        props.put(Context.PROVIDER_URL, "jnp://localhost:1099");
        System.out.println("after propss");
        Context ctx =  new InitialContext(props);
        Calcule op = (Calcule) ctx.lookup("CalculeBean/remote");

        Scanner e = new Scanner(System.in);
        ServerSocket serverSocket = new ServerSocket(NUM_PORT);
        System.out.println("Waiting for connection P2");
        Socket waiting = serverSocket.accept();
        ObjectInputStream in = new ObjectInputStream(waiting.getInputStream());
        ObjectOutputStream out = new ObjectOutputStream(waiting.getOutputStream());

        while (true) {
            int choix =  Integer.parseInt( (String) in.readObject());
            switch (choix){
                case 1: {

                    int mat = Integer.parseInt( (String) in.readObject());
                    String lastName = (String) in.readObject();
                    String firstName = (String) in.readObject();

                    System.out.println("P2 > " + "mat : " + mat + ", lastName : " + lastName + ", lastName : " + firstName);
                    op.insert(mat,lastName,firstName);
                    break;
                }
                case 2: {

                    int mat = Integer.parseInt( (String) in.readObject());
                    System.out.println("P2 > " + "mat : " + mat );
                    op.delete(mat);  
                    break;
                }
                case 3: {

                    System.out.println("P2 > Show list " );
                    out.writeObject("" + op.show());
                    break;
                }

            }

        }

    }

}
