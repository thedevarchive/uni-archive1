
/**
 * This is a program that displays the digital format of a given number in a given size. 
 * The "digital format" here refers to how the numbers are displayed in a calculator, or in a digital 
 * watch. 
 * The user first inputs a number to be displayed, then the size it is to be displayed.
 * "Size" represents the dashes needed to display the number in the digital format. 
 * 
 * Alyssa Mae Ngo
 * November 1, 2016
 * 
 * I hereby attest to the truth of the following facts:
 * 
 * I have not discussed the Java language code in my program with anyone other than my instructor or 
the teaching assistants assigned to this course.
 *
 * I have not used Java language code obtained from another student, or any other unauthorized source, 
either modified or unmodified.
 *
 * If any Java language code or documentation used in my program was obtained from another source, 
such as a text book or course notes, that has been clearly noted with a proper citation in the comments of my program.
 */
import java.util.Scanner; 
public class DigitDisplay
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        String num = sc.next();
        int size = sc.nextInt();
        int i; 
        int row; 
        int col; 
        int j; 
        int k; 
        String line = ""; 

        while(true)
        {
            if("0".equals(num) && size == 0)
            {
                break; 
            }
            for(i = 0; i < num.length(); i++)
            {
                switch(num.charAt(i))
                {
                    case '1': 
                        for(j = 1; j <= 5; j++)
                        {
                            switch(j)
                            {
                                case 2: 
                                case 4: 
                                    for(row = 1; row <= size; row++)
                                    {
                                        for (col = 1; col <= size + 2; col++)
                                        {
                                            if (col == size + 2)
                                            {
                                                line += "|";
                                                continue; 
                                            }
                                            line += " "; 
                                        }
                                        System.out.println(line);
                                        line = ""; 
                                    }
                                    break; 
                                default: 
                                    for(col = 1; col <= size + 2; col++)
                                    {
                                        line += " ";
                                    }
                                    System.out.println(line); 
                                    line = ""; 
                            }
                        } 
                        break;
                    case '2': 
                        for(j = 1; j <= 5; j++)
                        {
                            switch(j)
                            {
                                case 2: 
                                    for(row = 1; row <= size; row++)
                                    {
                                        for (col = 1; col <= size + 2; col++)
                                        {
                                            if (col == size + 2)
                                            {
                                                line += "|";
                                                continue; 
                                            }
                                            line += " "; 
                                        }
                                        System.out.println(line);
                                        line = ""; 
                                    }
                                    break; 
                                case 4: 
                                    for (row = 1; row <= size; row++)
                                    {
                                        for (col = 1; col <= size + 2; col++)
                                        {
                                            if (col == 1)
                                            {   
                                                line += "|";
                                                continue; 
                                            }
                                            line += " "; 
                                        }   
                                        System.out.println(line); 
                                        line = ""; 
                                    }
                                    break; 
                                default: 
                                    for(col = 1; col <= 3; col++)
                                    {
                                        switch(col)
                                        {
                                            case 1:
                                            case 3: 
                                                line += " "; 
                                                break; 
                                            case 2:
                                                for (row = 0; row < size; row++)
                                                {
                                                    line += "-";
                                                }
                                                break; 
                                        }
                                    }
                                    System.out.println(line); 
                                    line = "";
                            }
                        }
                        break;
                    case '3': 
                        for(j = 1; j <= 5; j++)
                        {
                            switch (j)
                            {
                                case 2: 
                                case 4: 
                                    for (k = 1; k <= size; k++)
                                    {
                                        for (col = 1; col <= size + 2; col++)
                                        {
                                            if (col == size + 2)
                                            {
                                                line += "|";
                                                continue; 
                                            }
                                            line += " "; 
                                        }
                                        System.out.println(line);
                                        line = "";
                                    }
                                    break; 
                                
                                default:
                                    for(col = 1; col <= 3; col++)
                                    {
                                        switch(col)
                                        {
                                            case 1:
                                            case 3: 
                                                line += " "; 
                                                break; 
                                            case 2:
                                                for (row = 0; row < size; row++)
                                                {
                                                    line += "-";
                                                }
                                                break; 
                                        }
                                    }
                                    System.out.println(line); 
                                    line = "";
                            }
                        }
                        break;
                    case '4': 
                        for(j = 1; j <= 5; j++)
                        {
                            switch (j)
                            {
                                case 1:
                                case 5: 
                                    for(col = 0; col < size + 2; col++)
                                    {
                                        line += " ";
                                    }
                                    System.out.println(line); 
                                    line = "";
                                    break; 
                                case 2: 
                                    for (k = 1; k <= size; k++)
                                    {
                                        for(col = 1; col <= 3; col++)
                                        {
                                            switch(col)
                                            {
                                                case 1:
                                                case 3: 
                                                    line += "|"; 
                                                    break; 
                                                case 2:
                                                    for (row = 0; row < size; row++)
                                                    {
                                                        line += " ";
                                                    }
                                                    break; 
                                                }
                                        }
                                        System.out.println(line);
                                        line = ""; 
                                    }
                                    break;
                                case 3: 
                                    for(col = 1; col <= 3; col++)
                                    {
                                        switch(col)
                                        {
                                            case 1:
                                            case 3: 
                                                line += " "; 
                                                break; 
                                            case 2:
                                                for (row = 0; row < size; row++)
                                                {
                                                    line += "-";
                                                }
                                                break; 
                                        }
                                    }
                                    System.out.println(line); 
                                    line = "";
                                    break;
                                case 4: 
                                    for(row = 1; row <= size; row++)
                                    {
                                        for (col = 1; col <= size + 2; col++)
                                        {
                                            if (col == size + 2)
                                            {
                                                line += "|";
                                                continue; 
                                            }
                                            line += " "; 
                                        }
                                        System.out.println(line);
                                        line = "";
                                    }
                                    break; 
                                
                            }
                            
                        } 
                        break; 
                    case '5': 
                        for(j = 1; j <= 5; j++)
                        {
                            switch (j)
                            {
                                case 2: 
                                    for (row = 1; row <= size; row++)
                                    {
                                        for (col = 1; col <= size + 2; col++)
                                        {
                                            if (col == 1)
                                            {   
                                                line += "|";
                                                continue; 
                                            }
                                            line += " "; 
                                        }   
                                        System.out.println(line); 
                                        line = ""; 
                                    }   
                                    break; 
                                case 4: 
                                    for(row = 1; row <= size; row++)
                                    {
                                        for (col = 1; col <= size + 2; col++)
                                        {
                                            if (col == size + 2)
                                            {
                                                line += "|";
                                                continue; 
                                            }
                                            line += " "; 
                                        }
                                        System.out.println(line);
                                        line = ""; 
                                    }
                                    break; 
                                default: 
                                    for(col = 1; col <= 3; col++)
                                    {
                                        switch(col)
                                        {
                                            case 1:
                                            case 3: 
                                                line += " "; 
                                                break; 
                                            case 2:
                                                for (row = 1; row <= size; row++)
                                                {
                                                    line += "-";
                                                }
                                                break; 
                                        }
                                    }
                                    System.out.println(line); 
                                    line = "";
                            }
                        }
                        break; 
                    case '6': 
                        for(j = 1; j <= 5; j++)
                            {
                                switch (j)
                                {
                                    case 2:
                                        for (row = 1; row <= size; row++)
                                        {
                                            for (col = 1; col <= size + 2; col++)
                                            {
                                                if (col == 1)
                                                {   
                                                    line += "|";
                                                    continue; 
                                                }
                                                line += " "; 
                                            }   
                                            System.out.println(line); 
                                            line = ""; 
                                        }
                                        break;
                                    case 4:
                                        for (k = 1; k <= size; k++)
                                        {
                                            for(col = 1; col <= 3; col++)
                                            {
                                                switch(col)
                                                {
                                                    case 1:
                                                    case 3: 
                                                        line += "|"; 
                                                        break; 
                                                    case 2:
                                                        for (row = 0; row < size; row++)
                                                        {
                                                            line += " ";
                                                        }
                                                        break; 
                                                }
                                            }
                                            System.out.println(line);
                                            line = ""; 
                                        }
                                        break; 
                                    default: 
                                        for(col = 1; col <= 3; col++)
                                        {
                                            switch(col)
                                            {
                                                case 1:
                                                case 3: 
                                                    line += " "; 
                                                    break; 
                                                case 2:
                                                    for (row = 0; row < size; row++)
                                                    {
                                                        line += "-";
                                                    }
                                                    break; 
                                                }
                                            }
                                            System.out.println(line); 
                                            line = "";
                            }
                            
                        } 
                        break;
                    case '7':
                        for(j = 1; j <= 5; j++)
                        {
                            switch(j)
                            {
                                case 1: 
                                    for(col = 1; col <= 3; col++)
                                    {
                                        switch(col)
                                        {
                                            case 1:
                                            case 3: 
                                                line += " "; 
                                                break; 
                                            case 2:
                                                for (row = 0; row < size; row++)
                                                {
                                                    line += "-";
                                                }
                                                break; 
                                        }
                                    }
                                    System.out.println(line); 
                                    line = "";
                                    break; 
                                case 2: 
                                case 4: 
                                    for(row = 1; row <= size; row++)
                                    {
                                        for (col = 1; col <= size + 2; col++)
                                        {
                                            if (col == size + 2)
                                            {
                                                line += "|";
                                                continue; 
                                            }
                                            line += " "; 
                                        }
                                        System.out.println(line);
                                        line = ""; 
                                    }
                                    break; 
                                default: 
                                    for(col = 1; col <= size + 2; col++)
                                    {
                                        line += " ";
                                    }
                                    System.out.println(line); 
                                    line = ""; 
                            }
                        } 
                        break;
                    case '8': 
                        for(j = 1; j <= 5; j++)
                        {
                            switch (j)
                            {
                                case 2: 
                                case 4: 
                                    for (k = 1; k <= size; k++)
                                    {
                                        for(col = 1; col <= 3; col++)
                                        {
                                            switch(col)
                                            {
                                                case 1:
                                                case 3: 
                                                    line += "|"; 
                                                    break; 
                                                case 2:
                                                    for (row = 0; row < size; row++)
                                                    {
                                                        line += " ";
                                                    }
                                                    break; 
                                                }
                                        }
                                        System.out.println(line);
                                        line = ""; 
                                    }
                                    break; 
                                
                                default:
                                    for(col = 1; col <= 3; col++)
                                    {
                                        switch(col)
                                        {
                                            case 1:
                                            case 3: 
                                                line += " "; 
                                                break; 
                                            case 2:
                                                for (row = 0; row < size; row++)
                                                {
                                                    line += "-";
                                                }
                                                break; 
                                        }
                                    }
                                    System.out.println(line); 
                                    line = "";
                            }
                        }
                        break; 
                    case '9': 
                        for(j = 1; j <= 5; j++)
                            {
                                switch (j)
                                {
                                    case 2:
                                        for (k = 1; k <= size; k++)
                                        {
                                            for(col = 1; col <= 3; col++)
                                            {
                                                switch(col)
                                                {
                                                    case 1:
                                                    case 3: 
                                                        line += "|"; 
                                                        break; 
                                                    case 2:
                                                        for (row = 0; row < size; row++)
                                                        {
                                                            line += " ";
                                                        }
                                                        break; 
                                                }
                                            }
                                            System.out.println(line);
                                            line = ""; 
                                        }
                                        break;
                                    case 4:
                                        for (row = 1; row <= size; row++)
                                        {
                                            for (col = 1; col <= size + 2; col++)
                                            {
                                                if (col == size + 2)
                                                {   
                                                    line += "|";
                                                    continue; 
                                                }
                                                line += " "; 
                                            }   
                                            System.out.println(line); 
                                            line = ""; 
                                        }
                                        break; 
                                    default: 
                                        for(col = 1; col <= 3; col++)
                                        {
                                            switch(col)
                                            {
                                                case 1:
                                                case 3: 
                                                    line += " "; 
                                                    break; 
                                                case 2:
                                                    for (row = 0; row < size; row++)
                                                    {
                                                        line += "-";
                                                    }
                                                    break; 
                                                }
                                            }
                                            System.out.println(line); 
                                            line = "";
                            }
                            
                        } 
                        break;
                    case '0': 
                        for(j = 1; j <= 5; j++)
                        {
                            switch (j)
                            {
                                case 2: 
                                case 4: 
                                    for (k = 1; k <= size; k++)
                                    {
                                        for(col = 1; col <= 3; col++)
                                        {
                                            switch(col)
                                            {
                                                case 1:
                                                case 3: 
                                                    line += "|"; 
                                                    break; 
                                                case 2:
                                                    for (row = 0; row < size; row++)
                                                    {
                                                        line += " ";
                                                    }
                                                    break; 
                                                }
                                        }
                                        System.out.println(line);
                                        line = ""; 
                                    }
                                    break; 
                                case 3: 
                                    for(col = 1; col <= size + 2; col++)
                                    {
                                        line += " ";
                                    }
                                    System.out.println(line); 
                                    line = ""; 
                                    break; 
                                default:
                                    for(col = 1; col <= 3; col++)
                                    {
                                        switch(col)
                                        {
                                            case 1:
                                            case 3: 
                                                line += " "; 
                                                break; 
                                            case 2:
                                                for (row = 0; row < size; row++)
                                                {
                                                    line += "-";
                                                }
                                                break; 
                                        }
                                    }
                                    System.out.println(line); 
                                    line = "";
                            }
                        }
                        break; 
                }
            }
            num = sc.next();
            size = sc.nextInt();
        }
    }
}
