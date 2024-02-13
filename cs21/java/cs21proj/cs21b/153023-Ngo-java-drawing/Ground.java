
/**
 * Write a description of class Ground here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.awt.*; 
import java.awt.geom.*; 

public class Ground
{
    // instance variables - replace the example below with your own
    private Color terrain; 

    /**
     * Constructor for objects of class Ground
     */
    public Ground(Color t)
    {
        // initialise instance variables
        terrain = t; 
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public void drawG(Graphics2D g2d)
    {
        AffineTransform res = g2d.getTransform(); 
        
        g2d.translate(0, 300); 
        
        Rectangle2D.Double earth = new Rectangle2D.Double(0, 0, 640, 200); 
        g2d.setColor(terrain); 
        g2d.fill(earth); 
        
        g2d.setTransform(res); 
    }
}
