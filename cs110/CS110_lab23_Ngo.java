import java.util.Scanner;

public class CS110_lab23_Ngo
{
    public static int phase1c = 0; 
    public static int phase2c = 0; 
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in); 
        int cases = 1; 
        while(sc.hasNextInt())
        {
            if (cases != 1) System.out.println();

            //display current test case
            System.out.println("Test case #" + cases + ":"); 

            //get array size from user input
            int heapSize = sc.nextInt(); 
            //make the array
            int[] heap = new int[heapSize]; 

            //initialize array values while displaying the user-inputted values
            System.out.print("   Input array: "); 
            for(int i = 0; i < heapSize; i++) 
            {
                if(i == 0) System.out.print("("); 
                heap[i] = sc.nextInt(); 

                if(i == heapSize - 1) System.out.println(heap[i] + ")"); 
                else System.out.print(heap[i] + ", "); 
            }

            //do phase 1 
            for(int i = 0; i < heapSize; i++) phase1(heap, heapSize); 
            //get number of swap counts
            int p1 = phase1c; 
            phase1c = 0; phase2c = 0; 
            //do phase 2 
            phase2(heap); 
            int p2 = phase2c; 

            //print sorted array 
            System.out.print("   Sorted array: "); 
            for(int i = 0; i < heapSize; i++)
            {
                if(i == 0) System.out.print("("); 

                if(i == heapSize - 1) System.out.println(heap[i] + ")"); 
                else System.out.print(heap[i] + ", "); 
            }

            //print the swaps
            System.out.println("   Phase 1 total swaps: " + p1); 
            System.out.println("   Phase 2 total swaps: " + p2); 

            //update values for the next case
            //reset the phase counters and increment cases to reflect the next test case
            phase1c = 0; 
            phase2c = 0; 
            cases++; 
        }

    }

    //do phase 1 of heap sort (heapifying stage)
    public static void phase1(int[] h, int s)
    {
        for(int i = 0; i < s; i++)
        {
            if(getChild1(i) < s && h[i] < h[getChild1(i)])
            {
                swap(h, i, getChild1(i)); 
            }
            if(getChild2(i) < s && h[i] < h[getChild2(i)])
            {
                swap(h, i, getChild2(i)); 
            }
        }
    }

    //do phase 2 of heap sort (swap root with the lower nodes and reheapify)
    public static void phase2(int[] h)
    {
        for (int i=h.length-1; i>=1; i--) 
        { 

            swap(h, 0, i); 
            modphase1(h, i, 0); 
        } 

    }

    //phase 1 but recursive. 
    //phase 1 has to be modified to fit the traversal style for phase 2
    public static void modphase1(int[] h, int s, int n)
    {
        int max = n; 
        if(getChild1(n) < s && h[max] < h[getChild1(n)])
        {
            max = getChild1(n);  
        }
        if(getChild2(n) < s && h[max] < h[getChild2(n)])
        {
            max = getChild2(n); 
        }

        if(max != n)
        {
            swap(h, max, n); 
            modphase1(h, s, max); 
        }
    }

    //return left child of array index
    public static int getChild1(int n)
    {
        return 2 * n + 1; 
    }

    //return right child
    public static int getChild2(int n)
    {
        return 2 * n + 2; 
    }

    //swap the two elements in an array 
    public static void swap(int[] arr, int a, int b)
    {
        int temp = arr[a]; 
        arr[a] = arr[b]; 
        arr[b] = temp;
        phase1c++; 
        phase2c++; 
    }
}