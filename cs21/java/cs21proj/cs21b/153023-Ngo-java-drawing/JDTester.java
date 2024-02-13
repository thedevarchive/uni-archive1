
/**
 * Write a description of class JDTester here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import javax.swing.*; 

public class JDTester
{
    public static void main(String args[])
    {
        int w = 640; 
        int h = 480; 
        
        JFrame f = new JFrame(); 
        Ngo153023JavaDrawing ngo = new Ngo153023JavaDrawing(w, h); 
        f.setSize(w, h); 
        f.add(ngo); 
        f.setTitle("153023 - Ngo - Java Drawing"); 
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        f.setVisible(true); 
    }
}
