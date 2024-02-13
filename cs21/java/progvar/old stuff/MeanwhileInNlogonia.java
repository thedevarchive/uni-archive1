import java.util.*;
public class MeanwhileInNlogonia
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
	
		int lookup=nl.nextInt();
		int x=0;
		while (x<lookup)
		{
			String find=nl.next();
			int y= mySearch(find, wb);
			if (y==-1)
			{
				System.out.println(find+" is not Nlogonian.");
			}
			else 
			{
				System.out.println(find+" is Nlogonian.");
			}
			x++;
		}
	}
}