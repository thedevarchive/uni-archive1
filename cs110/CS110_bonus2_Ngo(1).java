import java.util.Scanner; 
public class Main
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in); 
        //input cases
        int cases = sc.nextInt(); 
        for(int i = 0; i < cases; i++)
        {
            //print a newline after every printing a test case's output
            if(i != 0) System.out.println(); 

            //input the length of the datasets (or for all string inputs)
            int strlen = sc.nextInt(); 
            //input the number of datasets the user will input (the number of string inputs)
            int rows = sc.nextInt(); 
            //create an array for the datasets
            String[] dsets = new String[rows]; 
            //nextLine is required because nextInt only reads the integer, and not the newline after it
            //or else the for-loop would leave dsets[0] empty
            sc.nextLine(); 
            for(int j = 0; j < rows; j++)
            {
                dsets[j] = sc.nextLine(); 
            }

            sort1(dsets, strlen, rows); 
        }
    }

    //sort1 sorts the individual strings and counts each string's number of inversions
    public static void sort1(String[] s, int sl, int r)
    {
        //array for the sorted strings
        String[] sorted = new String[r]; 
        //keeps track of the "unsortedness" of strings by number of inversions
        //hence, the array is called unsort
        int[] unsort = new int[r]; 

        //loops through the strings 
        for(int i = 0; i < r; i++)
        {
            //counts the number of inversions of the current string
            int count = 0; 
            //converts the strings to an array of characters
            //strings are immutable, so they had to be converted to a char array to be able to make swaps within the characters
            char[] cArr = s[i].toCharArray(); 

            //bubble sort was used to count the inversions because bubble sort simulates how the number of inversions were counted
            for(int j = sl; j >= 1; j--)
            {
                for(int k = 0; k < j - 1; k++)
                {
                    if(cArr[k] > cArr[k + 1])
                    {
                        char temp = cArr[k]; 
                        cArr[k] = cArr[k + 1];
                        cArr[k + 1] = temp;  
                        count++; 
                    }
                }
            }
            //the rearranged char array will be turned back into a string, and is saved in the sorted array
            sorted[i] = new String(cArr); 
            //number of inversions will be saved in the unsort array, under the current string's respective index
            unsort[i] = count; 
        }
        sort2(s, unsort, r); 
    }

    //sort2 sorts the strings from "most sorted to least sorted" 
    //in other words, by the number of inversions by increasing order
    public static void sort2(String[] s, int[] u, int r)
    {
        //unlike sort2, sort1 uses insertion sort
        for(int i = 1; i < r; i++)
        {
            //while taking the current string's respective number of inversions to be "inserted" in the array, 
            //the string is stored in tempStr
            int temp = u[i]; 
            String tempStr = s[i]; 
            int j = i - 1; 
            while(j >= 0 && u[j] > temp)
            {
                //when swaps are made in the number of inversions, so do its respective strings
                u[j + 1] = u[j]; 
                s[j + 1] = s[j]; 
                j -= 1; 
            }
            //even when the number of inversions are finally placed in its destined location, so do the string in its array
            u[j + 1] = temp; 
            s[j + 1] = tempStr; 
        }
        //prints out each arranged string
        for(int i = 0; i < r; i++)
        {
            System.out.println(s[i]); 
        }
    }
}