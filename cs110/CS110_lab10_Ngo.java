
import java.util.*;  

class Main {         // UVA requires "Main" to be the class name for java submissions

	public static void main( String[] args ) {

		//read the test cases
		Scanner in = new Scanner( System.in );
		while (in.hasNext()) {
            //read the two integers to check which has the max cycle length 
			int n1 = in.nextInt();
			int n2 = in.nextInt();
			solve( n1, n2 );
		}
	}

	public static void solve( int n1, int n2 ) {
		
		int max = 1;

		//computes the max cycle length of all numbers between n1 and n2
		//by calling on the computeCycleLength method (below) within a for-loop
        //and then updating the variable max when necessary
        //UVa requires that n2 and n1 must be compared to see which is the maximum integer
        //or else the returned verdict is "Wrong Answer"
        if(n2 > n1)
            for (int i = n1; i <= n2; i++)
            {
                if(computeCycleLength(i) > max)
                {
                    max = computeCycleLength(i); 
                }
            }
        else
            for (int i = n2; i <= n1; i++)
            {
                if(computeCycleLength(i) > max)
                {
                    max = computeCycleLength(i); 
                }
            }

		// print the output to the console 
		System.out.printf( "%d %d %d\n", n1, n2, max );
	}

	public static int computeCycleLength( int n ) {

		int length = 1;
		// compute the cycle length of n as described in the UVA problem site
        if (n == 1) return length;
        if (n % 2 == 1) n = 3 * n + 1; 
        else n = n / 2;
        length += computeCycleLength(n); 
        return length; 
	}
}
