
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
 * Egg here simply refers to the ellipse shape that will be created from this class. 
 * It is titled Egg since the ellipse will serve as the egg in the animation.
 * 
 * @author Alyssa Mae Ngo (153023) 
 * @version April 14, 2017
 */
import java.awt.*; 
import java.awt.geom.*; 
public class Egg implements DrawingObject
{
    // instance variables - replace the example below with your own
    private double x;
    private double y; 
    private double width; 
    private double length; 
    private Color eCol; 
    private double speed; 
    private int call; 
    private int rot = 0; 

    /**
     * Constructor for objects of class Egg
     * 
     * This asks for the x-position, y-position, width, length, and color of the ellipse to be drawn. 
     * 
     * @param  a   the x-position of the ellipse
     * @param  b   the y-position
     * @param  w   the width (or the length between both ends of the ellipse horizontally)
     * @param  l   the length (or the length between both ends of the ellipse vertically)
     * @param  c   the color of the ellipse to be drawn 
     */
    public Egg(double a, double b, double w, double l, Color c)
    {
        x = a; 
        y = b; 
        width = w; 
        length = l; 
        eCol = c; 
        speed = 6; 
    }

    /**
     * ADDITIONAL METHOD: incX
     * Added just to give horizontal movement to the Egg instances. 
     * 
     * @param  a   change or step in the x-position of the Egg
     */
    public void incX(double a)
    {
        x += a; 
    }

    /**
     * ADDITIONAL METHOD: incY
     * Added just to give vertical movement to the Egg instances. 
     * 
     * @param  a   change or step in the y-position of the Egg
     */
    public void incY(double b)
    {
        y += b; 
    }
    
    /**
     * ADDITIONAL METHOD: stop
     * This sets the speed of the Egg to 0, stopping the animation. 
     */
    public void stop()
    {
        speed = 0; 
    }

    /**
     * ADDITIONAL METHOD: getRotAng
     * This gets the rotation angle of the Egg.  
     * 
     * @return  rot   the current rotation angle of the Egg
     */
    public int getRotAng()
    {
        return rot; 
    }
    
    /**
     * ADDITIONAL METHOD: getWidth
     * This gets the width (horizontal diameter) of the Egg.
     * 
     * @return  width   the current width of the Egg
     */
    public double getWidth()
    {
        return width; 
    }
    
    /**
     * ADDITIONAL METHOD: getLength
     * This sets the height (vertical diameter) of the Egg.  
     * 
     * @return  height   the current height of the Egg
     */
    public double getLength()
    {
        return length; 
    }
    
    /**
     * ADDITIONAL METHOD: getX
     * Returns the x-coordinate of an Egg object when called. 
     * 
     * @return  x   the x-position of the Egg
     */
    public double getX()
    {
        return x; 
    }
    
    /**
     * ADDITIONAL METHOD: incY
     * Returns y-coordinate of the Egg. 
     * 
     * @return  y   the y-position of the Egg
     */
    public double getY()
    {
        return y; 
    }
    
    /**
     * This will be the method that will draw the shape indicated in the class name. 
     * 
     * @param  g2d   Graphics2D that will draw the Egg
     * @param  at    AffineTransform that will draw the Egg
     */
    public void draw(Graphics2D g2d, AffineTransform at)
    {
        Ellipse2D.Double e = new Ellipse2D.Double(x, y, width, length); 
        g2d.setColor(eCol); 
        g2d.fill(e); 
    }
    
    /**
     * This animates the Egg. 
     * Depending on the variable call, which determines how many times the DrawingComponent calls this
     * method, the Egg objects will be animated in various ways. 
     */
    public void animate()
    {
        if(y <= 400)
        {
            if(call <= 20)
                this.incX(speed); 
            else
            {
                this.incY(speed); 
            }
        }
        else
        {
            this.stop(); 
        }

        if(call >= 50 && length <= 200)
        {
            length += 10; 
            width += 20; 
            x += 5; 
            y -= 10; 
        }

        if(call >= 80 && call < 88)
        {
            if(call % 4 == 0)
            {
                rot = 45; 
            }
            else if (call % 4 == 1)
            {
                rot = 0;
            }
            else if (call % 4 == 2)
            {
                rot = -45; 
            }
            else
            {
                rot = 0; 
            }
        }

        call++; 
    }
}
