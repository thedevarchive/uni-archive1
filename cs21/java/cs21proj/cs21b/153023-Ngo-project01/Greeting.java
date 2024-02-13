
/**
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
 * 
 * This is the main method that will run the greeting card. 
 * 
 * @author Alyssa Mae Ngo (153023) 
 * @version April 6, 2017
 */
import java.awt.*; 
import javax.swing.*; 

public class Greeting
{
    public static void main(String args[])
    {
        JFrame f = new JFrame(); 
        DrawingComponent card = new DrawingComponent(f); 
        
        card.activateL(); 
        
        f.getContentPane().setPreferredSize(new Dimension(640, 480));
        f.setTitle("Easter Card");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(card);
        f.pack();
        f.setVisible(true);
    }
}
