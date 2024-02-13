import java.util.*; 
public class SideScrolling
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int grid = sc.nextInt();
        int scroll = sc.nextInt();
        int[] map = new int[grid];
        int[] newMap = new int[grid];
        int[] pan = new int[scroll];
        int inc = scroll - 1; 
        for(int i = 0; i < grid; i++)
        {
            map[i] = sc.nextInt();
        }
        for(int i = grid - 1; i >= grid - scroll; i--)
        {
            if(inc >= 0)
            {
                pan[inc] = map[i];
                inc--; 
            }
        }
        inc = 0; 
        int inc2 = 0; 
        for(int i = 0; i < grid; i++)
        {
            if(inc < scroll)
            {
                newMap[i] = pan[inc]; 
                inc++; 
            }
            else if(inc2 < grid - scroll)
            {
                newMap[i] = map[inc2];
                inc2++; 
            }
            System.out.println(newMap[i]);
        }
    }
}