import java.util.*; 

public class CubeTri
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();

        int tot = 0; 
        for(int n = 1; n <= i; n++)
        {
            if(n % 2 == 1)
            {
                tot += n * n * n; 
            }
            else
            {
                tot -= n * n * n; 
            }
        }
        System.out.println(tot);
    }
}