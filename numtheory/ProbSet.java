public class ProbSet
{
    public static void main(String args[])
    {
        long mod = 100000000; //last 8 digits
        long ans = 0, temp; 
        //int pow; 
        for(int i = 1; i <= 1000; i++)
        {
            //pow = 1; 
            temp = 1; 
            for(int j = 1; j <= i; j++)
            {
                temp = (temp * i) % mod; 
            }
            ans = (ans + temp) % mod; 
        }
        System.out.println(ans); 
    }
}