import java.util.*;
public class Gnidaer
{
	public static void main(String args[])
	{
		Scanner readr=new Scanner(System.in);
		String code=readr.nextLine();
		int i=code.length()-1;
		while (i>=0)
		{
			System.out.print(code.charAt(i));
			i--;
		}
	}	
}