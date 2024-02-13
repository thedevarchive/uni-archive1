
/**
 * Write a description of class bankAcc here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class bankAcc
{
    private double bal; 
    private String acctNm; 
    
    /**
     * Constructor for objects of class bankAcc
     */
    public bankAcc()
    {
        bal = 0; 
        acctNm = "guest";
    }
    
    public bankAcc(String n, double b)
    {
        bal = b; 
        acctNm = n; 
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public void dep(double amt)
    {
        bal += amt; 
    }
    
    public void wd(double amt)
    {
        if(bal <= amt)
        {
            bal -= amt; 
        }
    }
    
    public double getBal()
    {
        return bal; 
    }
    
    public String getNm()
    {
        return acctNm; 
    }
}
