import java.util.Scanner; 
public class CS110_lab12_Ngo
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in); 
        int cases = 1; 
        while(sc.hasNextInt())
        {
            //a newline has to be printed after every test case
            //newlines are printed after a case's output has been printed
            if (cases != 1) System.out.println(); 

            //input size of the array 
            int size = sc.nextInt(); 
            int[] arr = new int[size]; 

            //input values of the array 
            for (int i = 0; i < size; i++)
            {
                arr[i] = sc.nextInt(); 
            }

            //rearrange the values in the array by initializing the array arr
            arr = arrSort(arr, size); 

            System.out.println("Test case #" + cases + ": ");  

            //print the array 
            for(int i = 0; i < size; i++)
            {
                System.out.print(arr[i]);
                if(i == size - 1) System.out.println(); 
                else System.out.print(" ");
            }

            cases++; 
        }
    }
    //arrSort arranges the even numbers in ascending order, odd in descending order, without swapping odd nos.' indices with even nos.''
    // and vice versa
    public static int[] arrSort(int[] s, int len)
    { 
        //make an array for increasing and decreasing order
        int[] asc = new int[len]; 
        int[] desc = new int[len]; 
        //make a boolean array that checks whether a number is placed in that index or not
        boolean[] check = new boolean[len]; 
        //assign the first two arrays' values with the input arrays' elements
        //while the check[] array has all its values assigned to true 
        for(int i = 0; i < len; i++)
        {
            asc[i] = s[i]; 
            desc[i] = s[i]; 
            check[i] = true; 
        }
        //bubble sort was used to arrange the integers in ascending and descending order
        //asc[] array is sorted in ascending order, desc for descending
        for(int i = len; i >= 1; i--)
        {
            for(int j = 0; j < i - 1; j++)
            {
                if(asc[j] > asc[j + 1])
                {
                    int temp = asc[j]; 
                    asc[j] = asc[j + 1]; 
                    asc[j + 1] = temp; 
                }
            }
        } 
        for(int i = len; i >= 1; i--)
        {
            for(int j = 0; j < i - 1; j++)
            {
                if(desc[j] < desc[j + 1])
                {
                    int temp = desc[j]; 
                    desc[j] = desc[j + 1]; 
                    desc[j + 1] = temp; 
                }
            }
        } 
        //nested for-loop scans through array s for indices to place asc[]'s or desc[]'s current index's element
        //check[] checks whether that index is already filled in by another number to avoid redundancy 
        //check[j] would be set to false once s[j] is replaced 
        for(int i = 0; i < len; i++)
        {
            for(int j = 0; j < len; j++)
            {
                if((asc[i] % 2 == 0 && s[j] % 2 == 0) && check[j])
                {
                    s[j] = asc[i];
                    check[j] = false; 
                    break; 
                } 
            }
        }
        for(int i = len - 1; i >= 0; i--)
        {
            for(int j = len - 1; j >= 0; j--)
            {
                if((desc[i] % 2 == 1 && s[j] % 2 == 1) && check[j])
                {
                    s[j] = desc[i]; 
                    check[j] = false; 
                    break; 
                }
            }
        }
        //s is returned once the substitution is done
        return s; 
    }
}