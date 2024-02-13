import java.util.*; 
public class NerdSqr
{
    public static void main(String args[])
    {
        Scanner cell = new Scanner(System.in);
        int size = 4; 
        int[][] square = new int[size][size];
        for(int y = 0; y < size; y++)
        {
            for(int x = 0; x < size; x++)
            {
                square[y][x] = cell.nextInt();
            }
        }

        int row = 0, row1 = 0, row2 = 0, row3 = 0, col = 0, col1 = 0, col2 = 0, col3 = 0, dia1 = 0, dia2 = 0; 
        for(int y = 0; y < size; y++)
        {
            for(int x = 0; x < size; x++)
            {
                switch(y)
                {
                    case 0: 
                        row += square[y][x];
                        break; 
                    case 1: 
                        row1 += square[y][x];
                        break; 
                    case 2: 
                        row2 += square[y][x];
                        break; 
                    case 3: 
                        row3 += square[y][x];
                        break; 
                }
            }
        }
        for(int x = 0; x < size; x++)
        {
            for(int y = 0; y < size; y++)
            {
                switch(y)
                {
                    case 0: 
                        col += square[y][x];
                        break; 
                    case 1: 
                        col1 += square[y][x];
                        break; 
                    case 2: 
                        col2 += square[y][x];
                        break; 
                    case 3: 
                        col3 += square[y][x];
                        break; 
                }
            }
        }
        for(int i = 0; i < size; i++)
        {
            dia1 += square[i][i];
        }
        for(int i = 0; i < size; i++)
        {
            dia2 += square[i][size - 1 - i];
        }
        if(row == 34 && row1 == 34 && row2 == 34 && row3 == 34 && col == 34 && col1 == 34 && col2 == 34 && col3 == 34 && dia1 == 34 && dia2 == 34)
        {
            System.out.println("YES");
        }
        else
        {
            System.out.println("NO");
        }
    }
}