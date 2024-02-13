
/**
 * Write a description of class gear here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.awt.*; 
import java.awt.geom.*;

public class gear
{
    // instance variables - replace the example below with your own
    /*private int x;
    public gear()
    {
        // initialise instance variables
        x = 0;
    }
    */

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public void drawLogo(Graphics2D g2d)
    {
        // put your code here
        
        RoundRectangle2D.Double teethA = new RoundRectangle2D.Double(400, 25, 50, 200, 15, 15);
        AffineTransform at = new AffineTransform();
        at.rotate(Math.toRadians(45), 400, 25);
        Shape tA = at.createTransformedShape(teethA);
        g2d.setColor(Color.BLACK);
        g2d.fill(tA);
        
        RoundRectangle2D.Double teethB = new RoundRectangle2D.Double(400, 25, 50, 200, 15, 15);
        AffineTransform at2 = new AffineTransform(); 
        at2.rotate(Math.toRadians(135), 388, 103); 
        Shape tB = at2.createTransformedShape(teethB); 
        g2d.fill(tB); 
        
        Ellipse2D.Double circB = new Ellipse2D.Double(278, 40, 145, 145); 
        g2d.fill(circB); 
        
        Ellipse2D.Double circC = new Ellipse2D.Double(323, 84, 55, 55); 
        g2d.setColor(new Color(234, 234, 229)); 
        g2d.fill(circC); 
    }
}
