
/**
 * Write a description of class drawComp here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.awt.*; 
import java.awt.geom.*; 
import javax.swing.*; 

public class drawComp extends JComponent
{
    private int width; 
    private int height; 
    
    public drawComp(int w, int h)
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
        
        //setOpaque(true); 
        //setBackground(Color.WHITE); 
        
        
        /*Rectangle2D.Double r = new Rectangle2D.Double(50, 75, 100, 250); 
        g2d.setColor(Color.BLACK); 
        g2d.fill(r);*/
        
        /* */
        
        /*double eW = 100; 
        //(w / 2) - (eW / 2)
        Ellipse2D.Double egg = new Ellipse2D.Double(500, 190, eW, 125); 
        g2d.setColor(Color.WHITE); 
        g2d.fill(egg); 
        
        Ellipse2D.Double longEgg = new Ellipse2D.Double(10, 100, 100, 175); 
        g2d.setColor(Color.LIGHT_GRAY);
        g2d.fill(longEgg); 
        
        Line2D.Double l = new Line2D.Double(100, 250, 300, 300); 
        g2d.setColor(Color.BLACK); 
        g2d.draw(l); */
        
        /*smiley smile = new smiley(); 
        smile.drawSmile(g2d); */
        
        /*cookie alls = new cookie(); 
        alls.bake(g2d); */
        
        /*angery aaa = new angery(); 
        aaa.react(g2d); */
        
        /*gear compsat = new gear(); 
        compsat.drawLogo(g2d); */
        
        choob ertDoobert = new choob(); 
        ertDoobert.drawChoob(g2d); 
    }
}
