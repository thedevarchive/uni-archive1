import java.util.*; 
public class DemAbs
{
    public static int mag4(int n)
    {
        n *= 4; 
        return n; 
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        System.out.println(mag4(num));
    }
}