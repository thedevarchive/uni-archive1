
/**
 * Write a description of class test here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class test
{
   public static void main(String args[])
   {
       Player a = new Player("p1"); 
       Player b = new Player("p2"); 
       Arbiter c = new Arbiter(a, b); 
       a.discard(); 
       c.dealCard(); 
       a.discard(); 
       c.dealCard();
       a.discard(); 
       c.dealCard();
       a.discard(); 
       c.dealCard();
       a.discard(); 
       c.dealCard();
       a.discard(); 
       c.dealCard();
       a.discard(); 
       c.dealCard();
       a.discard(); 
       c.dealCard();
       a.discard(); 
       c.dealCard();
       a.discard(); 
       c.dealCard();
       a.discard(); 
       c.dealCard();
       a.discard(); 
       c.dealCard();
       a.discard(); 
       c.dealCard();
       a.discard(); 
       c.dealCard();
       a.discard(); 
       c.dealCard();
       a.discard(); 
       c.dealCard();
       a.discard(); 
       c.dealCard();
       a.discard(); 
       c.dealCard();
       a.discard(); 
       c.dealCard();
       System.out.println(c.play("swap")); 
       System.out.println(a.statusReport()); 
   }
}
