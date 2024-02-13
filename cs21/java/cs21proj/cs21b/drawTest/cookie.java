
/**
 * Write a description of class cookie here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.awt.*; 
import java.awt.geom.*; 

public class cookie
{

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public void bake(Graphics2D g2d)
    {
        Ellipse2D.Double e = new Ellipse2D.Double(200, 75, 200, 200); 
        g2d.setColor(new Color(201, 131, 56)); 
        g2d.fill(e); 
        
        Ellipse2D.Double chip = new Ellipse2D.Double(230, 150, 30, 30); 
        g2d.setColor(new Color(96, 49, 28));
        g2d.fill(chip); 
        
        Ellipse2D.Double chip2 = new Ellipse2D.Double(280, 100, 30, 30); 
        g2d.fill(chip2); 
        
        Ellipse2D.Double chip3 = new Ellipse2D.Double(330, 125, 30, 30); 
        g2d.fill(chip3); 
        
        Ellipse2D.Double chip4 = new Ellipse2D.Double(250, 200, 30, 30); 
        g2d.fill(chip4); 
        
        Ellipse2D.Double chip5 = new Ellipse2D.Double(300, 150, 30, 30); 
        g2d.fill(chip5); 
        
        Ellipse2D.Double chip6 = new Ellipse2D.Double(320, 220, 30, 30); 
        g2d.fill(chip6); 
        
        Ellipse2D.Double chip7 = new Ellipse2D.Double(350, 190, 30, 30); 
        g2d.fill(chip7);
    }
}
