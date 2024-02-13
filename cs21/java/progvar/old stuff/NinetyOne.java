
import java.util.*;
public class NinetyOne
{
	public static int f91(int N)
	{
		if (N>=101)
		{
			N= N-10;
			return N;
		}
		else
	
	{
			return f91(f91(N+11));
		}
	}
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		while (true)
		{
			int N=sc.nextInt();
			if(N==0)
			{
				break;
			}
			else
			{
				System.out.println("f91("+N+") = "+f91(N));
			}
		}
	}
}