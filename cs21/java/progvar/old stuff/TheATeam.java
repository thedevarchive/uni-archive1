import java.util.*;
public class TheATeam
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		String s=sc.nextLine();
		int num=0;
		int count=s.length();
		while (num<count)
		{
			if(s.charAt(num)=='A' || s.charAt(num)=='a')
			{
				System.out.println(s.charAt(num)+ " found at index " +num);
			}
			num++;
		}
	}
}