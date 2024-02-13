import java.util.*;
public class Aliens
{public static void main(String args[])
{Scanner nn=new Scanner(System.in);
int N=1;
int howmany=nn.nextInt();
while(N<=howmany)
{
	int CAP=nn.nextInt();
	int WT=nn.nextInt();
	if (WT<(CAP/2))
	{System.out.println("MORE PEWPEW, LESS QQ!");}
	else if ((CAP/2)<=WT && WT<CAP)
	{System.out.println("ADD A BIT MORE, ALMOST THERE.");}
	else if (WT==CAP)
	{System.out.println("STAHP, PLES!");} //gab c is that you? gab ples
	else if (WT>CAP)
	{System.out.println("You are overburdened. Huy.");}
	N=N+1;
}

}
}
//qq means crying
//i think
//Q_Q
//also, too many memes here

