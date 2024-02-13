import java.util.*; 

public class CommandCalc
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int commands = sc.nextInt(); 
        for(int i = 0; i < commands; i++)
        {
            String s = sc.next(); 
            if(s.equals("negate"))
            {
                int a = sc.nextInt();
                System.out.println(-a);
            }
            else if(s.equals("add"))
            {
                int x = sc.nextInt();
                int y = sc.nextInt();
                System.out.println(x + y);
            }
            else if(s.equals("max"))
            {
                int p = sc.nextInt();
                int c = sc.nextInt();
                if(p >= c)
                {
                    System.out.println(p);
                }
                else
                {
                    System.out.println(c);
                }
            }
        }
    }
}