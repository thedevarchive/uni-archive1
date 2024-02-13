
/**
 * Write a description of class DrawingTestr here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import javax.swing.*; 

public class DrawingTestr
{
    public static void main(String args[])
    {
        JFrame f = new JFrame(); 
        drawComp2B dc2b = new drawComp2B(640, 480); 
        f.setSize(640, 480); 
        f.add(dc2b); 
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        f.setVisible(true); 
    }
}
