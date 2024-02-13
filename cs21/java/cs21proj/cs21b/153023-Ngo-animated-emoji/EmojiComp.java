
/**
 * I hereby attest to the truth of the following facts:
 * 
 * I have not discussed the Java language code in my program with anyone other than my instructor or 
the teaching assistants assigned to this course.
 *
 * I have not used Java language code obtained from another student, or any other unauthorized source, 
either modified or unmodified.
 *
 * If any Java language code or documentation used in my program was obtained from another source, 
such as a text book or course notes, that has been clearly noted with a proper citation in the comments of my program.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import javax.swing.*; 
import java.awt.geom.*; 
import java.awt.*; 

public class EmojiComp extends JComponent
{
    private int width; 
    private int height;
    private Emoji upsideDown; 
    private Graphics2D g2d; 
    private AffineTransform res; 
    
    private int size; 
    
    public EmojiComp(int w, int h)
    {
        width = w; 
        height = h; 
        size = 100; 
        upsideDown = new Emoji(w / 2 - size / 2, h / 2 - size / 2, size, 0, Color.YELLOW); 
    }
    
    protected void paintComponent(Graphics g)
    {
        g2d = (Graphics2D) g; 
        
        RenderingHints rh = 
        new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); 
        g2d.setRenderingHints(rh); 
        
        res = g2d.getTransform(); 
        
        upsideDown.drawEmoji(g2d, res); 
    }
    
    public Emoji getEmoji()
    {
        return upsideDown; 
    }
}
