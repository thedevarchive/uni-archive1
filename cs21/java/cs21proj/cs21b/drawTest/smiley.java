
/**
 * Write a description of class smiley here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.awt.*; 
import java.awt.geom.*; 

public class smiley
{

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public void drawSmile(Graphics2D g2d)
    {
        double smileyPos = 50; 
        
        Ellipse2D.Double face = new Ellipse2D.Double(smileyPos, 75, 200, 200); 
        g2d.setColor(Color.YELLOW); 
        g2d.fill(face); 
        
        Ellipse2D.Double eyeL = new Ellipse2D.Double(smileyPos + 50, 120, 30, 50); 
        g2d.setColor(Color.BLACK); 
        g2d.fill(eyeL); 
        
        Ellipse2D.Double eyeR = new Ellipse2D.Double(smileyPos + 125, 120, 30, 50); 
        g2d.fill(eyeR); 
        
        // g2d.drawArc(105, 190, 95, 50, 0, -180);
        
        g2d.drawArc(90, 150, 95, 50, 0, -180);
    }
}
