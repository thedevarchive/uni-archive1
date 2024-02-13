import java.util.*; 

public class Pyranytmr
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in); 
        int a = sc.nextInt(); 
        int col = 1; 
        for (int i = 1; i <= a; i++)
        {
            for(int j = 1; j <= col; j++)
            {
                if(j == col)
                {
                    System.out.println(j);
                }
                else
                {
                    System.out.print(j + " ");
                }
            }
            col++; 
        }
    }
}