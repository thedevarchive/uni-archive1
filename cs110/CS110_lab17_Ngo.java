import java.util.Scanner; 
import java.util.Stack; 

public class Main
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in); 

        while(sc.hasNext())
        {
            //takes one line of the input
            String line = sc.nextLine(); 
            Scanner sc2 = new Scanner(line); 
            while(sc2.hasNext())
            {
                //read each word (or whitespace-separated characters) in the line
                line = sc2.next(); 
                //display the word in reverse
                reverse(line); 
                //print space after each word is reversed
                if(sc2.hasNext())System.out.print(" "); 
            }
            //print a newline character after the line's words have been individually reversed
            System.out.println(); 
        }
    }
    //reverse prints out the given word in reverse by pushing each character in the stack and then emptying the stack after. 
    //because a stack is last in first out, the last character will be popped first, the second last next, and so on, reversing the word
    public static void reverse(String w)
    {
        Stack<Character> stk = new Stack<Character>(); 
        for(char c : w.toCharArray()) stk.push(c); 
        for(char c : w.toCharArray()) System.out.println(stk.pop());  
    }
}