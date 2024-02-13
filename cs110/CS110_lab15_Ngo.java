import java.util.Scanner; 

public class CS110_lab15_Ngo
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in); 
        //test cases have to be counted
        int count = 1; 

        while(sc.hasNextInt())
        {
            //two newlines have to be added to the end because the integers are displayed using print rather than println
            if(count != 1) System.out.println(""); 

            //user inputs the number of integers to be inputted
            int len = sc.nextInt(); 
            //this array stores the integers
            int[] ints = new int[len]; 
            //this array stores how many times the integers are to be repeated
            //hence, the array is named mult (from multiplicity)
            int[] mult = new int[len]; 
            //checks for positive numbers 
            boolean hasPos = false; 
            //checks for negative numbers
            boolean hasNeg = false; 

            for(int i = 0; i < len; i++)
            {
                //user lists the integers
                ints[i] = sc.nextInt(); 
                //user lists how many times the integer will be repeated
                mult[i] = sc.nextInt(); 

                //if one integer is a positive number, hasPos is changed to true
                //if one integer is a negative number, hasneg is changed to true
                if(ints[i] >= 0) hasPos = true;
                else hasNeg = true; 

            }

            //if the array consists of positive numbers only, perform the half bucket sort, return the sorted array (with repetitions applied), and print it in the format
            //if the array consists of only negative numbers, make the numbers positive, perform the half bucket sort, return the array and print it in the specified format
            //if the array has both, split the array between the positive and negative ints, place them in an array, perform the half buckeet sort on both arrays, 
            //merge and return the array, and print it in the specified format
            if(hasPos && !hasNeg)
            {
                int[] newarr = halfBuck(ints, mult); 
                int cols = sc.nextInt(); 
                int i = 0; 
                String longest = "" + newarr[0];  
                System.out.println("Test case #" + count + ":");
                while(i < newarr.length)
                {
                    for(int j = 1; j <= cols; j++)
                    {
                        String s = ""; 
                        //pad ints with spaces to prettify it (basically aligning the ones digit of each integer)
                        while(s.length() + Integer.toString(newarr[i]).length() <= longest.length())
                        {
                            s += " "; 
                        }
                        System.out.print(s + newarr[i]); 
                        i++; 
                        if(j == cols) System.out.println(); 
                        else System.out.print("\t"); 
                        if(i == newarr.length && j != cols) 
                        {
                            System.out.println(); 
                            break; 
                        }
                    }
                }
            }
            else if (hasPos && hasNeg)
            {
                int[] newarr = splitNums(ints, mult);
                int cols = sc.nextInt(); 
                int i = 0; 
                String longest = ""; 
                if(Integer.toString(newarr[0]).length() >= Integer.toString(newarr[newarr.length - 1]).length())
                {
                    longest = "" + newarr[0]; 
                }
                else if(Integer.toString(newarr[0]).length() < Integer.toString(newarr[newarr.length - 1]).length())
                {
                    longest = "" + newarr[newarr.length - 1];
                }
                System.out.println("Test case #" + count + ":");
                while(i < newarr.length)
                {
                    for(int j = 1; j <= cols; j++)
                    {
                        String s = ""; 
                        //pad ints with spaces to prettify it (basically aligning the ones digit of each integer)
                        while(s.length() + Integer.toString(newarr[i]).length() <= longest.length())
                        {
                            s += " "; 
                        }
                        System.out.print(s + newarr[i]); 
                        i++; 
                        if(j == cols) System.out.println(); 
                        else System.out.print("\t"); 
                        if(i == newarr.length && j != cols) 
                        {
                            System.out.println(); 
                            break; 
                        }
                    }
                }
            }
            else if (!hasPos && hasNeg)
            {
                for(int i = 0; i < len; i++)
                {
                    ints[i] *= -1; 
                }
                int[] newarr = halfBuck(ints, mult); 
                int cols = sc.nextInt(); 
                int i = newarr.length - 1; 
                String longest = "" + newarr[i];  
                System.out.println("Test case #" + count + ":");
                while(i >= 0)
                {
                    for(int j = 1; j <= cols; j++)
                    {
                        String s = ""; 
                        //pad ints with spaces to prettify it (basically aligning the ones digit of each integer)
                        while(s.length() + Integer.toString(newarr[i]).length() <= longest.length())
                        {
                            s += " "; 
                        }
                        System.out.print(s + (-1 * newarr[i])); 
                        i--; 
                        if(j == cols) System.out.println(); 
                        else System.out.print("\t");
                        if(i < 0 && j != cols) 
                        {
                            System.out.println(); 
                            break;
                        }
                    }
                }
            }

            count++; 
        }
    }

    //separates an array's positive and negative numbers
    public static int[] splitNums(int[] arr, int[] arr2)
    {
        //initialize the negative and positive counts (gets the length of the negative and positive numbers)
        int ns = 0; 
        int ps = 0; 
        // count negative and postive ints
        for(int i = 0; i < arr.length; i++)
        {
            if(arr[i] < 0) ns++; 
            else ps++; 
        }
        //initialize the arrays for each integers and their multiplicities
        int[] neg = new int[ns]; 
        int[] negm = new int[ns]; 
        int[] pos = new int[ps]; 
        int[] posm = new int[ps]; 
        //negative iterator
        int n = 0; 
        //gets total length of the negative array with repetition
        int ntot = 0; 
        //make negative integers positive
        for(int i = 0; i < arr.length; i++)
        {
            if(arr[i] < 0) 
            { 
                neg[n] = -1 * arr[i]; 
                negm[n] = arr2[i];  
                ntot += arr2[i]; 
                n++; 
            }
        }
        //positive num iterator
        int p = 0; 
        //gets the total length of the positive array with repetition
        int ptot = 0; 
        for(int i = 0; i < arr.length; i++)
        {
            if(arr[i] > 0) 
            { 
                pos[p] = arr[i]; 
                posm[p] = arr2[i]; 
                ptot += arr2[i]; 
                p++; 
            }
        }
        //call bucket sort
        int[] newneg = halfBuck(neg, negm); 
        int[] newpos = halfBuck(pos, posm); 
        //combined array iterator
        int l = 0; 
        //new array length with repetition
        int[] newlist = new int[ntot + ptot]; 
        //bring back the negative sign for the negative numbers and add the new element into the newlist
        for(int i = ntot - 1; i >= 0; i--)
        {
            newlist[l] = -1 * newneg[i]; 
            l++; 
        }
        //add back the positive sign
        for(int i = 0; i < ptot; i++)
        {
            newlist[l] = newpos[i]; 
            l++; 
        }
        return newlist; 
    }

    //modified bucket sort
    public static int[] halfBuck(int[] s, int[] t)
    {
        int m = max(s) + 1; 
        int[] b = new int[m]; 
        for(int i = 0; i < m; i++) 
        {
            b[i] = 0; 
        }
        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < s.length; j++)
            {
                if(i == s[j]) b[i] += t[j]; 
            }
        }
        int sum = 0; 
        for(int i = 0; i < t.length; i++)
        {
            sum += t[i]; 
        }
        int[] repeat = new int[sum]; 
        int x = 0; 
        for(int i = 0; i < m; i++)
        {
            for(int r = 1; r <= b[i]; r++)
            {
                repeat[x] = i; 
                x++; 
            }
        }

        return repeat; 
    }

    //get the maximum number
    public static int max(int[] a)
    {
        int max = a[0]; 
        for(int i = 0; i < a.length; i++)
        {
            if(a[i] > max) max = a[i]; 
        }
        return max; 
    }

}