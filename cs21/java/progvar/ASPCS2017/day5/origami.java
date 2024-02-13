import java.util.*; 
public class origami
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[][] paper = new int[size][size];
        int count = 1; 
        int dec, inc = 0; 
        boolean sym = true; 
        for(int x = 0; x < size; x++)
        {
            for(int y = 0; y < size; y++)
            {
                paper[x][y] = sc.nextInt();
            }
        }
        for(int x = 0; x < size; x++)
        {
            for(int y = 0; y < size; y++)
            {
                if(paper[x][y] != paper[y][x])
                {
                    sym = false; 
                }
            }
        }
        if(sym)
        {
            System.out.println("Yes");
        }
        else
        {
            System.out.println("No");
        }
    }
}