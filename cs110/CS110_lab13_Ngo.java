import java.util.Scanner; 
public class Main
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in); 

        //cases have to be counted in order to keep track of the indices in the array
        int cases = 0; 
        //array is set to hold 10000 elements as number of inputs is specified to be less than this number
        int[] arr = new int[10000];

        while(sc.hasNextInt())
        {
            //input an integer to be added to the array
            arr[cases] = sc.nextInt(); 

            //rearrange the values in the array by initializing the array arr
            arr = arrSort(arr, cases); 

            System.out.println(median(arr, cases)); 
            //for(int i = 0; i < cases; i++) System.out.println(i + " " + arr[i]); 

            cases++; 
        }
    }

    //the method that will rearrange the values in increasing order 
    //makes use of insertion sort (minus the for-loop as the integers are added one by one)
    //thus, the array's average runtime would be O(n)
    public static int[] arrSort(int[] s, int b)
    {
        //if there is only one element, return the array without doing anything else
        if(b == 0) return s; 

        //if not, do insertion sort
        int temp = s[b]; 
        int j = b - 1; 
        while(j >= 0 && s[j] > temp)
        {
            s[j + 1] = s[j]; 
            j -= 1; 
        }
        s[j + 1] = temp; 
        return s; 
    }

    //median method finds the (rounded-down) median
    //1 is added to b (the current case) to simulate the current size of the array (or how many indices in the array have a non-garbage value)
    //if b's current length is 1, simply return the only elements
    //if b has a remainder of 1, return the middle element of the array
    //if b does not satisfy any of those conditions, return the average of the two middle elements
    //median formula has been slightly modified as the UVa judge's inputs consist of large numbers
    //and the program has to accomodate for such inputs
    //it also turns out that the formula is off by one when both large numbers have a remainder of 1
    //as a 1 would be lost when both numbers are rounded down after they are divided
    //so 1 will be added to the result after the median formula is calculated when both numbers have a remainder of 1
    public static int median(int[] s, int b)
    {
        b++; 
        if(b == 1)
        {
            return s[0]; 
        }
        else if(b % 2 == 1)
        {
            return s[b / 2]; 
        }
        else
        {
            if((s[(b / 2) - 1] % 2 == 1) && (s[b / 2] % 2 == 1)) return (s[(b / 2) - 1] / 2) + (s[b / 2] / 2) + 1; 
            else return (s[(b / 2) - 1] / 2) + (s[b / 2] / 2); 
        }
    }
}