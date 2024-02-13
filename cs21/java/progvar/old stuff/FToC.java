import java.util.*;
public class FToC
{
	public static void main(String args[])
	{
		Scanner range=new Scanner(System.in);
		int N=range.nextInt();
		int countr=0;
		while(countr<N)
		{
			double f=range.nextDouble();
			double c=(f-32)*5/9;
			System.out.printf("%.2f\n", c);
			countr++;
		}
	}
}