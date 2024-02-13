
/**
 * Write a description of class WaterTank here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WaterTank
{
    private double waterLeft = 0;
    
    public void fillTank()
    {
        waterLeft = 100; 
    }
    public void dispense(double amt)
    {
        waterLeft -= amt; 
    }
    public double getWaterLeft()
    {
        return waterLeft;
    }
}
