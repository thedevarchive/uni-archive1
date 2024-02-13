import java.util.*;
public class RootCalc
{
	public static void main(String args[])
	{
		Scanner equation = new Scanner(System.in);
		double z = equation.nextDouble();
		double o = equation.nextDouble();
		double s = equation.nextDouble();
		
		double a = o * o - 4 * z * s;
		
		if (a > 0)
		{
			System.out.println("TWO REAL ROOTS");
		}
		if (a = 0)
		{
			System.out.println("ONE REAL ROOT");
		}
		if (a < 0)
		{
			System.out.println("NO REAL ROOT");
		}
	}
}