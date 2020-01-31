package EJB3B;

import javax.ejb.Remote;

@Remote
public interface InterfaceEJB3 {
	
		public String insert (int mat , String lastName,String firstName);
	    public String delete (int mat);
	    public String show ();
	    
}
