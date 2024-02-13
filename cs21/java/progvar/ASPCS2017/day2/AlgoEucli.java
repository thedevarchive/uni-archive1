import java.util.*; 

public class AlgoEucli
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int greater, less, rem, quo; 
        if (a >= b)
        {
            greater = a; 
            less = b; 
        }
        else
        {
            greater = b; 
            less = a; 
        }
        rem = greater % less; //16
        quo = greater / less; //13
        while(rem != 0)
        {
            greater = less; 
            less = rem; 
            rem = greater % less; 
            quo = greater / less; 
        }
        System.out.println(less);
    }
}