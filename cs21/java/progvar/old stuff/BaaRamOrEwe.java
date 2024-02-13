import java.util.*;
public class BaaRamOrEwe
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		String search="SHEEP";
		while (true)
		{
			String s=sc.nextLine();
			if(s.equals("STOP"))
			{
				break;
			}
		int i=0;
		int count=0;
		
		while (true)
		{
			if(s.indexOf (search, i)>=0)
			{
				count++;
				i=s.indexOf (search, i)+1;
			}
			else
			{
			break;
			}
		}
		System.out.println(count);
		}
	}
}
			