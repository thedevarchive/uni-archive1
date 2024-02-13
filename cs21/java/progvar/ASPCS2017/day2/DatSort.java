import java.util.*; 

public class DatSort
{
    public static void main(String args[])
    {
        Scanner a = new Scanner(System.in);
        int s = a.nextInt();
        int p = a.nextInt();
        int c = a.nextInt(); 
        
        if(s == p && p == c && s == c)
        {
            System.out.println("equal");
        }
        else if(s <= p && p <= c && s <= c)
        {
            System.out.println("increasing");
        }
        else if(s >= p && p >= c && s >= c)
        {
            System.out.println("decreasing");
        }
        else
        {
            System.out.println("not sorted");
        }
    }
}