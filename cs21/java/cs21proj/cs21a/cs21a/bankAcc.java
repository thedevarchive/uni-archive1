
/**
 * Write a description of class bankAcc here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class bankAcc
{
    
    private double bal;

    
    public bankAcc()
    {
        bal = 0;
    }

    public void dep(double amt)
    {
        bal += amt;
    }
    
    public void with(double amt)
    {
        bal -= amt; 
    }
    
    public double getBal()
    {
        return bal; 
    }
}
