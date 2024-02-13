
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
 * Square creates square Graphics that will be used in the making of the greeting card. A square by
 * definition is a quadrilateral with its four sides having equal lengths. 
 * 
 * @author Alyssa Mae Ngo (153023) 
 * @version April 14, 2017
 */
import java.awt.*; 
import java.awt.geom.*; 

public class Square implements DrawingObject
{
    // instance variables - replace the example below with your own
    private double x;
    private double y; 
    private double size; 
    private int stroke = 0; 
    private Color sqCol; 

    /**
     * Constructors for class Square. Generally, all Square instances need the x-coordinate, y-coordinate,
     * and size defined. These constructors initializes these along with either stroke thickness, color, 
     * or both. 
     * 
     * The first constructor for Square is used to draw a square with a defined stroke. 
     * All Square instatiated by the constructor will have no color. 
     * 
     * @param  a     the x-coordinate where the drawing of the square will start
     * @param  b     the y-coordinate where the drawing of the square will start
     * @param  sz    the length of one side of the square (a square has four equal sides)
     * @param  strk  the stroke thickness of the square
     */
    public Square(double a, double b, double sz, int strk)
    {
        x = a; 
        y = b; 
        size = sz; 
        stroke = strk; 
    }
    /**
     * The second constructor for Square is used to draw a Square with color.  
     * All Square instances will have the default stroke (1). 
     * 
     * @param  a     the x-coordinate where the drawing of the square will start
     * @param  b     the y-coordinate where the drawing of the square will start
     * @param  sz    the length of one side of the square (a square has four equal sides)
     * @param  c     the color of the square
     */
    public Square(double a, double b, double sz, Color c)
    {
        x = a; 
        y = b; 
        size = sz; 
        sqCol = c; 
    }
    /**
     * The third constructor for Square is used to draw a Square with a defined color and stroke. 
     * 
     * @param  a     the x-coordinate where the drawing of the square will start
     * @param  b     the y-coordinate where the drawing of the square will start
     * @param  sz    the length of one side of the square (a square has four equal sides)
     * @param  strk  the stroke thickness of the square
     * @param  c     the color of the square
     */
    public Square(double a, double b, double sz, int strk, Color c)
    {
        x = a; 
        y = b; 
        size = sz; 
        stroke = strk; 
        sqCol = c; 
    }

    /**
     * ADDITIONAL METHOD: incX
     * Added just to give horizontal movement to the Square instances. 
     * 
     * @param  a   change of step in the x-position of the square
     */
    public void incX(double a)
    {
        x += a; 
    }
    
    /**
     * ADDITIONAL METHOD: incY
     * Added just to give vertical movement to the Square instances. 
     * 
     * @param  a   change of step in the y-position of the square
     */
    public void incY(double b)
    {
        y += b; 
    }
    
    /**
     * This will be the method that will draw the shape indicated in the class name. 
     * Has condition statements for the stroke and color. 
     * 
     * @param  g2d   Graphics2D that will draw the Square
     * @param  at    AffineTransform that will draw the Square
     */
    public void draw(Graphics2D g2d, AffineTransform at)
    {
        Rectangle2D.Double sq = new Rectangle2D.Double(x, y, size, size); 
        if(stroke != 0 && sqCol == null)
        {
            //This is where I learned how to thicken a stroke in Java. 
            //http://stackoverflow.com/questions/2839508/java2d-increase-the-line-width
            g2d.setStroke(new BasicStroke(stroke)); 
            g2d.setColor(Color.BLACK); 
            g2d.draw(sq); 
        }
        else if (sqCol != null && stroke == 0)
        {
            g2d.setColor(sqCol); 
            g2d.fill(sq); 
        }
        else 
        {
            g2d.setStroke(new BasicStroke(stroke)); 
            g2d.setColor(sqCol); 
            g2d.fill(sq);  
            g2d.setColor(Color.BLACK); 
            g2d.draw(sq); 
        }
    }
    
    /**
     * This animates the Square instance.  
     */
    public void animate()
    {
    }
}
