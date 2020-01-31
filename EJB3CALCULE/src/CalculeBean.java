import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.ejb.Remote;

@Stateful
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
    
    public void a () {
    	System.out.println("La mul de x et de y est       >>" );
    }
}