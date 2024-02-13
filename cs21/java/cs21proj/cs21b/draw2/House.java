
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
    // instance variables - replace the example below with your own
    private Color hCloor; 
    
    public House(Color c)
    {
        hCloor = c; //cohose yuor cloor
    }
    
    public void drawObj(Graphics2D g2d)
    {
        Path2D.Double house = new Path2D.Double(); 
        
        AffineTransform res = g2d.getTransform(); 
        
        g2d.translate(120, 300); 
        //g2d.rotate(Math.toRadians(45)); 
        
        house.moveTo(50, 0);
        house.lineTo(0, 25); 
        house.lineTo(25, 25); 
        house.lineTo(25, 75); 
        house.lineTo(75, 75); 
        house.lineTo(75, 25); 
        house.lineTo(95, 25); 
        //house.lineTo(0, 25); 
        g2d.setColor(hCloor); 
        g2d.fill(house); 
        
        g2d.setTransform(res); 
    }
}
