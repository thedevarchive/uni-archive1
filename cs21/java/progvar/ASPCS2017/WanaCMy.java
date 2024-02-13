import java.util.*; 

public class WanaCMy
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int comp = sc.nextInt();
        int min = -1; 
        for(int i = 0; i < comp; i++)
        {
            int nxt = Math.abs(sc.nextInt());
            if(nxt > min)
            {
                min = nxt; 
            }
        }
        System.out.println("The best Abs value is: " + min);
    }
}