import java.util.*;
public class RectAreaSortr
{
	public static void main(String args[])
	{
		Scanner range=new Scanner(System.in);
		int array=range.nextInt();
		int[] panels=new int[array];
		
		int c=0;
		while (c<panels.length)
		{
			int w=range.nextInt();
			int h=range.nextInt();
			panels[c]=w*h;
			c++;
		}
		Arrays.sort(panels);
		{
			int i=0;
			while (i<panels.length)
			{
				System.out.println(panels[i]);
				i++;
			}
		}
	}
}