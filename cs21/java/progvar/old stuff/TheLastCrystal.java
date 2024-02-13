import java.util.*;
public class TheLastCrystal
{
	public static void main (String args[])
	{
		Scanner sc=new Scanner(System.in);
		double windX=sc.nextDouble();
		double windY=sc.nextDouble();
		double waterX=sc.nextDouble();
		double waterY=sc.nextDouble();
		double fireX=sc.nextDouble();
		double fireY=sc.nextDouble();
		double earthX=sc.nextDouble();
		double earthY=sc.nextDouble();
		int n=sc.nextInt();
		int i=0;
		while (n>i)
		{
			String ele=sc.next();
			String ment=sc.next();
			if ((ele.equals("wind") && ment.equals("fire"))||(ele.equals("fire") && ment.equals("wind")))
			{
				double d=windX-fireX;
				double e=windY-fireY;
				double f=Math.pow(d, 2);
				double g=Math.pow(e, 2);
				double h=f+g;
				double j=Math.sqrt(h);
				System.out.printf("%.2f\n", j);
			}
			else if ((ele.equals("fire") && ment.equals("earth"))||(ele.equals("earth") && ment.equals("fire")))
			{
				double k=fireX-earthX;
				double l=fireY-earthY;
				double m=Math.pow(k, 2);
				double o=Math.pow(l, 2);
				double p=m+o;
				double q=Math.sqrt(p);
				System.out.printf("%.2f\n", q);
			}
			else if ((ele.equals("fire") && ment.equals("water"))||(ele.equals("water") && ment.equals("fire")))
			{
				double r=fireX-waterX;
				double s=fireY-waterY;
				double t=Math.pow(r, 2);
				double u=Math.pow(s, 2);
				double v=t+u;
				double w=Math.sqrt(v);
				System.out.printf("%.2f\n", w);
			}
			else if ((ele.equals("earth") && ment.equals("water"))||(ele.equals("water") && ment.equals("earth")))
			{
				double x=earthX-waterX;
				double y=earthY-waterY;
				double z=Math.pow(x, 2);
				double a=Math.pow(y, 2);
				double b=z+a;
				double c=Math.sqrt(b);
				System.out.printf("%.2f\n", c);
			}
			else if ((ele.equals("earth") && ment.equals("wind"))||(ele.equals("wind") && ment.equals("earth")))
			{
				double D=earthX-windX;
				double E=earthY-windY;
				double F=Math.pow(D, 2);
				double G=Math.pow(E, 2);
				double H=F+G;
				double J=Math.sqrt(H);
				System.out.printf("%.2f\n", J);
			}
			else if ((ele.equals("wind") && ment.equals("water"))||(ele.equals("water") && ment.equals("wind")))
			{
				double K=waterX-windX;
				double L=waterY-windY;
				double M=Math.pow(K, 2);
				double O=Math.pow(L, 2);
				double P=M+O;
				double Q=Math.sqrt(P);
				System.out.printf("%.2f\n", Q);
			}
		i++;
		}
	}
}