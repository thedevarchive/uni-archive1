
/**
 * Write a description of class Faucet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Faucet
{
    private WaterTank tank; 
    public Faucet(WaterTank w)
    {
        tank = w;
        // connects a newly-made Faucet object
        // and attaches it to an already-made WaterTank object
        
        // by assigning WaterTank tank to w
        // this connects the Faucet to an existing WaterTank
        // instead of a new one
        // or else Faucet is under the WaterTank object (aggregation)
    }
    public void connect(WaterTank w)
    {
        tank = w; 
        //connects the Faucet obj. to another existing WaterTank
    }
    public void dispense(double amt)
    {
        tank.dispense(amt);
    }
    public void flush()
    {
        tank.dispense(tank.getWaterLeft());
    }
    
}
