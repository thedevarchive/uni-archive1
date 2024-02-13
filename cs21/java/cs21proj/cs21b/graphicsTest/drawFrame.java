
/**
 * Write a description of class drawFrame here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import javax.swing.*; 
import java.awt.*; 
import java.awt.geom.*; 

public class drawFrame
{
    public static void main(String args[])
    {
        int w = 640;
        int h = 480;
        JFrame f = new JFrame(); 
        f.setSize(w, h); 
        f.setTitle("drawing in java"); 
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true); 
        
        drawC dc = new drawC(w, h); 
        f.add(dc); 
        f.revalidate(); 
    }
}
