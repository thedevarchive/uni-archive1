import java.util.Scanner; 
import java.util.Queue; 
import java.util.LinkedList;

public class Main
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in); 
        //read user input
        int n = sc.nextInt(); 
        //program terminates when user inputs 0 
        while(n != 0)
        {
            int m = 0; 
            //check for the smallest i that makes 13 the last int 
            for(int i = 1; i <= n; i++)
            {
                if(solve(n, i) == 13)
                {
                    //record smallest i to m then print it 
                    m = i; 
                    break; 
                }
            }
            System.out.println(m); 
            //ask for next input
            n = sc.nextInt(); 
        }
    }

    public static int solve(int a, int b)
    {
        Queue<Integer> q = new LinkedList<Integer>(); 
        //initialize values 1 to a in queue
        for(int i = 1; i <= a; i++) q.add(i); 
        //remove the first int and place the next b - 1 cards at the tail of the queue
        //until one int remains
        while(q.size() > 1)
        {
            q.remove(); 
            for(int i = 1; i < b; i++)
            {
                q.add(q.peek()); 
                q.remove(); 
            }
        }
        //return the remaining int in the queue
        return q.remove(); 
    }
}