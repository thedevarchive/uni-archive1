
/**
 * Write a description of class angery here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.awt.*; 
import java.awt.geom.*; 

public class angery
{
    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public void react(Graphics2D g2d)
    {
        Ellipse2D.Double e = new Ellipse2D.Double(200, 75, 200, 200); 
        GradientPaint angery = 
        new GradientPaint(150, 175, new Color(247, 126, 126), 150, 250, new Color(247, 228, 160)); 
        g2d.setPaint(angery); 
        g2d.fill(e); 
        
        g2d.setColor(new Color (247, 126, 126)); 
        g2d.drawString("angery react only", 240, 300); 
        
        g2d.setStroke(new BasicStroke(8)); 
        g2d.setColor(Color.BLACK); 
        g2d.drawArc(260, 140, 130, 50, -30, -60);
        g2d.drawArc(210, 140, 130, 50, -90, -60); 
        
        Ellipse2D.Double eL = new Ellipse2D.Double(250, 189, 20, 20); 
        Ellipse2D.Double eR = new Ellipse2D.Double(330, 189, 20, 20); 
        g2d.fill(eL); 
        g2d.fill(eR); 
        
        Ellipse2D.Double mouth = new Ellipse2D.Double(270, 230, 60, 10); 
        g2d.fill(mouth); 
    }
}
