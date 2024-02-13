import java.util.Scanner;

public class CS110_lab14_ngo_qui {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int count=1; // test case tracker

        while(in.hasNextInt()) {
            int size=in.nextInt(); // input size
            int[] A=new int[size]; // instantiate array
            for (int i=0;i<size;++i) {
                A[i]=in.nextInt(); // input array elements
            }
            solve(count,A,size); // call solve method
            ++count; // increment for next test case
        }
    }

    // method that sorts the array, and prints the test case number followed by the sorted list
    public static void solve(int caseNum, int[] A, int n) {
        radix_sort(A,n); // sort
        System.out.printf("Test case #%d:\n",caseNum); // print out test case number, then line break
        for (int i=0;i<n;++i) {
            System.out.println(A[i]); // print out list sequentially
        }
        System.out.println(""); // line break per test case
    }

    public static void radix_sort(int[] A, int n) {
        int max=getMax(A); // get the largest digit to identify number of digits
        int[] output=new int[n]; // container for sorted elements
        int[] bucket=new int[10]; // serves as the bucket of digits

        for (int exp=1;max/exp>0;exp*=10) {
            for (int i=0;i<10;++i) { // initialize bucket array
                bucket[i]=0;
            }

            for (int i=0;i<n;++i) {
                ++bucket[(A[i]/exp)%10]; // bucket items based on the nth digit
            }

            for (int i=1;i<10;++i) {
                bucket[i]+=bucket[i-1]; // change position of the counts so that the index maps with the arrangement of output
            }

            for (int i=n-1;i>=0;--i) {
                output[bucket[(A[i]/exp)%10]-1]=A[i]; // build the output array
                --bucket[(A[i]/exp)%10];
            }

            for (int i=0;i<n;++i) {
                A[i]=output[i]; // sort the A array based on output
            }
        }
    }

    // method that returns the max element in the array
    public static int getMax(int[] A) {
        int max=A[0];
        for (int i=0;i<A.length;++i) {
            if (A[i]>max) {
                max=A[i];
            }
        }
        return max;
    }
}
