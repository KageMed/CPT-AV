

import java.util.List;
import java.util.Iterator;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;


import com.et.GestionDeStock;
import com.et.GestionDeStockBean;
import com.et.Produit;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			
			Properties props = System.getProperties();
			props.put("java.naming.factory.initial","org.jnp.interfaces.NamingContextFactory");
			props.put("java.naming.factory.url.pkgs","org.jboss.naming:org.jnp.interfaces");
			props.put("java.naming.provider.url","localhost:1099");
			Context ctx = new InitialContext(props);
			
			GestionDeStock stock = (GestionDeStock) ctx.lookup("GestionDeStockBean/remote");
			
			stock.ajouter(new Produit("1212", "Orange", 212));
			System.out.println("Before Eacrh");
			List<Produit> produits = stock.listerTousLesProduits();
			for(Iterator iter = produits.iterator(); iter.hasNext();) {
				Produit eachProduit = (Produit) iter.next();
				System.out.println(eachProduit);
			}
			System.out.println("After Each");
			stock.communication();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}


