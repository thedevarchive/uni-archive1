import java.util.Scanner; 
import java.util.Queue; 
import java.util.LinkedList;

public class Main
{
    //solution partially taken from here: 
    //https://github.com/AhmadElsagheer/UVa-Solutions/blob/master/v005/TeamQueue_UVa540.java
    //an array that contains a range of id numbers
    //stores the team number a certain id is in 
    public static int[] teamTag = new int[1000001]; 
    //a queue for the team numbers. determines the order of teams in the team queue
    public static Queue<Integer> q = new LinkedList<Integer>(); 
    //the team queue. 
    public static Queue<Integer>[] tq;
    //assigns the team number for each team
    public static int tn; 
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        //user inputs number of teams 
        int teams = sc.nextInt(); 
        //keep track of test cases (scenarios in this problem)
        int scens = 1; 
        //program ends when user inputs 0 as the number of teams
        while(teams != 0)
        {
            System.out.println("Scenario #" + scens); 
            scens++; 

            //clear team number assigner after one iteration is complete
            tn = 0; 
            //create team queue with the set number of teams
            tq = new LinkedList[teams]; 

            for(int i = 0; i < teams; i++)
            {
                //initialize a queue in tq for each team
                tq[i] = new LinkedList<Integer>();
                //set number of contestants (ids) in a team
                int n = sc.nextInt(); 
                int[] ppl = new int[n]; 
                //input the contestant ids
                for(int j = 0; j < n; j++) ppl[j] = sc.nextInt();
                //place array in the team queue
                addTeam(ppl); 
            }

            //scan through newline character
            sc.nextLine(); 
            //read user's command
            String c = sc.next(); 
            //user can stop entering any further command by typing STOP
            while(!c.equals("STOP"))
            {
                if(c.equals("ENQUEUE"))
                {
                    //when user types ENQUEUE, read the int succeeding it 
                    int id = sc.nextInt(); 
                    //add int to team queue
                    teamEnq(id); 
                }
                else if(c.equals("DEQUEUE"))
                {
                    //display the dequeued id
                    System.out.println(teamDeq());  
                }
                //skip newline
                sc.nextLine();
                //read next command
                c = sc.next(); 
            }
            //print newline after every iteration, even the last one. 
            //without it will result in presentation error
            System.out.println(); 
            //empty q after every iteration
            while (!q.isEmpty()) q.remove();
            //user is asked for another set of teams 
            teams = sc.nextInt(); 
        }
    }

    //assign each of the elements in the array to a team number
    public static void addTeam(int[] arr)
    {
        for(int i = 0; i < arr.length; i++) teamTag[arr[i]] = tn; 
        tn++; 
    }

    //add the team number to q, then add i to the team queue
    public static void teamEnq(int i)
    {
        //int t = teamTag[i]; 
        if(tq[teamTag[i]].size() == 0) q.add(teamTag[i]); 
        tq[teamTag[i]].add(i); 
    }

    //remove the id number at the front of the team queue
    //and remove the leading team number at the front of queue q, when no ids remain in that respective team queue
    public static int teamDeq()
    {
        int t = tq[q.peek()].remove(); 
        if(tq[q.peek()].size() == 0 || q.isEmpty()) q.remove(); 
        return t; 
    }
}