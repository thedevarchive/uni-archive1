
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
 * Line creates lines that will be used to draw some parts of the greeting card. A line can be created 
 * using two points
 * 
 * @author Alyssa Mae Ngo (153023) 
 * @version April 14, 2017
 */
import java.awt.*; 
import java.awt.geom.*; 
public class Line implements DrawingObject
{
    // instance variables - replace the example below with your own
    private double x1;
    private double y1; 
    private double x2; 
    private double y2; 
    private double length; 
    private double iX; 
    private double iY; 
    private double xNY; 

    /**
     * Constructor for objects of class Line
     * 
     * The constructor requires four doubles that would serve as the two points to draw a line to, since
     * two points are needed to draw a line. 
     * 
     * @param  a1   first point's x-coordinate
     * @param  b1   first point's y-coordinate
     * @param  a2   second point's x-coordinate
     * @param  b2   second point's y-coordinate
     */
    public Line(double a1, double b1, double a2, double b2)
    {
        x1 = a1; 
        y1 = b1; 
        x2 = a2; 
        y2 = b2; 
        iX = Math.pow(x2 - x1, 2); 
        iY = Math.pow(y2 - y1, 2); 
        length = Math.sqrt(iX + iY);
    }
    
    /**
     * This will be the method that will draw the shape indicated in the class name. 
     * 
     * @param  g2d   Graphics2D that will draw the Line
     * @param  at    AffineTransform that will draw the Line
     */
    public void draw(Graphics2D g2d, AffineTransform at)
    {
        Line2D.Double l = new Line2D.Double(x1, y1, x2, y2); 
        g2d.setColor(Color.BLACK);
        g2d.draw(l); 
    }
    
    /**
     * This method is left blank since this will not animated. 
     */
    public void animate()
    {
    }
}
