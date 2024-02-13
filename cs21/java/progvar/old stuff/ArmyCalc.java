import java.util.*;
public class ArmyCalc
{public static void main(String args[])
{Scanner nn=new Scanner(System.in);
int N=1;
int howmany=nn.nextInt();
while(N<=howmany)
{
	int a=nn.nextInt();
	int s=nn.nextInt();
	if (a-s>0)
	{System.out.println(a-s);}
	else
	{System.out.println(s-a);}
	
	N=N+1;
}

}
}