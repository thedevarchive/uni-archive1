import java.util.*;
public class DatPars
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        String info = sc.nextLine();
        String[] parsd = info.split(",");
        int lctr = Integer.parseInt(parsd[0]);
        System.out.println(parsd[lctr]);
    }
}