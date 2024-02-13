import java.util.*; 
public class DiscountRNG
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int c = sc.nextInt();
        int m = sc.nextInt();
        int x = sc.nextInt();
        System.out.println((a * x + c) % m);
    }
}