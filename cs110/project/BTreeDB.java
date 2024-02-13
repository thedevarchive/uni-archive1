import java.util.Scanner;
import java.io.RandomAccessFile;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;

public class BTreeDB 
{
    //command list
    public static final String IN = "insert"; 
    public static final String PICK = "select"; 
    public static final String UP = "update"; 
    public static final String QUIT = "exit"; 
    public static final String ERR = "ERROR: "; 

    //create the objects needed
    public static ValuesManager vm; 
    public static BTreeManager btm; 

    //other final vars
    public static final int NUMFORM = 10; 

    public static void main(String args[]) throws FileNotFoundException, IOException
    {
        //initialize
        Scanner sc = new Scanner(System.in); 

        btm = new BTreeManager(args[0]); 
        vm = new ValuesManager(args[1]);

        //get user input
        String command = sc.nextLine();  

        //used a while(true) here in order to accept both user input and .txt input
        //buggy when while(command.equals(QUIT)) was used
        while(true)
        {
            //break loop when user types quit keyword
            if(command.equals(QUIT)) break; 

            //split string when quit keyword is not typed 
            String[] spl = command.split(" "); 

            //try-catch loop for the commands
            //each method accesses random access files which is why it is in the try-catch loop
            //if none of the commands match, display error
            try
            {
                //string s2 contains data to be written to the key
                //blank strings are also accepted inputs to be written 
                String s2 = ""; 
                if(spl.length >= 3)
                {
                    for(int i = 2; i < spl.length; i++) 
                    {
                        s2 += spl[i]; 
                        if(i != spl.length - 1) s2 += " "; 
                    }
                }

                if(spl[0].equals(IN))
                {
                    insert(spl[1], s2); 
                }
                else if(spl[0].equals(PICK))
                {
                    if(!s2.equals("")) throw new Exception(); 
                    select(spl[1]); 
                }
                else if(spl[0].equals(UP))
                {
                    update(spl[1], s2); 
                }
                else throw new Exception(); 

            }
            catch(Exception ex)
            {
                System.out.println(ERR + "invalid command."); 
            }
            command = sc.nextLine();
        }

        //close random access files once done
        try {
            vm.close(); 
        }
        catch(Exception ex)
        {
        }
    }

    //note that the succeeding methods reads the long as a string
    //inside each method, the string is converted to long
    //learned how to convert string to long here
    //https://stackoverflow.com/questions/7693324/ddg#7693344

    //add string s to the database, if the key is not in the database
    public static void insert(String lo, String s) throws IOException
    {
        long l = Long.parseLong(lo, NUMFORM); 
        if(btm.hasKey(l)) System.out.println(ERR + lo + " already exists."); 
        else
        {
            long val = vm.insert(s); 
            btm.insert(l, val); 
        }
        
    }

    //display string in indicated key
    //if no key exists in the b tree, an error message is printed out instead. 
    public static void select(String lo) throws IOException
    {
        long l = btm.getOffsetValue(Long.parseLong(lo, NUMFORM)); 
        if(l == btm.NULLONG) System.out.println(ERR + lo + " does not exist."); 
        else 
        {
            String s = vm.getVal(l); 
            System.out.println(lo + " => " + s); 
        }
    }

    //change the string in the indicated key
    //if no such key exists, an error message is displayed instead. 
    public static void update(String lo, String s) throws IOException
    {
        long l = btm.getOffsetValue(Long.parseLong(lo, NUMFORM)); 
        if(l == btm.NULLONG) System.out.println(ERR + lo + " does not exist."); 
        else 
        {
            vm.update(l, s); 
            System.out.println(lo + " updated."); 
        }
    }
}