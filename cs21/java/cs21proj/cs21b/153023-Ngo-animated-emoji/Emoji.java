
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
import java.awt.*; 
import java.awt.geom.*; 

public class Emoji
{
    // instance variables - replace the example below with your own
    private double x;
    private double y; 
    private double size; 
    private double rot; 
    private Color emojiC; 
    
    private double eye1X; 
    private double eye1Y; 
    private double eye2X; 
    private double eye2Y; 
    private double mouthX; 
    private double mouthY; 
    
    /**
     * Constructor for objects of class Emoji
     */
    public Emoji(double a, double b, double s, double r, Color e)
    {
        x = a; 
        y = b; 
        size = s; 
        rot = r; 
        emojiC = e; 
        
        eye1X = x + size / 4; 
        eye1Y = y + size * 3 / 4 - size / 8; 
        eye2X = (x + size * 3 / 4) - size / 8; 
        eye2Y = y + size * 3 / 4 - size / 8;
        mouthX = x + size / 3; 
        mouthY = y + size / 3; 
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public void drawEmoji(Graphics2D g2d, AffineTransform reset)
    {
        Ellipse2D.Double emoji = new Ellipse2D.Double(0, 0, size, size); 
        g2d.translate(x,y);  
        g2d.rotate(Math.toRadians(rot), size / 2, size / 2); 
        g2d.setColor(emojiC); 
        g2d.fill(emoji); 
        g2d.setTransform(reset); 
        
        double eyeSize = size - (size * .85);
        Ellipse2D.Double eye1 = new Ellipse2D.Double(0, 0, eyeSize, eyeSize); 
        g2d.translate(eye1X, eye1Y);
        //Thanks to my father Abell Ngo for helping me with rotation, and how to locate the pivot points. 
        // Thanks to this link for making me realize that you can set the pivot points for rotation. 
        // https://docs.oracle.com/javase/7/docs/api/java/awt/Graphics2D.html
        g2d.rotate(Math.toRadians(rot), size / 4, size / -8); 
        g2d.setColor(Color.BLACK); 
        g2d.fill(eye1); 
        g2d.setTransform(reset); 
        
        Ellipse2D.Double eye2 = new Ellipse2D.Double(0, 0, eyeSize, eyeSize); 
        g2d.translate(eye2X, eye2Y); 
        g2d.rotate(Math.toRadians(rot), size / -8, size / -8); 
        g2d.fill(eye2); 
        g2d.setTransform(reset); 
        
        // These are the links where I learn to draw curves using Path2D
        // http://stackoverflow.com/questions/15864441/how-to-make-a-line-curve-through-points
        // https://docs.oracle.com/javase/7/docs/api/java/awt/geom/Path2D.Double.html
        double ptStrt = size / -8; 
        double ptEnd = size / 2; 
        double midPt = (ptStrt + ptEnd) / 2;
        double cc1 = (ptStrt + midPt) / 2; 
        double cc2 = (ptEnd + midPt) / 2; 
        Path2D.Double mouth = new Path2D.Double(); 
        mouth.moveTo(ptStrt, 0);
        mouth.curveTo(cc1, size / -4, cc2, size / -4, ptEnd, 0); 
        g2d.translate(mouthX, mouthY); 
        g2d.rotate(Math.toRadians(rot), size / 5.5, size / 6); 
        g2d.draw(mouth); 
        g2d.setTransform(reset); 
    }
    
    public void incX(double a)
    {
        x = x + a; 
        eye1X = x + size / 4; 
        eye1Y = y + size * 3 / 4 - size / 8; 
        eye2X = (x + size * 3 / 4) - size / 8; 
        eye2Y = y + size * 3 / 4 - size / 8;
        mouthX = x + size / 3; 
        mouthY = y + size / 3; 
    }
    
    public void incY(double b)
    {
        y = y + b; 
        eye1X = x + size / 4; 
        eye1Y = y + size * 3 / 4 - size / 8; 
        eye2X = (x + size * 3 / 4) - size / 8; 
        eye2Y = y + size * 3 / 4 - size / 8;
        mouthX = x + size / 3; 
        mouthY = y + size / 3; 
    }
    
    public void incSz(double c)
    {
        size = size + c; 
        x = x - c / 2; 
        y = y - c / 2; 
        eye1X = eye1X - c / 4; 
        eye2X = eye2X + c / 8; 
        eye1Y = y + size * 3 / 4 - size / 8; 
        eye2Y = y + size * 3 / 4 - size / 8;
        mouthY = y + size / 3; //mouthY - c / 4; 
        mouthX = x + size / 3; //mouthX - c / 8; 
    }
    //make decSz here
    public void clockwise()
    {
        rot += 90; 
    }
    public void counter()
    {
        rot -= 90; 
    }
}
