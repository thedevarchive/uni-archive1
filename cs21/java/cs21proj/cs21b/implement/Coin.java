
/**
 * Write a description of class Coin here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Coin implements Measurbl
{
    // instance variables - replace the example below with your own
    private double value; 
    private String coinName; 

    /**
     * Constructor for objects of class Coin
     */
    public Coin(String n, double val)
    {
        // initialise instance variables
        coinName = n; 
        value = val; 
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public double getMeasure()
    {
        return value; 
    }
    
    public String getName()
    {
        return coinName; 
    }
}
