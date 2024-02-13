import java.util.Scanner; 
public class Main
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in); 
        int cases = sc.nextInt(); 
        for(int i = 0; i < cases; i++)
        {
            if(i != 0) System.out.println(); 

            int strlen = sc.nextInt(); 
            int rows = sc.nextInt(); 
            String[] dsets = new String[rows]; 
            sc.nextLine(); 
            for(int j = 0; j < rows; j++)
            {
                dsets[j] = sc.nextLine(); 
            }

            sort1(dsets, strlen, rows); 
        }
    }

    public static void sort1(String[] s, int sl, int r)
    {
        String[] sorted = new String[r]; 
        int[] unsort = new int[r]; 
        /* for(int i = 0; i < r; i++)
        {
            sorted[i] = s[i];
        } */
        for(int i = 0; i < r; i++)
        {
            int count = 0; 
            char[] cArr = s[i].toCharArray(); 
            for(int j = sl; j >= 1; j--)
            {
                for(int k = 0; k < j - 1; k++)
                {
                    if(cArr[k] > cArr[k + 1])
                    {
                        char temp = cArr[k]; 
                        cArr[k] = cArr[k + 1];
                        cArr[k + 1] = temp;  
                        count++; 
                    }
                }
            }
            sorted[i] = new String(cArr); 
            unsort[i] = count; 
        }
        sort2(s, unsort, r); 
    }

    public static void sort2(String[] s, int[] u, int r)
    {
        for(int i = 1; i < r; i++)
        {
            int temp = u[i]; 
            String tempStr = s[i]; 
            int j = i - 1; 
            while(j >= 0 && u[j] > temp)
            {
                u[j + 1] = u[j]; 
                s[j + 1] = s[j]; 
                j -= 1; 
            }
            u[j + 1] = temp; 
            s[j + 1] = tempStr; 
        }
        for(int i = 0; i < r; i++)
        {
            System.out.println(s[i]); 
        }
    }
}