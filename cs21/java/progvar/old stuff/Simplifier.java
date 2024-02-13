import java.util.*;
public class Simplifier
{
	public static void main (String args[])
	{
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int i=0;
		while (n>i)
		{
			int a=sc.nextInt();
			int b=sc.nextInt();
			int N=Math.max(a, b);
			int D=Math.min(a, b);
			while (D!=0)
			{
				int t=D;
				D=N%D;
				N=t;
			}
			System.out.print(a/N);
			System.out.print("/");
			System.out.println(b/N);
			i++;
		}
	}
}