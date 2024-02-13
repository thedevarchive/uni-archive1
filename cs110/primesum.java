//taken from https://stackoverflow.com/a/29816128

public class primesum
{
    public static final int BIG = 5000000; 

    public static void main(String args[])
    {
        long sum = 0; 
        boolean[] isPrimes = new boolean[BIG]; 
        for(int i = 0; i < BIG; i++) isPrimes[i] = true; 

        for(int i = 2; i <= (int) Math.sqrt(BIG); i++) 
            if(isPrimes[i]) 
                for (int j = 2; j*i < BIG; j++) isPrimes[i*j] = false;
        
        for(int i = 2; i < BIG; i++) if(isPrimes[i]) sum += i;

        System.out.println(sum); 
    }

}