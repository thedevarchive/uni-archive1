import java.util.*;
public class LuckySeven
{
	public static void main(String args[])
	{
		Scanner range=new Scanner(System.in);
		int NumOne=range.nextInt();
		int NumTwo=range.nextInt();
		int h=Math.max(NumOne, NumTwo);
		int l=Math.min(NumOne, NumTwo);
		int c=0;
		while (l>=0 || h>=0)
		{
			while (l<=h)
			{
				if (l%7==0)
				{
					System.out.println(l);
				}
				l++;
			}
			NumOne=range.nextInt();
			NumTwo=range.nextInt();
			h=Math.max(NumOne, NumTwo);
			l=Math.min(NumOne, NumTwo);
		}
	}
}