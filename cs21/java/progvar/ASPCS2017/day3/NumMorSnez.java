import java.util.*; 

public class NumMorSnez
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in); 
        int m = sc.nextInt();
        int o = sc.nextInt();
        int r = sc.nextInt();
        int g = sc.nextInt();
        int a = sc.nextInt();
        int n = sc.nextInt();
        int unit = 1; 

        for(int i = 1; i <= 9; i++)
        {
            if(i == m || i == o || i == r || i == g || i == a || i == n)
            {
                continue; 
            }
            while(unit <= 9)
            {
                if(unit != m && unit != o && unit != r && unit != g && unit != a && unit != n)
                {
                    System.out.println(i * 10 + unit);
                }
                unit++; 
            }
            unit = 0; 
        }
    }
}