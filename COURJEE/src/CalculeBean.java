
@Stateless
public class CalculeBean implements  Calcule{

    int add (int x , int y){
        return x+y;
    }
    int mul (int x , int y){
        return x*y;
    }
    int div (int x , int y){
        return x/y;
    }

}