import java.util.*; 
public class RvrsRngr
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int data = sc.nextInt();
        int[] values = new int[data];
        for(int i = 0; i < data; i++)
        {
            values[i] = sc.nextInt();
        }
        int begin = sc.nextInt();
        int end = sc.nextInt(); 
        int tot = 0; 
        for(int i = begin; i <= end; i++)
        {
            tot += values[i]; 
        }
        System.out.println("RSQ(" + begin + "," + end + ")=" + tot); 
    }
}