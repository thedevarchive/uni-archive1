import java.util.*;
public class WhatsInARect
{
	public static void main (String args[])
	{
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int i=0;
		while (n>i)
		{
			double l=sc.nextDouble();
			double w=sc.nextDouble();
			double p=l+l+w+w;
			double a=l*w;
			System.out.print("Its area is ");
			System.out.printf("%.2f", a);
			System.out.print(" and its perimeter is ");
			System.out.printf("%.2f", p);
			System.out.println(".");
			i++;
		}
	}
}