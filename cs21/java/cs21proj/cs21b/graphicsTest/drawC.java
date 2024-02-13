
/**
 * Write a description of class drawC here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.awt.*; 
import java.awt.geom.*; 
import javax.swing.*; 

public class drawC extends JComponent
{
    private int width; 
    private int height; 
    
    public drawC(int w, int h)
    {
        width = w; 
        height = h; 
    }
    
    protected void paintComponent (Graphics g)
    {
        Graphics2D g2d = (Graphics2D) g; 
        
        RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, 
        RenderingHints.VALUE_ANTIALIAS_ON); 
        g2d.setRenderingHints(rh); 
        
        Rectangle2D.Double r = new Rectangle2D.Double(50, 50, 60, 100); 
        g2d.setColor(Color.CYAN); 
        //g2d.fill(r); 
        
        g2d.setColor(Color.GRAY); 
        AffineTransform at = new AffineTransform(); 
        at.rotate(Math.toRadians(90), 50, 50); 
        Shape newR = at.createTransformedShape(r); 
        //g2d.fill(newR); 
        for (int i = 0; i <= 5; i++)
        {
            try {
                g2d.setColor(Color.CYAN); 
                g2d.fill(r); 
                
                //sleep 5 seconds
                Thread.sleep(1000);
                
                g2d.setColor(Color.WHITE); 
                g2d.fill(r); 
                
                Thread.sleep(1000); 
                
                g2d.setColor(Color.GRAY); 
                g2d.fill(newR); 
                
                Thread.sleep(1000);
                
                g2d.setColor(Color.WHITE); 
                g2d.fill(newR); 
                
                Thread.sleep(1000); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
