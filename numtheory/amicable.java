public class amicable
{
    public static void main(String args[])
    {
        int num = 1000000;  
        solve(num); 

        //int s = 284; 
        //System.out.println(sumOfDiv(s)); 

    }

    public static void solve(int lim)
    {
        int num1, num2; 
        for(num1 = 1; num1 < lim; num1++)
        {
            num2 = sumOfDiv(num1); 
            //System.out.println(num1 + " " + num2); 
            if(num2 > num1 && sumOfDiv(num2) == num1 && num2 < lim) System.out.println("(" + num1 + " " + num2 + ")"); 
        }
    }

    public static int sumOfDiv(int num)
    {
        int divSum = 1; 
        //int temp = num; 
        
        for(int i = 2; i <= Math.sqrt(num); i++)
        {
            if(num % i == 0) 
            {
                divSum += i; 
                if(num / i != i) divSum += num / i; 
            }
        }
        if(Math.sqrt(num) % 1 == 0) divSum -= Math.sqrt(num); 

        /*for(int i = 2; i <= num / 2; i++)
        {
            if(i % 2 == 0 && i != 2) continue; 
            int p = 1; 
            while(temp % i == 0)
            {
                p *= i; 
                temp /= i; 
            }

            if(p != 1) divSum *= ((p * i - 1) / (i - 1)); 

            //System.out.println(divSum); 
            //System.out.println(i); 

            if (temp == 0) break; 
        }

        divSum -= num; */

        return divSum; 
    }
}