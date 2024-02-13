
/**
 * Write a description of class choob here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.awt.*; 
import java.awt.geom.*; 

public class choob
{
    public void drawChoob(Graphics2D g2d)
    {
        g2d.setColor(Color.BLUE); 
        g2d.fillArc(65, 215, 200, 175, 0, 180); 
        g2d.setColor(Color.WHITE); 
        g2d.fillArc(66, 215, 198, 155, 0, 180); 
        g2d.setColor(Color.BLUE); 
        g2d.fillArc(67, 215, 196, 135, 0, 180); 
        g2d.setColor(Color.WHITE); 
        g2d.fillArc(68, 215, 194, 115, 0, 180); 
        g2d.setColor(Color.BLUE); 
        g2d.fillArc(69, 215, 192, 95, 0, 180); 
        g2d.setColor(Color.WHITE); 
        g2d.fillArc(71, 215, 188, 75, 0, 180); 
        g2d.setColor(Color.BLUE); 
        g2d.fillArc(75, 215, 180, 55, 0, 180); 
        
        g2d.setColor(new Color(209, 181, 156)); 
        Rectangle2D.Double neck = new Rectangle2D.Double(135, 220, 55, 23); 
        g2d.fill(neck); 
        
        g2d.setColor(Color.WHITE); 
        g2d.setStroke(new BasicStroke(2)); 
        Path2D.Double collar1 = new Path2D.Double(); 
        collar1.moveTo(130, 210); 
        collar1.lineTo(150, 250); 
        collar1.lineTo(100, 220); 
        g2d.fill(collar1); 
        g2d.fillArc(100, 215, 50, 10, 180, -120); 
        
        g2d.setColor(Color.BLACK); 
        Path2D.Double outlineC1 = new Path2D.Double(); 
        outlineC1.moveTo(130, 210); 
        outlineC1.lineTo(150, 250); 
        outlineC1.lineTo(100, 220); 
        g2d.draw(outlineC1); 
        g2d.drawArc(100, 215, 50, 10, 180, -120); 
        
        g2d.setColor(Color.WHITE);  
        Path2D.Double collar2 = new Path2D.Double(); 
        collar2.moveTo(195, 210); 
        collar2.lineTo(175, 250); 
        collar2.lineTo(225, 220); 
        g2d.fill(collar2); 
        g2d.fillArc(175, 215, 50, 10, 0, 120); 
        
        g2d.setColor(Color.BLACK); 
        Path2D.Double outlineC2 = new Path2D.Double(); 
        outlineC2.moveTo(195, 210); 
        outlineC2.lineTo(175, 250); 
        outlineC2.lineTo(225, 220); 
        g2d.draw(outlineC2); 
        g2d.drawArc(175, 215, 50, 10, 0, 120); 
        
        Ellipse2D.Double head = new Ellipse2D.Double(100, 100, 125, 125); 
        Ellipse2D.Double e1 = new Ellipse2D.Double(85, 150, 30, 30); 
        Ellipse2D.Double e2 = new Ellipse2D.Double(210, 150, 30, 30); 
        g2d.setColor(new Color(209, 181, 156)); 
        g2d.fill(head); 
        g2d.fill(e1); 
        g2d.fill(e2); 
        
        g2d.setColor(Color.BLACK); 
        g2d.fillArc(101, 111, 50, 100, 180, -120); 
        g2d.fillArc(138, 109, 110, 20, 190, 60); 
        g2d.fillArc(136, 100, 90, 150, 95, -80); 
        g2d.setColor(new Color(209, 181, 156)); 
        g2d.fillArc(136, 128, 90, 120, 100, -80); 
        g2d.fillArc(101, 125, 50, 100, 180, -120); 
        
        RoundRectangle2D.Double hair = new RoundRectangle2D.Double(130, 99, 80, 25, 15, 10); 
        g2d.setColor(Color.BLACK); 
        g2d.fill(hair); 
        
        Line2D.Double brow1 = new Line2D.Double(120, 150, 145, 150); 
        g2d.setStroke(new BasicStroke(2)); 
        g2d.draw(brow1); 
        
        Line2D.Double brow2 = new Line2D.Double(200, 150, 175, 150);
        g2d.draw(brow2); 
        
        Ellipse2D.Double eye1 = new Ellipse2D.Double(130, 160, 5, 5); 
        g2d.setColor(Color.YELLOW); 
        g2d.fill(eye1); 
        
        Ellipse2D.Double eye2 = new Ellipse2D.Double(185, 160, 5, 5); 
        g2d.fill(eye2); 
        
        g2d.setColor(Color.BLACK); 
        g2d.drawArc(147, 175, 25, 5, 0, -180); 
        
        g2d.drawArc(145, 195, 30, 5, 0, -180); 
        
        g2d.setColor(Color.RED); 
        Ellipse2D.Double feather = new Ellipse2D.Double(165, 35, 10, 30); 
        g2d.fill(feather); 
        
        g2d.setColor(Color.YELLOW); 
        Line2D.Double brim = new Line2D.Double(10, 50, 150, 50); 
        Path2D.Double hat = new Path2D.Double(); 
        hat.moveTo(50, 50); 
        hat.lineTo(60, 10); 
        hat.lineTo(100, 10); 
        hat.lineTo(110, 50);
        AffineTransform at = new AffineTransform(); 
        at.rotate(Math.toRadians(350), 410, -350); 
        Shape newB = at.createTransformedShape(brim); 
        Shape newH = at.createTransformedShape(hat); 
        g2d.draw(newB); 
        g2d.fill(newH); 
        
        /*g2d.setColor(Color.BLACK); 
        Ellipse2D.Double rim1 = new Ellipse2D.Double(115, 155, 40, 20); 
        g2d.draw(rim1); 
        
        Line2D.Double cen = new Line2D.Double(155, 165, 165, 165);
        g2d.draw(cen); 
        
        Ellipse2D.Double rim2 = new Ellipse2D.Double(165, 155, 40, 20); 
        g2d.draw(rim2); 
        
        Line2D.Double hookL = new Line2D.Double(98, 150, 115, 165); 
        g2d.draw(hookL); 
        
        Line2D.Double hookR = new Line2D.Double(225, 150, 205, 165); 
        g2d.draw(hookR); */
        
        //g2d.drawString("y r u like this", 110, 250); 
        //g2d.drawString("Y'ALL GET D'S", 110, 315); 
        //g2d.drawString("DDDDD-L WITH IT", 100, 325); 
    }
}
