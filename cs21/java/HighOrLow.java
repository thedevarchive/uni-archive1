import java.util.Scanner;
import java.util.Random;
public class HighOrLow
{
	public static void main (String[] args)
	{
		Scanner hylo = new Scanner(System.in);
		Random rolr = new Random();
		int die = rolr.nextInt(6) + 1;
		int dice = rolr.nextInt(6) + 1;
		int dices = rolr.nextInt(6) + 1;
		//illuminate
		boolean games = true;
		int yahtzee = die + dice + dices;
		String answer;
		int streak = 0;
		System.out.println("Welcome to High Or Low!");
		System.out.println("How to play: Type h if you think the sum of the numbers on the three dice I will"); 
		System.out.println("roll will be high or l if you think it's low. If you are right, we'll keep \nplaying until you lose a round.");
		System.out.println("(Pst, 11-18 are the high numbers, and 3-10 are the low numbers.)");
		while (games == true)
		{
			
			System.out.println("So, what do you think, will the number I will roll be high or low?");
			if (yahtzee >= 11)
			{
				answer = "h";
			}
			else 
			{
				answer = "l"; 
			}
			String guess = hylo.nextLine();
			System.out.println("The numbers I rolled were: " + die + " " + dice + " " + dices);
			System.out.println("Their sum is: " + yahtzee);
			if (answer.equalsIgnoreCase(guess))
			{
				streak++;
				System.out.println("Correct!");
				System.out.println("Streak: " + streak);
				die = rolr.nextInt(6) + 1;
				dice = rolr.nextInt(6) + 1;
				dices = rolr.nextInt(6) + 1;
				yahtzee = die + dice + dices;
			}
			else
			{
				System.out.println("Game over!");
				System.out.println("Your score: " + streak);
				System.out.println("Want to play again? (y/n)");
				String okno = hylo.nextLine();
				if(okno.equalsIgnoreCase("n"))
				{
					games = false;
				}
				else if (okno.equalsIgnoreCase("y"))
				{
					games = true;
				}
				else
				{
					System.out.println("Bye bye!");	
					break;
				}
			}
		}
		
			
	}
}