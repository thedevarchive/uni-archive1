import java.util.*; 

public class DiscountBA
{
    public static void main(String args[])
    {
        Scanner jclass = new Scanner(System.in);

        int account = 0; 
        int add = jclass.nextInt();
        for(int i = 0; i < add; i++)
        {
            int deposit = jclass.nextInt();
            account += deposit; 
        }
        int sub = jclass.nextInt();
        for(int i = 0; i < sub; i++)
        {
            int withdraw = jclass.nextInt();
            account -= withdraw[i];
        }
        System.out.println(account);
    }
}