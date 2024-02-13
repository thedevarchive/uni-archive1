
/**
 * Write a description of class House here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.awt.*; 
import java.awt.geom.*; 

public class House
{
    private Color rColor; 
    private Color wdColor; 
    private Color waColor; 
    private Color dColor; 
    
    public House(Color r, Color wd, Color wa, Color d)
    {
        rColor = r; 
        wdColor = wd; 
        waColor = wa; 
        dColor = d; 
    }
    
    public void drawH(Graphics2D g2d)
    {
        Path2D.Double roof = new Path2D.Double(); 
        
        AffineTransform res = g2d.getTransform(); 
        
        g2d.translate(220, 150); 
        
        roof.moveTo(100, 0); 
        roof.lineTo(0, 50); 
        roof.lineTo(200, 50); 
        roof.lineTo(100, 0);
        g2d.setColor(rColor); 
        g2d.fill(roof); 
        
        Rectangle2D.Double base = new Rectangle2D.Double(30, 50, 140, 130); 
        g2d.setColor(waColor); 
        g2d.fill(base); 
        
        Rectangle2D.Double w1 = new Rectangle2D.Double(45, 70, 30, 30);
        Rectangle2D.Double w2 = new Rectangle2D.Double(85, 70, 30, 30); 
        Rectangle2D.Double w3 = new Rectangle2D.Double(125, 70, 30, 30); 
        g2d.setColor(wdColor); 
        g2d.fill(w1); 
        g2d.fill(w2); 
        g2d.fill(w3); 
        
        Rectangle2D.Double door = new Rectangle2D.Double(85, 130, 30, 50); 
        g2d.setColor(dColor); 
        g2d.fill(door); 
        
        g2d.setTransform(res); 
    }
}
