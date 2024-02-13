import java.util.Scanner; 
public class Main
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in); 
        while(sc.hasNextInt())
        {
            //user inputs an integer that determines the length of the array 
            int len = sc.nextInt(); 
            //array is initialized
            int[] arr = new int[len]; 
            //user inputs the integers that are in the array 
            for(int i = 0; i < len; i++)
            {
                arr[i] = sc.nextInt(); 
            }
            minSort(arr);
        }
    }
    //minSort displays the minimum exchange operations
    //to be able to count the exchange operations, bubble sort was used to simulate them. 
    //each swap the bubble sort performs adds 1 to the counter
    public static void minSort(int[] a)
    {
        //replicate the array argument
        int[] b = new int[a.length]; 
        for(int i = 0; i < a.length; i++)
        {
            b[i] = a[i]; 
        } 
        //make two counters for each implementation of bubble sort
        //one for prioritizing moving the maximum to the right, and the other prioritizes bubbling down the minimum numbers
        int count1 = 0; 
        int count2 = 0; 
        for(int i = a.length; i >= 1; i--)
        {
            for(int j = 0; j < i - 1; j++)
            {
                if(a[j] > a[j + 1])
                {
                    int temp = a[j]; 
                    a[j] = a[j + 1]; 
                    a[j + 1] = temp; 
                    count1++; 
                }
            }
        }
        //the second implementation of bubble sort will rearrange the replicated array 
        for(int i = 0; i <= b.length - 2; i++)
        {
            for(int j = b.length - 1; j >= i + 1; j--)
            {
                if(b[j] < b[j - 1])
                {
                    int temp = b[j]; 
                    b[j] = b[j - 1]; 
                    b[j - 1] = temp; 
                    count2++; 
                }
            }
        }
        //whichever inplementation garners the minimum exchange operations (or swaps) will be printed out
        System.out.print("Minimum exchange operations : "); 
        if(count1 > count2) System.out.println(count2); 
        else System.out.println(count1); 
    }
}