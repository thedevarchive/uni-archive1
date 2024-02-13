import java.util.*; 

public class ASPCLang
{
    public static void main(String args[])
    {
        Scanner cl = new Scanner(System.in);
        int commands = cl.nextInt();

        String[] history = new String[commands];
        int[] numDB = new int[commands];
        int out = 0; 
        int inc = 0; 
        int i = 0; 
        while(i < commands)
        {
            history[i] = cl.next();
            numDB[i] = cl.nextInt();
            if(history[i].equals("ADD"))
            {
                out += numDB[i];
                i++; 
            }
            else if(history[i].equals("SUBTRACT"))
            {
                out -= numDB[i];
                i++; 
            }
            else if(history[i].equals("DO"))
            {
                inc++; 
                int locate = numDB[i] - inc;  
                if(history[locate].equals("ADD"))
                {
                    out += numDB[locate];
                    i++; 
                }
                else if(history[locate].equals("SUBTRACT"))
                {
                    out -= numDB[locate];
                    i++; 
                }
                else if(history[locate].equals("DO"))
                {
                    inc++; 
                }
            }
        }
        System.out.println(out);
    }
}