import java.util.*; 
public class PCScared
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int begin = sc.nextInt();
        int end = sc.nextInt();
        for(int i = begin; i <= end; i++)
        {
            if(i < 10)
            {
                System.out.println("team0" + i);
            }
            else
            {
                System.out.println("team" + i);
            }
        }
    }
}