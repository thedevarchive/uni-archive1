import java.util.*; 

public class Lab09_Chua_Ngo 
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in); 

        int numCases = sc.nextInt(); 
        for(int i = 1; i <= numCases; i++)
        {
            //scanner must skip lines because the user skips lines after inputting number of test cases 
            //and to separate each case 
            sc.nextLine(); sc.nextLine(); 

            //read the contents of the dictionary
			String input = sc.nextLine();
            // use white space as delimiter to split words and put into array
			String[] dictionary = input.split(" ");  
			
			// read the target strings that will be searched for in the dictionary
			int numTargets = sc.nextInt();
			String[] arrTargets = new String[numTargets];
			for (int j = 0; j < numTargets; ++j) 
            {
				arrTargets[j] = sc.next();
			}
			
			//solve the problem instance
            solve(i, dictionary, arrTargets);
            //output requires separation of test cases as well 
            if(i != numCases) System.out.println(); 

        }
        sc.close(); 
    }

    //method calls the search() method to find each target word in array t
    public static void solve(int i, String[] s, String[] t)
    {
        for(int x = 0; x < t.length; x++)
        {
            System.out.println("Test case #" + i + "." + (x + 1) + ": " + search(t[x], s, 0, s.length - 1) + " (" + t[x] + ")"); 
        }
    }

    //checks if the word is in the dictionary array and returns the int where the word is in the dictionary 
    public static int search(String word, String[] s, int low, int high)
    {
        //return -1 if not in array 
        if(low > high)
        {
            return -1; 
        }
        int mid = (low + high) / 2; 
        
        //if the middle index contains the target word, return that int
        //if not, continue halving the array until the target word's index is found
        if(word.compareTo(s[mid]) == 0)
        {
            return mid; 
        }
        else if(word.compareTo(s[mid]) < 0)
        {
            return search(word, s, low, mid - 1); 
        }
        else 
        {
            return search(word, s, mid + 1, high); 
        }
    }
}