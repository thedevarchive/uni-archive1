import java.util.*;
public class WhichPhoneWhich
{
	public static int mySearch(String find, String[] a)
	{
		int i=0;
		while (i<a.length)
		{
			if(a[i].equals(find))
			{
				break;
			}
			i++;
		}
		if (i==a.length)
		{
			i=-1;
		}
		return i;
	}
	public static void main(String args[])
	{
		Scanner nl=new Scanner(System.in);
		int words=nl.nextInt();
		String[] wb=new String[words];
		int z=0;
		while (z<words)
		{
			wb[z]=nl.next();
			z++;
		}
	
		while (true)
		{
			String find=nl.next();
			int y= mySearch(find, wb);
			if(find.equals("-1"))
			{
				break;
			}
			if (y==-1)
			{
				System.out.println("MISSING");
			}
			else 
			{
				System.out.println("FOUND");
			}
		}
	}
}