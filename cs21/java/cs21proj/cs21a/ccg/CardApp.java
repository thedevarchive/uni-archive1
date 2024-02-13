
/**
 * Write a description of class CardApp here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import javax.swing.*; 

public class CardApp
{
    public static void main(String[] args)
    {
        JFrame game = new CardGUI(); 
        game.setSize(600, 650);
        game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        game.setVisible(true); 
    }
}
