import java.util.Scanner; 
import java.util.Stack; 

public class Main
{
    //final string that contains all possible numbers
    public static final String NUMS = "0123456789"; 
    //final string that contains the mathematical operations
    public static final String OPS = "+-*/";
    //final string that contains the opening grouping symbols 
    public static final String OPAREN = "("; 
    //final string that contains the closing grouping symbols
    public static final String CPAREN = ")"; 

    //the stack which serves as temporary storage for the operations
    public static Stack<Character> stk = new Stack<Character>();
    //the string which will display the postfix form of the given expression 
    //hence it is called pf, short for postfix
    public static String pf = ""; 
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in); 
        //takes in the number of infix equations that the user would input
        int cases = sc.nextInt(); 
        //input cursor skips two lines to avoid scanner error
        sc.nextLine(); sc.nextLine(); 
        for(int i = 0; i < cases; i++)
        {
            //print a newline after every new case (except the beginning one)
            if(i != 0) System.out.println(); 
            //takes user's input of each individual character in a given expression until the input is empty
            while(sc.hasNextLine())
            {
                String s = sc.nextLine(); 
                if(s == null || s.isEmpty()) break; 
                //characters will be identified in this function
                add2s(s.charAt(0));
            }
            //pop the remaining contents of the stack and print it
            showPostF(); 
            //reset pf 
            pf = ""; 
        }
    }
    //add2s can mean either of the following: add character to string (pf) or add character to stack
    //if the character is a number (part of final string OPER), it is automatically added to pf
    //if the character is an operation (part of the other remaining final strings), it is stored to the stack
    //if a lower priority operation were to be stored in the stack, and the top contains a higher priority operation, 
    //the higher priority operation is to be popped first. then, the lower priority operation gets stored in the stack
    //if the operation to be stored to the top of the stack has the same priority as the one at the top of the stack, 
    //the operation in the stack is popped and appended to the string, then the operation that would be stored to the top of stack will be stored to the top of stack
    //when a closing grouping symbol is detected, the operations that come after the open grouping symbol have to be popped 
    //note that the opening grouping symbol also has to be popped in order to avoid erroneously appending it to the string
    public static void add2s(char c)
    {
        if(isNum(c))
        {
            pf += c; 
        }
        else if(isOper(c) || isOpenP(c))
        {
            //grouping symbols have a priority of 0, but the grouping symbols override the priority order of the operations. 
            //thus, the if-statement has to also check whether the character is an open grouping symbol 
            //so that the open grouping symbol can be stored
            if(stk.isEmpty() || prior(c) > prior(stk.peek()) || isOpenP(c)) stk.push(c); 
            else if (prior(c) <= prior(stk.peek()))
            {
                while(!stk.isEmpty() && !isCloseP(stk.peek()) && prior(c) <= prior(stk.peek())) pf += stk.pop(); 
                stk.push(c); 
            }
        }
        else if(isCloseP(c))
        {
            char temp; 
            while(!stk.isEmpty() && !(isOpenP(temp = stk.pop()))) pf += temp; 
        }
    }
    //appends the remaining operations to string pf then prints pf 
    public static void showPostF()
    {
        while(!stk.isEmpty()) pf += stk.pop(); 
        System.out.println(pf); 
    }
    //checks if a character is a number (part of the NUMS string) and returns true if it is. otherwise, false is returned. 
    public static boolean isNum(char c)
    {
        return NUMS.indexOf(c) >= 0; 
    }
    //checks if a character is included in the operations indicated in OPERS, and returns true if it is. otherwise, false is returned.
    public static boolean isOper(char c)
    {
        return OPS.indexOf(c) >= 0; 
    }
    //checks if a character is an open grouping symbol indicated in OPAREN, and returns true if it is. otherwise, false is returned. 
    public static boolean isOpenP(char c)
    {
        return OPAREN.indexOf(c) >= 0; 
    }
    //checks if a character is a closing grouping symbol indicated in CPAREN, and returns true if it is. otherwise, false is returned. 
    public static boolean isCloseP(char c)
    {
        return CPAREN.indexOf(c) >= 0; 
    }
    //checks for the priority of the operations and returns an integer indicating their priority
    //the multiplication and division operators have a higher priority over the addition and subtraction (MDAS). 
    //thus, the former symbols get a higher priority value (2) over the addition and subtraction operators (1). 
    //all other characters have a priority of 0. thus, unrecognized operations/characters will not be placed in the stack.
    public static int prior(char op)
    {
        switch(op)
        {
            case '+':
            case '-': 
                return 1; 
            case '*': 
            case '/': 
                return 2; 
            default: 
                return 0; 
        }
    }
}
