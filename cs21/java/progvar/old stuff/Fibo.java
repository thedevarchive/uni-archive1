
import java.util.*;
public class Fibo
{
	public static void main(String args[])
	{
		Scanner number=new Scanner(System.in);
		int n=number.nextInt();
		int z=0; //counter for second while
		
		while (z<n)
	
	{
			int f=0; //base for fibo
			int adder=1;
			int c=0; //counter for first
			int temp=0;
			int x=number.nextInt();
			int[] sequence=new int[x];
			while (c<sequence.length)
			{
				temp=f+adder;
				sequence[c]=f;
				f=adder; //1, 1, 2, 3, 5, ...
				adder=temp; //1, 2, 3, 5, 8, ...

				c++;
			}
			System.out.println(sequence[c-1]+sequence[c-2]);
			z++;
		}
	}
}