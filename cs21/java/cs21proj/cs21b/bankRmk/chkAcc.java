
/**
 * Write a description of class chkAcc here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class chkAcc extends bankAcc
{
    // instance variables - replace the example below with your own
    private static final int MAX = 3; 
    private double fee; 
    private int numT; 

    /**
     * Constructor for objects of class chkAcc
     */
    public chkAcc(String name, double initBal, double f)
    {
        // initialise instance variables
        super(name, initBal); 
        fee = f; 
        numT = 0; 
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public void dep(double amt)
    {
        // put your code here
        numT++; 
        super.dep(amt); 
    }
    public void dedcFee()
    {
        if(numT > MAX)
        {
            super.wd(fee); 
        }
    }
}
