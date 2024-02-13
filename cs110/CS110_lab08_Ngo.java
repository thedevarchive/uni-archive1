import java.util.Scanner; 

public class CS110_lab08_Ngo
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in); 
        int cases = 1; 
        runProg(sc, cases); 
    }

    public static void runProg(Scanner scn, int c)
    {
        if(scn.hasNext())
        {
            //I learned about replaceAll here: 
            //https://stackoverflow.com/questions/11149759/remove-all-non-alphabetic-characters-from-a-string-array-in-java
            String str = scn.nextLine(); 
            str = str.replaceAll("[^a-zA-Z]", "");
            str = str.toLowerCase(); 
            int charTr = 0; 
            int strLen = str.length() - 1; 
            pal(str, c, charTr, strLen); 
            runProg(scn, c + 1); 
        }
    }

    public static void pal(String s, int i, int begin, int end)
    {
        if(s.length() == 0 || s.length() == 1) System.out.println("Test case #" + i + ": YES"); 
        else if(s.charAt(begin) == s.charAt(end))
        {
            if(begin == end || end - begin == 1) System.out.println("Test case #" + i + ": YES");
            else pal(s, i, begin + 1, end - 1); 
        }
        else System.out.println("Test case #" + i + ": NO"); 
    }
}