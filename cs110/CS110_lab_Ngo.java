import java.util.Scanner;
import java.util.Stack; 

public class CS110_lab_Ngo
{
    public static final String OPS = "+-*/"; 
    public static final String NIL = "ERROR"; 
    public static final String DELIM = " "; 

    public static final int ADD = 0; 
    public static final int SUB = 1; 
    public static final int MUL = 2; 
    public static final int DIV = 3; 
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in); 
        //while(sc.hasNext())
        //{
            String command = "1 2 + 3 * 4 -"; 
            calc(command);
        //}
    }

    public static void calc(String s)
    {
        Stack<Integer> stk = new Stack<Integer>();
        int answer = 0; 
        for(String str : s.split(DELIM))
        {
            char op = str.charAt(0); 
            if(isOper(op))
            {
                if(stk.size() <= 1) System.out.println(NIL); 
                else
                {
                    int top = stk.pop(); 
                    int tmin1 = stk.pop(); 

                    if(OPS.indexOf(op) == ADD) answer = tmin1 + top; 
                    else if (OPS.indexOf(op) == SUB) answer = tmin1 - top; 
                    else if (OPS.indexOf(op) == MUL) answer = tmin1 * top; 
                    else if(OPS.indexOf(op) == DIV) answer = tmin1 / top;
                    stk.push(answer); 
                }
            }
            else
            {
                stk.push(Integer.parseInt(str)); 
            }
        }
        System.out.println(stk.pop()); 
    }

    public static boolean isOper(char c)
    {
        return OPS.indexOf(c) >= 0;
    }
}