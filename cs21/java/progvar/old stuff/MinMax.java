import java.util.*;
public class MinMax
{
	public static void main(String args[])
	{
		Scanner a=new Scanner(System.in);
		int[] no=new int[10];
		int i=0;
		while (i<no.length)
		{
			no[i]=a.nextInt();
			i++;
		}
		int h=no[0];
		i=1;
		while(i<no.length)
		{
			if(no[i]>h)
			{
			h=no[i];
			}
			i++;
		}
		int l=no[0];
		i=1;
		while(i<no.length)
		{
			if(no[i]<l)
			{
			l=no[i];
			}
			i++;
		}
		System.out.println(l);
		System.out.println(h);
	}
}