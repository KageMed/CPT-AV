import java.util.List;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;


import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class GestionDeStockBean implements GestionDeStock{

	@PersistenceContext
	EntityManager em;
	
	public void ajouter(Produit produit) {
		// TODO Auto-generated method stub
		em.persist(produit);
	}

	public Produit rechercherProduit(String id) {
		// TODO Auto-generated method stub
		return em.find(Produit.class, id);
	}

	public List<Produit> listerTousLesProduits() {
		// TODO Auto-generated method stub
		return em.createQuery("SELECT p FROM Produit p ORDER BY p.quantiteEnStock").getResultList();
	}
	
	public void communication () {
		
		try {
			
		    Properties props = System.getProperties();
	        props.put(Context.INITIAL_CONTEXT_FACTORY, "org.jnp.interfaces.NamingContextFactory");
	        props.put(Context.URL_PKG_PREFIXES, "org.jboss.naming:org.jnp.interfaces");
	        props.put(Context.PROVIDER_URL, "jnp://localhost:1099");
	        System.out.println("after PPPPpropss");
	        Context ctx =  new InitialContext(props);
	        Calcule op = (Calcule) ctx.lookup("CalculeBean/remote");
	        InterfaceEJB3 op2 = (InterfaceEJB3) ctx.lookup("BeanEJB3/remote");
	        System.out.println("show CALsssseEssddDLLLLsSSSSSS*도도도도s");
			op2.show();
	        System.out.println("DIV : " + op.div(10, 2));
	        System.out.println("ADD : " + op.add(10, 2));
	        
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
