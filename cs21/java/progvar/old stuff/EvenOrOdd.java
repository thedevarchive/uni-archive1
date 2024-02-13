import java.util.*;
public class EvenOrOdd
{public static void main(String args[])
{Scanner shutup=new Scanner(System.in);
int N=1;
int howmany=shutup.nextInt();
while(N<=howmany)
{
	int a=shutup.nextInt();
	int s=shutup.nextInt();
	System.out.print(a+s);
	if ((a+s)%2==0)
	{System.out.println(" EVEN");}
	else
	{System.out.println(" ODD");}
	
	N=N+1;
}

}
}