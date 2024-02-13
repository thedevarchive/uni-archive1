
/**
 * Write a description of class bankSys here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class bankSys
{
    public static void main(String args[])
    {
        bankAcc amn = new bankAcc();
        amn.dep(500);
        System.out.println(amn.getBal());
        amn.with(30);
        System.out.println(amn.getBal());
    }
}
