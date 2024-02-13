
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
    private Color sColor; 

    /**
     * Constructor for objects of class Sun
     */
    public Sun(Color s)
    {
        sColor = s; 
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public void drawS(Graphics2D g2d)
    {
        AffineTransform res = g2d.getTransform(); 
        
        g2d.translate(500, -75); 
        g2d.rotate(Math.toRadians(45)); 
        
        int xSun = 50;
        int ySun = 50; 
        
        Ellipse2D.Double sun = new Ellipse2D.Double(xSun, ySun, 100, 100); 
        g2d.setColor(sColor); 
        g2d.fill(sun); 
        
        Rectangle2D.Double r1 = new Rectangle2D.Double(xSun * 2, 10, 5, 30); 
        Rectangle2D.Double r2 = new Rectangle2D.Double(10, ySun * 2, 30, 5); 
        Rectangle2D.Double r3 = new Rectangle2D.Double(xSun * 2, 160, 5, 30); 
        Rectangle2D.Double r4 = new Rectangle2D.Double(160, ySun * 2, 30, 5); 
        g2d.fill(r1); 
        g2d.fill(r2); 
        g2d.fill(r3); 
        g2d.fill(r4); 
        
        g2d.setTransform(res); 
    }
}
