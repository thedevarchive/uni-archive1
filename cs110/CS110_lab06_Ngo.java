import java.util.Scanner; 

public class CS110_lab06_Ngo
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int cases = sc.nextInt();
		
		for(int i = 0; i < cases; i++)
		{
			int nums = sc.nextInt();
			int[] arr = new int[nums];
			for(int j = 0; j < nums; j++)
			{
				arr[j] = sc.nextInt();
			}
			solve(i, arr);
		}
	}
	public static void solve(int currCase, int[] x)
	{
		int min = -1;
		int min2 = -1;
		int len = x.length; 
		currCase += 1; 
		int[] repeats = new int[len];
		for(int j = 0; j < len; j++)
		{
			for(int k = 0; k < len; k++)
			{
				if(x[j] == x[k])
				{
					repeats[j]++;
				}
			}
		}


		for (int j = 0; j < len; j++)
		{
			for(int k = j + 1; k < len; k++)
			{
				if(x[j] == x[k])
				{
					x[j] = -1; 
				}
			}
		}
		for(int j = 0; j < len; j++){
			if ((min > x[j] && x[j] > min2 || min == -1) && repeats[j] > 1 && x[j] != 1) 
			{
				min2 = min; 
				min = x[j];
				
			}
			else if (((min < x[j] && x[j] < min2) || min2 == -1) && repeats[j] > 1 && x[j] != 1)
			{
				min2 = x[j];
			}
		}

		System.out.println("Test Case #" + currCase + ": " + min2);
	}
}