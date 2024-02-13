import java.util.Scanner; 
public class CS110_lab11_Ngo
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in); 

        //cases have to be counted and printed
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
            arr = arrSort(arr, 0, size); 

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

    //the method that will rearrange the values in increasing order 
    public static int[] arrSort(int[] s, int a, int b)
    {
        //if the array or sub-array's length is 1 or 0, return the array
        if(b - a == 0 || b - a == 1) return s; 
        //if not, start reordering the array if a, the minimum left value, is less than b, the maximum right value 
        if(a < b)
        {
            //p takes the pivot number (at the last index of the array)
            int p = s[b - 1]; 
            //l is the left incrementer
            int l = a; 
            //r is the right decrementer (one less than the pivot index)
            int r = b - 2; 
            //while loop checks which numbers are below or above the pivot
            //numbers below the pivot number are moved to one half of the array 
            //numbers above are placed on the other half
            //if the elements in s[l] and s[r] both not in the proper half of the array, they would be switched
            while(l <= r)
            {
                while (l <= r && s[l] <= p)
                {
                    l += 1; 
                }
                while (r >= l && s[r] >= p)
                {
                    r -= 1; 
                }
                if(l < r)
                {
                    int temp = s[l]; 
                    s[l] = s[r]; 
                    s[r] = temp; 
                }
            }

            //swap the pivot with the current l value
            int temp = p; 
            s[b - 1] = s[l]; 
            s[l] = temp; 

            //divide the work into sub-arrays 
            arrSort(s, a, l); 
            arrSort(s, l + 1, b); 
        }
        return s; 
    }
}