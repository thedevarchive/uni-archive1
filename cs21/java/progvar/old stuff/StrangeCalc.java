
import java.util.*;
public class StrangeCalc
{
	public static void main (String args[])
	{
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int i=0;
		while (n>i)
		{
			int C=sc.nextInt();
			double M=sc.nextDouble();
			if(C==1)
			{
				double d=Math.abs(M);
				System.out.printf("%.3f\n",d);
			
			}
			else if (C==2)
			{
				double x=Math.sqrt(M);
				System.out.printf("%.3f\n", x);
			}
			else if (C==3)
			{
				double e=Math.pow(M, 5);
				System.out.printf("%.3f\n", e);
			}
			else if(C==4)
			{
				double a=Math.log10(M);
				System.out.printf("%.3f\n", a);
		
	}
			else if (C==5)
			{
				System.out.printf("%.3f\n", M);
			}
			i++;
		}
	}
}