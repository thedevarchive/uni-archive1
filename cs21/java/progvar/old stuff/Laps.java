import java.util.*;
public class Laps
{
	public static void main (String args[])
	{
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int i=0;
		while (n>i)
		{
			double r=sc.nextDouble();
			double q=r*2*Math.PI;
			System.out.printf("%.2f\n", q);
			i++;
		}
	}
}	