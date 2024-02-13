
/**
 * Write a description of class FrameRunner here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import javax.swing.*; 

public class FrameRunner
{
    public static void main(String args[])
    {
        JFrame f = new HWFrame(); 
        f.setSize(200, 300); 
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        f.setVisible(true); 
    }
}