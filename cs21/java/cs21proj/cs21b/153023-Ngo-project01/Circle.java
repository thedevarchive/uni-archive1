
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
 * Circle creates circle Graphics that will be used to draw the greeting card. A circle by definition has
 * a point in the center that has equal distance to a set of points. 
 * 
 * @author Alyssa Mae Ngo (153023) 
 * @version April 14, 2017
 */

import java.awt.*; 
import java.awt.geom.*; 

public class Circle implements DrawingObject
{
    private double x;
    private double y; 
    private double size; 
    private int stroke = 0; 
    private Color cCol; 
    private int call = 0;

    /**
     * Constructors for class Circle. Generally, all Circle instances need the x-coordinate, y-coordinate,
     * and diameter length defined. These constructors initializes these along with either stroke 
     * thickness, color, or both. 
     * 
     * The first constructor for Circle is used to draw a circle with a defined stroke. 
     * All Circle instatiated by the constructor will have no color. 
     * 
     * @param  a     the x-coordinate where the drawing of the circle will start
     * @param  b     the y-coordinate where the drawing of the circle will start
     * @param  sz    the diameter of the circle
     * @param  strk  the stroke thickness of the circle
     */
    public Circle(double a, double b, double sz, int strk)
    {
        x = a; 
        y = b; 
        size = sz; 
        stroke = strk; 
    }
    /**
     * The second constructor for Circle is used to draw a Circle with color.  
     * All Circle instances will have the default stroke (1). 
     * 
     * @param  a     the x-coordinate where the drawing of the circle will start
     * @param  b     the y-coordinate where the drawing of the circle will start
     * @param  sz    the diameter of the circle
     * @param  c     the color of the circle
     */
    public Circle(double a, double b, double sz, Color c)
    {
        x = a; 
        y = b; 
        size = sz; 
        cCol = c; 
    }
    /**
     * The third constructor for Circle is used to draw a Circle with a defined color and stroke. 
     * 
     * @param  a     the x-coordinate where the drawing of the circle will start
     * @param  b     the y-coordinate where the drawing of the circle will start
     * @param  sz    the diameter of the circle
     * @param  strk  the stroke thickness of the circle
     * @param  c     the color of the circle
     */
    public Circle(double a, double b, double sz, int strk, Color c)
    {
        x = a; 
        y = b; 
        size = sz;
        stroke = strk; 
        cCol = c; 
    }

    /**
     * ADDITIONAL METHOD: incX
     * Added just to give horizontal movement to the Circle instances. 
     * 
     * @param  a   change or step in the x-position of the circle
     */
    public void incX(double a)
    {
        x += a; 
    }
    
    /**
     * ADDITIONAL METHOD: incY
     * Added just to give vertical movement to the Circle instances. 
     * 
     * @param  a   change or step in the y-position of the circle
     */
    public void incY(double b)
    {
        y += b; 
    }
    
    /**
     * This will be the method that will draw the shape indicated in the class name. 
     * Has condition statements for the stroke and color. 
     * 
     * @param  g2d   Graphics2D that will draw the Circle
     * @param  at    AffineTransform that will draw the Circle
     */
    public void draw(Graphics2D g2d, AffineTransform at)
    {
        Ellipse2D.Double c = new Ellipse2D.Double(x, y, size, size); 
        if(stroke != 0 && cCol == null)
        {
            //This is where I learned how to thicken a stroke in Java. 
            //http://stackoverflow.com/questions/2839508/java2d-increase-the-line-width
            g2d.setStroke(new BasicStroke(stroke)); 
            g2d.setColor(Color.BLACK); 
            g2d.draw(c); 
        }
        else if (cCol != null && stroke == 0)
        {
            g2d.setColor(cCol); 
            g2d.fill(c); 
        }
        else 
        {
            g2d.setStroke(new BasicStroke(stroke)); 
            g2d.setColor(cCol); 
            g2d.fill(c);  
            g2d.setColor(Color.BLACK); 
            g2d.draw(c); 
        }
    }
    
    /**
     * This method is left blank since this will not animated. 
     */
    public void animate()
    {
        if(call >= 90 && call <= 100)
        {
            size = 90; 
        }
        call++; 
    }
}
