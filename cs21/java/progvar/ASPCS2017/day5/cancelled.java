import java.util.*; 
public class cancelled
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int tests = sc.nextInt();
        int[] rslts = new int[tests]; 
        int overall = 0, raw = 0, fin = 0, low = 111; 
        for(int i = 0; i < tests; i++)
        {
            rslts[i] = sc.nextInt();
            raw += rslts[i];
            overall += 10; 
            if(rslts[i] < low)
            {
                low = rslts[i]; 
            }
        }
        fin = raw - low; 
        System.out.println("Raw Score=" + raw + "/" + overall);
        System.out.println("Final Score=" + fin + "/" + (overall - 10));
    }
}