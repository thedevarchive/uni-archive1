import java.util.*; 

public class xsnos
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        String[] rows = new String[3];
        for(int i = 0; i < rows.length; i++)
        {
            rows[i] = sc.next();
        }
        boolean xWin = false; 
        boolean oWin = false; 
        for(int i = 0; i < rows.length; i++)
        {
            if(rows[i].charAt(0) == rows[i].charAt(1) && rows[i].charAt(1) == rows[i].charAt(2))
            {
                if(rows[i].charAt(0) == 'X')
                {
                    xWin = true; 
                }
                else if(rows[i].charAt(0) == 'O')
                {
                    oWin = true; 
                }
            } 
        }
        for(int i = 0; i < rows.length; i++)
        {
            if(rows[0].charAt(i) == rows[1].charAt(i) && rows[1].charAt(i) == rows[2].charAt(i))
            {
                if(rows[i].charAt(0) == 'X')
                {
                    xWin = true; 
                }
                else if(rows[i].charAt(0) == 'O')
                {
                    oWin = true; 
                }
            }
        }
        if(rows[0].charAt(0) == rows[1].charAt(1) && rows[1].charAt(1) == rows[2].charAt(2))
            {
                if(rows[0].charAt(0) == 'X')
                {
                    xWin = true; 
                }
                else if(rows[0].charAt(0) == 'O')
                {
                    oWin = true; 
                }
            }
        if(rows[0].charAt(2) == rows[1].charAt(1) && rows[1].charAt(1) == rows[2].charAt(0))
            {
                if(rows[2].charAt(0) == 'X')
                {
                    xWin = true; 
                }
                else if(rows[2].charAt(0) == 'O')
                {
                    oWin = true; 
                }
            }
        if(xWin) System.out.println("X wins."); 
        else if(oWin) System.out.println("O wins.");
        else System.out.println("Draw.");
    }
}