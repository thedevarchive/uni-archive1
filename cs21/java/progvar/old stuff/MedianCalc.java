
import java.util.*;
public class MedianCalc
{
	public static void main(String args[])
	{
		Scanner med=new Scanner(System.in);
		int hm=med.nextInt();
		int z=0;
		int cas=1;
		while (z<hm)
		{
			int trials=med.nextInt();
			int c=0;
			double[] data=new double[trials];
			while (trials>c)
			{
				data[c]=med.nextDouble();
				c++;
			}
			Arrays.sort(data);
			if(data.length%2==0)
		
	{
				int even=data.length/2;
				int o=even-1;
				double y=data[o]+data[even];
				double a=y/2;
				System.out.print("Case "+cas+": ");
				System.out.printf("%.1f\n", a);
			}
			else if (data.length%2==1)
			{
				int mid=Math.round(data.length/2);
				double ans=data[mid];
				System.out.print("Case "+cas+": ");
				System.out.printf("%.1f\n", ans);
			}
			z++;
			cas++;
		}
	}
}