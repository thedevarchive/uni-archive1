
/**
 * Write a description of class Sun here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.awt.*; 
import java.awt.geom.*; 

public class Sun
{
    // instance variables - replace the example below with your own
    private int x; 
    private int y; 
    private double size; 
    private Color sunColor; 

    /**
     * Constructor for objects of class Sun
     */
    public Sun(int a, int b, double s, Color c)
    {
        x = a; 
        y = b; 
        size = s; 
        sunColor = c;  
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public void drawObject(Graphics2D g2d, AffineTransform reset)
    {
        Ellipse2D.Double sun = new Ellipse2D.Double(0, 0, size, size); 
        g2d.translate(x,y); 
        g2d.setColor(sunColor); 
        g2d.fill(sun); 
        g2d.setTransform(reset); 
    }
    
    public void incX(int a)
    {
        x += a; 
    }
}
