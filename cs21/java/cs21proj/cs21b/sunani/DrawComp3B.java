
/**
 * Write a description of class DrawComp3B here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.awt.*; 
import java.awt.geom.*; 
import javax.swing.*; 

public class DrawComp3B extends JComponent
{
    private int width; 
    private int height; 
    private Sun s; 
    
    public DrawComp3B(int w, int h)
    {
        width = w; 
        height = h; 
        s = new Sun(10, 10, 50, Color.YELLOW); 
    }
    
    protected void paintComponent(Graphics g)
    {
        Graphics2D g2d = (Graphics2D) g; 
        AffineTransform yungLian = g2d.getTransform(); 
        
        s.drawObject(g2d, yungLian); 
    }
    
    public Sun getSun()
    {
        return s; 
    }
}
