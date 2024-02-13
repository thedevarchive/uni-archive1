import java.util.*; 
public class TheFinalCD
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int start = sc.nextInt();
        int end = sc.nextInt();
        for(int i = end; i >= start; i--)
        {
            System.out.println(i);
        }
    }
}