
/**
 * Write a description of class Driver here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Driver
{
   public static void main(String args[])
   {
       WaterTank w = new WaterTank(); 
       // makes new WaterTank w
       WaterTank x = new WaterTank(); 
       // makes new WaterTank x
       w.fillTank();
       // fills WaterTank w
       x.fillTank(); 
       // fills WaterTank x
       Faucet f1 = new Faucet(w);
       // makes a new Faucet f1 that is attached to w
       Faucet f2 = new Faucet(w);
       // makes a new Faucet f2 also attached to w
       f1.dispense(20); 
       // makes Faucet f1 dispense some water from w
       f2.flush();
       // f2 removes all water from w
       f1.connect(x); 
       // f1 is now also attached to WaterTank x
       f1.dispense(50); 
       // f1 dispenses half of WaterTank x
       System.out.println(w.getWaterLeft());
       // prints out how much water is left in w (0)
       System.out.println(x.getWaterLeft()); 
       // prints out how much water remains in x (50)
    }
}
