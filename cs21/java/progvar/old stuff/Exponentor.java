
import java.util.*;
public class Exponentor
{
	public static void main(String args[])
	{
		Scanner number=new Scanner(System.in);
		int i=number.nextInt();
		int z=0;
		while (z<i)
		{
			double N=number.nextDouble();
			double E=number.nextDouble();
			double result=Math.pow(N, E);
			System.out.printf("%.2f\n", result);
			z++;
		}
	}
}