import java.util.*; 
public class back2school
{
    public static int hmPres(String[] s, String[] p)
    {
        int count = 0;
        for(int x = 0; x < p.length; x++)
        {
            for(int y = 0; y < s.length; y++)
            {
                if(s[x].equals(p[y])) count++; 
            }
        }
        return count;
    }
    public static void main(String args[])
    {
        Scanner beadle = new Scanner(System.in);
        int cSize = beadle.nextInt();
        String[] students = new String[cSize];
        beadle.nextLine();
        for(int i = 0; i < cSize; i++)
        {
            students[i] = beadle.nextLine();
        }
        int m = beadle.nextInt();
        String[] present = new String[m];
        beadle.nextLine();
        for(int i = 0; i < m; i++)
        {
            present[i] = beadle.nextLine();
        }
        System.out.println(hmPres(students, present) + " of my students attended class.");
    }
}