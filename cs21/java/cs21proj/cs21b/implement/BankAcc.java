
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Faculty
 */
public class BankAcc implements Measurbl
{
    
    private String acctName;
    private double balance;
    
    public BankAcc()
    {
        balance = 0;
        acctName = "anonymous";
    }
    
    public BankAcc(String n, double initBal)
    {
        acctName = n;
        balance = initBal;
    }
    
    public void deposit(double amt)
    {
        balance += amt;
    }
    
    public void withdraw(double amt)
    {
        if(amt>=balance)
        {
            System.out.println("Ur too poor");
        }
        else
        {
            balance -= amt;
        }
    }
    
    public String getName()
    {
        return acctName;
    }
    
    public double getMeasure()
    {
        return balance;
    }
}
