
/**
 * 
 * Alyssa Mae King Ngo
 * October 17, 2016
 * 153023
 * 
 * I hereby attest to the truth of the following facts:
 * 
 * I have not discussed the Java language code in my program with anyone other than my instructor or 
the teaching assistants assigned to this course.
 *
 * I have not used Java language code obtained from another student, or any other unauthorized source, 
either modified or unmodified.
 *
 * If any Java language code or documentation used in my program was obtained from another source, 
such as a text book or course notes, that has been clearly noted with a proper citation in the comments of my program.
 */
public class SodaMachine
{

    private double amt; // amount of soda in the machine in L
    private double money; // money from selling soda
    private int cups; // cups of soda dispensed
    private double cost; // cost of each cup of soda

    /**
     * Constructor for objects of class SodaMachine
     */
    public SodaMachine()
    {
        // initialise instance variables
        amt = 5.000; 
        money = 0.00;
        cups = 0; 
        cost = 12.50;
    }

    public void addSoda(double refill)
    {
        // put your code here
        amt += refill; 
    }
    
    public void sellSoda(int numCups)
    {
        amt -= numCups * .250;
        cups += numCups;
        money += numCups * cost; 
    }
    
    public double getSodaLeft()
    {
        return amt; 
    }
    
    public int getCupsSold()
    {
        return cups; 
    }
    
    public double getSales()
    {
        return money; 
    }
    
    public void printReport()
    {
        System.out.println("Cups of Soda sold: " + cups + " cups");
        System.out.printf("Remaining Soda: Php %.2f liters\n", amt);
        System.out.printf("Total Sales: Php %.2f\n", money);
    }
}
