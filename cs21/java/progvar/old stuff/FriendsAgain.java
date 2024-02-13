import java.util.*;
public class FriendsAgain
{
	public static void main(String args[])
	{
		Scanner a=new Scanner(System.in);
		int f=a.nextInt();
		a.nextLine();
		String[] n=new String[f];
		int i=0;
		while(i<f)
		{
			n[i]=a.nextLine();
			i++;
		}
		i=1;
		while(i<f)
		{
			System.out.println(n[i]);
			i=i+2;
		}
		i=0;
		while (i<f)
		{
			System.out.println(n[i]);
			i=i+2;
		}
	}
}