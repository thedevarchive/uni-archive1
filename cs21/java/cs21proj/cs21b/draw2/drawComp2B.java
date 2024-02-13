
/**
 * Write a description of class drawComp2B here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import javax.swing.*; 
import java.awt.*; 

public class drawComp2B extends JComponent
{
    private int width; 
    private int height; 
    
    public drawComp2B(int w, int h)
    {
        width = w; 
        height = h; 
    }
    
    protected void paintComponent(Graphics g) 
    {
        Graphics2D g2d = (Graphics2D) g; 
        
        RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); 
        g2d.setRenderingHints(rh); 
        
        House myHouse = new House(Color.BLACK); 
        myHouse.drawObj(g2d); 
    }
}
