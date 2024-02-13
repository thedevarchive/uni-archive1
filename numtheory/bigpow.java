public class bigpow
{
    public static void main(String args[])
    {
        System.out.println(solve("7876243399761051643223455484457", 456, 11)); 
    }

    public static int bigmod(String n, int m)
    {
        int res = 0; 
        for(int i = 0; i < n.length(); i++)
        {
            res = res * 10 + Character.getNumericValue(n.charAt(i)); 
            res %= m; 
        }
        return res; 
    }

    public static int solve(String s, int y, int m)
    {
        int ans = bigmod(s, m); 
        int temp = ans; 

        for(int i = 1; i < y; i++)
            ans = (ans * temp) % m; 

        return ans; 
    }
}