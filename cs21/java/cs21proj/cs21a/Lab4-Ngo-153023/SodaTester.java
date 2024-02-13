
/**
 * Write a description of class SodaTester here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SodaTester
{
   public static void main (String args[])
   {
       SodaMachine cola = new SodaMachine(); 
       cola.addSoda(3); 
       cola.sellSoda(25);
       cola.addSoda(1.5);
       cola.sellSoda(7);
       cola.printReport();
   }
}
