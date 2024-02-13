
/**
 * Write a description of class fooBnk here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class fooBnk
{
    public static void main(String args[])
    {
        bankAcc anon = new bankAcc(); 
        anon.dep(150); 
        System.out.printf("%.2f\n", anon.getBal()); 
        bankAcc ymous = new bankAcc(); 
        ymous.dep(1); 
        System.out.println(ymous.getNm()); 
        System.out.printf("%.2f\n", ymous.getBal());
        bankAcc admin = new bankAcc("ses wes pes", 2500); 
        admin.dep(2.5); 
        admin.wd(1000); 
        System.out.println(admin.getNm());
        System.out.printf("%.2f\n", admin.getBal()); 
    }
}
