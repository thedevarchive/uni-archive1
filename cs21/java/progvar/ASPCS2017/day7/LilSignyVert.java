import java.util.*;
public class LilSignyVert
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        String sign = sc.nextLine();
        for(int i = 0; i < sign.length(); i++)
        {
            System.out.println(sign.charAt(i));
        }
    }
}