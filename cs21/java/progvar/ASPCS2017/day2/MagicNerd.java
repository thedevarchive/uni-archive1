import java.util.*; 

public class MagicNerd
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int start = sc.nextInt();
        int end = sc.nextInt();
        System.out.println("The magical numbers are");
        for(int i = start; i <= end; i++)
        {
            int mOne = start - 1; 
            int mTwo = start - 2; 
            while(mOne <= i && i == mOne * mOne - mTwo * mTwo)
            {
                System.out.println(i);
            }

                mOne++; 
                mTwo++; 
        }
    }
}