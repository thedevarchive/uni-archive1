import java.util.*;
public class CashOut
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        String add = sc.next();
        String end = sc.next();
        add = add.substring(3);
        end = end.substring(3);
        System.out.println("Php" + (Integer.parseInt(add) + Integer.parseInt(end)));
    }
}