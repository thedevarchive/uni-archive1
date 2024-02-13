import java.util.*; 
public class glhf
{
    public static int find7(int[] n)
    {
        int sevens = 0; 
        for(int i = 0; i < n.length; i++)
        {
            if(n[i] == 7)
            {
                sevens++; 
            }
        }
        return sevens; 
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] nums = new int[size];
        for(int i = 0; i < size; i++)
        {
            nums[i] = sc.nextInt();
        }
        System.out.println(find7(nums));
    }
}