import java.util.Scanner; 
import java.util.Queue; 
import java.util.LinkedList;

public class Main
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in); 
        int n = sc.nextInt(); 
        while(n != 0)
        {
            int m = 0; 
            for(int i = 1; i <= n; i++)
            {
                if(solve(n, i) == 13)
                {
                    m = i; 
                    break; 
                }
            }
            System.out.println(m); 
            n = sc.nextInt(); 
        }
    }

    public static int solve(int a, int b)
    {
        Queue<Integer> q = new LinkedList<Integer>(); 
        for(int i = 1; i <= a; i++) q.add(i); 
        while(q.size() > 1)
        {
            q.remove(); 
            for(int i = 1; i < b; i++)
            {
                q.add(q.peek()); 
                q.remove(); 
            }
        }
        return q.remove(); 
    }
}