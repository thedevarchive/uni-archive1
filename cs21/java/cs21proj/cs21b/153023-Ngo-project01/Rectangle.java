
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
 * Rectangle is one of the shapes that will be used in the greeting card. 
 * A rectangle by definition has four right angles and have two pairs (each pair having differing 
 * lengths) of equal sides. 
 * 
 * @author Alyssa Mae Ngo (153023) 
 * @version April 14, 2017
 */
import java.awt.*; 
import java.awt.geom.*; 
public class Rectangle implements DrawingObject
{
    // instance variables - replace the example below with your own
    private double x;
    private double y; 
    private double length; 
    private double width; 
    private Color rCol; 
    private int call; 

    /**
     * Constructor for objects of class Rectangle
     */
    public Rectangle(double a, double b, double w, double l, Color c)
    {
        x = a; 
        y = b; 
        length = l; 
        width = w; 
        rCol = c; 
    }

    /**
     * ADDITIONAL METHOD: incX
     * Added just to give horizontal movement to the Rectangle instances. 
     * 
     * @param  a   change or step in the x-position of the Rectangle
     */
    public void incX(double a)
    {
        x += a; 
    }
    
    /**
     * ADDITIONAL METHOD: incY
     * Added just to give vertical movement to the Rectangle instances. 
     * 
     * @param  a   change or step in the y-position of the Rectangle
     */
    public void incY(double b)
    {
        y += b; 
    }
    
    /**
     * This will be the method that will draw the shape indicated in the class name. 
     * 
     * @param  g2d   Graphics2D that will draw the Rectangle
     * @param  at    AffineTransform that will draw the Rectangle
     */
    public void draw(Graphics2D g2d, AffineTransform at)
    {
        Rectangle2D.Double r = new Rectangle2D.Double(x, y, width, length); 
        g2d.setColor(rCol); 
        g2d.fill(r); 
    }
    /**
     * Animates the object. 
     */
    public void animate()
    {
        if(call >= 50)
        {
            this.incY(-15); 
            length += 15; 
        }
        call++; 
    }
}
