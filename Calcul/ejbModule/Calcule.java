
import javax.ejb.Remote;

@Remote
public interface Calcule {
	
		public void a ();
	 	int add (int x , int y);
	    int mul (int x , int y);
	    int div (int x , int y);
	    public String insert (int mat , String lastName,String firstName);
	    public String delete (int mat);
	    public String show ();
}
