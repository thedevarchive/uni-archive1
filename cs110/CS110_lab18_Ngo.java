import java.util.Scanner;
import java.util.Stack; 

public class CS110_lab18_Ngo
{
    //final string that contains the operations
    public static final String OPS = "+-*/^"; 
    //error string. returned when an invalid operation is performed
    public static final String NIL = "ERROR"; 

    //the "magic numbers" that represent each operation
    public static final int ADD = 0; 
    public static final int SUB = 1; 
    public static final int MUL = 2; 
    public static final int DIV = 3; 
    public static final int EXP = 4; 
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in); 
        while(sc.hasNext())
        {
            //input string of postfix equation to be performed 
            String command = sc.nextLine(); 
            //print the result
            System.out.println(calc(command));
        }
    }

    //calc calculates the postfix equation and returns a string containing the answer or the message contained in NIL
    //integers are stored and retrieved using a stack
    //if there are less than two integers remaining in the stack when attempting to perform an operation, the calculation is interrupted 
    //and the error message is returned
    //otherwise, return the answer
    public static String calc(String s)
    {
        Stack<Integer> stk = new Stack<Integer>();
        int answer = 0; 
        for(char c : s.toCharArray())
        {
            //check whether c is an operation or an integer
            if(isOper(c))
            {
                if(stk.size() <= 1) return NIL; 
                else
                {
                    //top = top of stack
                    //tmin1 = top of stack - 1 (the integer directly under top of stack)
                    //both named as such as postfix follows the zero-address memory instruction
                    //which also makes use of a stack to store data (CS 152A)

                    int top = stk.pop(); 
                    int tmin1 = stk.pop(); 

                    if(OPS.indexOf(c) == ADD) answer = tmin1 + top; 
                    else if (OPS.indexOf(c) == SUB) answer = tmin1 - top; 
                    else if (OPS.indexOf(c) == MUL) answer = tmin1 * top; 
                    else if(OPS.indexOf(c) == DIV) answer = tmin1 / top;
                    else if(OPS.indexOf(c) == EXP) answer = (int) Math.pow(tmin1, top);
                    stk.push(answer); 
                    
                }
            }
            else
            {
                String c2s = "" + c; 
                stk.push(Integer.parseInt(c2s)); 
            }
        }
        return "" + stk.pop();  
    }

    //check if the character is included in the set of operations listed in the final string OPER
    public static boolean isOper(char c)
    {
        return OPS.indexOf(c) >= 0;
    }
}