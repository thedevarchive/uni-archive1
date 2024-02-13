
/**
 * Write a description of class test here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class test
{
    // instance variables - replace the example below with your own
    public static void main (String args[])
    {
        Measurbl a = new BankAcc("foo", 100); 
        Measurbl b = new BankAcc("bar", 200); 
        Measurbl c = new Coin("qux", 300); 
        
        DataSet ds = new DataSet(); 
        ds.add(a); 
        ds.add(b);
        ds.add(c); 
        
        Measurbl richest = ds.getMax(); 
        
        System.out.println(richest.getName()); 
    }
}
