import java.util.*; 
public class delet13
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] arr = new int[size]; 
        int tot = 0;
        for(int i = 0; i < size; i++)
        {
            arr[i] = sc.nextInt();
                if(i + 1 != size)
                {
                    if(arr[i + 1] == 13) continue; 
                }
                if(i - 1 != -1)
                {
                    if(arr[i - 1] == 13) continue; 
                }
                if(arr[i] == 13)continue; 
                tot += arr[i]; 
        }
        System.out.println(tot);
    }
}