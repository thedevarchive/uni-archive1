import java.util.*; 

public class CanCount
{
    public static void main(String args[])
    {
        Scanner cc = new Scanner(System.in);
        int labels = cc.nextInt();
        int zero = 0, one = 0, two = 0, three = 0, four = 0, five = 0, six = 0, seven = 0, eight = 0, nine = 0; 
        for(int i = 0; i < labels; i++)
        {
            int can = cc.nextInt();
            switch(can)
            {
                case 0:
                    zero++; 
                    break; 
                case 1:
                    one++; 
                    break; 
                case 2:
                    two++; 
                    break; 
                case 3:
                    three++; 
                    break; 
                case 4:
                    four++; 
                    break; 
                case 5:
                    five++; 
                    break; 
                case 6:
                    six++; 
                    break; 
                case 7:
                    seven++; 
                    break; 
                case 8:
                    eight++; 
                    break; 
                case 9:
                    nine++; 
                    break; 
            }
        }
        System.out.println("0: " + zero);
        System.out.println("1: " + one);
        System.out.println("2: " + two);
        System.out.println("3: " + three);
        System.out.println("4: " + four);
        System.out.println("5: " + five);
        System.out.println("6: " + six);
        System.out.println("7: " + seven);
        System.out.println("8: " + eight);
        System.out.println("9: " + nine);
    }
}