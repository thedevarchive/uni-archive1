
/**
 * Write a description of class DataSet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DataSet
{
    // instance variables - replace the example below with your own
    public double sum; 
    private int count; 
    private Measurbl max; 
    
    public DataSet()
    {
        count = 0; 
    }
    
    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public void add (Measurbl x)
    {
        if(count == 0 || x.getMeasure() > max.getMeasure())
        {
            max = x; 
        }
        count++;
    }

    public Measurbl getMax()
    {
        return max; 
    }
}
