
/**
 * Write a description of class svAcc here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class svAcc extends bankAcc
{
    // instance variables - replace the example below with your own
    private double intR;

    /**
     * Constructor for objects of class svAcc
     */
    public svAcc(String n, double amt, double r)
    {
        super(n, amt);
        intR = r; 
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public void addInt(int y)
    {
        double i = getBal() * intR; 
        dep(i); 
    }
}
