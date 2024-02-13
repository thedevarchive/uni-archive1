import java.util.*;
public class PRZFindr
{
	public static void main (String[] args)
	{
		System.out.println("Enter the polynomial's last term coefficient.");
		Scanner B = new Scanner (System.in);
		int p = B.nextInt();
		int k = 1;
		int arraySyz = 0;
		int factr;
		while (k <= p)
		{
			factr = p % k;
			if (factr == 0)
			{
				arraySyz++;
			}
			k++;
		}
		int storageA = arraySyz * 2;
		int[] pFactrs = new int [storageA];
		k = 1;
		int keepr = 0;
		while (k <= p)
		{
			factr = p % k;
			if (factr == 0)
			{
				pFactrs[keepr] = k;
				keepr++;
				pFactrs[keepr] = k * -1;
				keepr++;
			}
			k++;
		}
		System.out.println("Enter the polynomial's first term coefficient.");
		Scanner F = new Scanner (System.in);
		int q = F.nextInt();
		k = 1;
		arraySyz = 0;
		while (k <= q)
		{
			factr = q % k;
			if (factr == 0)
			{
				arraySyz++;
			}
			k++;
		}
		int storageB = arraySyz * 2;
		int[] qFactrs = new int [storageB];
		k = 1;
		keepr = 0;
		while (k <= q)
		{
			factr = q % k;
			if (factr == 0)
			{
				qFactrs[keepr] = k;
				keepr++;
				qFactrs[keepr] = k * -1;
				keepr++;
			}
			k++;
		}
		keepr = 0;
		System.out.print("p: ");
		while (keepr < storageA)
		{
			System.out.print(pFactrs[keepr] + " ");
			keepr++;
		}
		System.out.println("");
		System.out.println("");
		keepr = 0;
		System.out.print("q: ");
		while (keepr < storageB)
		{
			System.out.print(qFactrs[keepr] + " ");
			keepr++;
		}
		System.out.println("");
		System.out.println("");
		keepr = 0;
		int j = 0;
		arraySyz = 0;
		while (j < storageB)
		{
			while (keepr < storageA)
			{
				int PRZ = pFactrs[keepr] % qFactrs[j];
				if (PRZ == 0)
				{
					System.out.print(pFactrs[keepr] / qFactrs[j]);
				}
				else
				{
					System.out.print(pFactrs[keepr] + "/" + qFactrs[j]);
				}
				keepr++;
			}
			j += 2;
			keepr = 0;
		}
		
	}
}