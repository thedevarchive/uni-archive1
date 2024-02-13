
/**
 * Write a description of class Sky here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.awt.*; 
import java.awt.geom.*; 

public class Sky
{
    // do you love the
    private Color ofTheSky;  

    /**
     * Constructor for objects of class Sky
     */
    public Sky(Color o)
    {
        ofTheSky = o;
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
        
        Rectangle2D.Double sky = new Rectangle2D.Double(0, 0, 640, 320); 
        g2d.setColor(ofTheSky); 
        g2d.fill(sky); 
        
        g2d.setTransform(res); 
    }
}
