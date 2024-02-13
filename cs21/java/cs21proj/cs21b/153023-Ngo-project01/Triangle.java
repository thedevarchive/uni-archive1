
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
 * Triangle creates a triangle using the Path2D tool. The triangle shapes made out of it will be used in 
 * the animation. 
 * 
 * @author Alyssa Mae Ngo (153023) 
 * @version April 10, 2017
 */
import java.awt.*; 
import java.awt.geom.*; 
public class Triangle implements DrawingObject
{
    // instance variables - replace the example below with your own
    private double x1; 
    private double y1; 
    private double x2; 
    private double y2; 
    private double x3; 
    private double y3; 
    private Color tCol; 

    /**
     * Constructor for objects of class Triangle. It takes in three points that will draw the triangle. 
     * 
     * @param  a1   x-coordinate of the first point of the triangle to be drawn
     *              starting x-coordinate of the triangle that will be drawn
     * @param  b1   y-coordinate of the first point of the triangle
     *              starting y-coordinate of the triangle to be drawn
     * @param  a2   x-coordinate of the second point of the triangle
     * @param  b2   y-coordinate of the second point
     * @param  a3   x-coordinate of the third point
     * @param  b3   y-coordinate of the third point
     * @param  c    the color that will be used to fill the triangle with
     */
    public Triangle(double a1, double b1, double a2, double b2, double a3, double b3, Color c)
    {
        x1 = a1; 
        y1 = b1; 
        x2 = a2; 
        y2 = b2; 
        x3 = a3; 
        y3 = b3; 
        tCol = c; 
    }

    /**
     * ADDITIONAL METHOD: incX
     * Added just to give horizontal movement to the Triangle instances. 
     * 
     * @param  a   change or step in the x-position of the triangle
     */
    public void incX(double a)
    {
        x1 += a; 
        x2 += a; 
        x3 += a; 
    }
    
    /**
     * ADDITIONAL METHOD: incY
     * Added just to give vertical movement to the Triangle instances. 
     * 
     * @param  a   change or step in the y-position of the triangle
     */
    public void incY(double b)
    {
        y1 += b; 
        y2 += b; 
        y3 += b; 
    }
    
    /**
     * This will be the method that will draw the shape indicated in the class name. 
     * 
     * @param  g2d   Graphics2D that will draw the Triangle
     * @param  at    AffineTransform that will draw the Triangle
     */
    public void draw(Graphics2D g2d, AffineTransform at)
    {
        Path2D.Double t = new Path2D.Double(); 
        t.moveTo(x1, y1); 
        t.lineTo(x2, y2); 
        t.lineTo(x3, y3); 
        t.lineTo(x1, y1); 
        g2d.setColor(tCol); 
        g2d.fill(t); 
    }
    
    /**
     * This is left blank since it will not be used in the animation. 
     */
    public void animate()
    {
    }
}
