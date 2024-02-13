import java.util.*;
public class ULuckyYet
{
	public static void main(String args[])
	{
		Scanner nn=new Scanner(System.in);
		int branches=nn.nextInt();
		while (branches>0)
		{
			if(0==branches%3 && 0==branches%7)
			{System.out.println("LUCKY");
			}
			else
			{System.out.println("normal");
			}
			branches=nn.nextInt();
		}
	}
}