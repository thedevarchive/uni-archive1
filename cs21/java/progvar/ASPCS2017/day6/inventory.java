import java.util.*; 
public class inventory
{
    public static boolean searchProd(int[] stor, int f)
    {
        boolean foundProd = false; 
        for(int i = 0; i < stor.length; i++)
        {
            if(stor[i] == f)
            {
                foundProd = true; 
            }
        }
        return foundProd; 
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int prods = sc.nextInt();
        int[] storage = new int[prods];
        for(int i = 0; i < prods; i++)
        {
            storage[i] = sc.nextInt();
        }
        int find = sc.nextInt();
        if(searchProd(storage, find))
        {
            System.out.println("In stock");
        }
        else
        {
            System.out.println("Please restock");
        }
    }
}