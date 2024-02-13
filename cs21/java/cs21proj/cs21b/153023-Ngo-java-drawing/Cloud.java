
/**
 * Write a description of class Cloud here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.awt.*; 
import java.awt.geom.*;

public class Cloud
{
    // instance variables - replace the example below with your own
    private Color cColor; 

    /**
     * Constructor for objects of class Cloud
     */
    public Cloud(Color c)
    {
        // initialise instance variables
        cColor = c; 
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public void drawC(Graphics2D g2d)
    {
        AffineTransform res = g2d.getTransform(); 
        
        g2d.translate(100, 20); 
        
        Ellipse2D.Double floof = new Ellipse2D.Double(0, 20, 150, 75); 
        Ellipse2D.Double puff = new Ellipse2D.Double(0, 0, 90, 90); 
        g2d.setColor(cColor); 
        g2d.fill(floof); 
        g2d.fill(puff); 
        
        
        g2d.setTransform(res); 
    }
}
