
/**
 * Write a description of class Ngo153023JavaDrawing here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import javax.swing.*; 
import java.awt.geom.*; 
import java.awt.*; 

public class Ngo153023JavaDrawing extends JComponent
{
    private int width; 
    private int height;
    
    public Ngo153023JavaDrawing(int w, int h)
    {
        width = w; 
        height = h; 
    }
    
    protected void paintComponent(Graphics g)
    {
        Graphics2D g2d = (Graphics2D) g; 
        
        RenderingHints rh = 
        new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); 
        g2d.setRenderingHints(rh); 
        
        Sky s = new Sky(Color.CYAN); 
        s.drawS(g2d); 
        
        Ground grass = new Ground(Color.GREEN); 
        grass.drawG(g2d); 
        
        House h = new House(Color.RED, Color.BLUE, Color.WHITE, Color.ORANGE); 
        h.drawH(g2d); 
        
        Sun risesInTheEast = new Sun(Color.YELLOW); 
        risesInTheEast.drawS(g2d); 
        
        Cloud freedomCloud = new Cloud(Color.WHITE); 
        freedomCloud.drawC(g2d); 
    }
}
