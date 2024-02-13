import java.util.*;
public class Cycles
{
	public static void main (String[] args)
	{
        Scanner foo = new Scanner (System.in);
        int num1 = foo.nextInt();
        int num2 = foo.nextInt();
        int cycles = 0;
        int bar = num1;
        int max = 0;
        int chkr = bar % 2;
        int storg = num1;
        while (storg <= num2)
        {
           while (bar != 1)
           {
               if (chkr == 0)
               {
                    bar = bar / 2;
               }
               else
               {
                   bar = 3 * bar + 1;
               }
                cycles++;
           }
           if (cycles > max)
           {
               max = cycles;
           }
           storg++;
           bar = storg;
        }
        System.out.println(num1 + " " + num2 + " " + max);
    }
}