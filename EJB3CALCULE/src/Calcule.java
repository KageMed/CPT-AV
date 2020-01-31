import javax.ejb.Remote;

@Remote
public interface Calcule {
	
	 	int add(int x, int y);
	    int mul(int x, int y);
	    int div(int x, int y);
}
