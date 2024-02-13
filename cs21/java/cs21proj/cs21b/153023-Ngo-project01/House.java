
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
 * House is one of the composite shapes that will be used in the greeting card. 
 * It serves as an object in the backdrop of the card. 
 * 
 * @author Alyssa Mae Ngo (153023) 
 * @version April 14, 2017
 */
import java.awt.*; 
import java.awt.geom.*; 
public class House implements DrawingObject
{
    // instance variables - replace the example below with your own
    private double x;
    private double y; 
    private Color roofC;
    private Color baseC; 
    private Triangle roof; 
    private Square base; 
    private double speed; 
    private double size; 

    private int call; 

    /**
     * Constructor for objects of class House
     * 
     * This will make the House instances. It only requires one x- and y-coordinate and two colors for 
     * the roof and the front wall of the house. 
     * 
     * The roof will drawn using a Triangle. x and y represent the position of the first point. 
     * The x-coordinate of the second point is determined by adding half of x to (the original) size, 
     * while the y-coordinate is determined by adding 1/3 of size to y. 
     * For the third point's x-coordinate, half of x is subtracted to the (original) value of size, 
     * and the y-coordinate's value is obtained just like with the second point. 
     * 
     * The front wall of the house's position is determined by the roof's third point's coordinates, and
     * the size by its x value. 
     * 
     * @param  a   starting x-coordinate that will start the drawing of the House object
     * @param  b   starting y-coordinate that will start the drawing of the House object
     * @param  r   color of the roof (the triangle portion of the House)
     * @param  ba  color of the front wall of the house (square portion)
     * @param  sz  size of the square
     */
    public House(double a, double b, Color r, Color ba, double sz)
    {
        x = a; 
        y = b; 
        roofC = r; 
        baseC = ba; 
        size = sz;
        roof = new Triangle(x, y, x + (size / 2), y + (size / 3), x - (size / 2), y + (size / 3), roofC); 
        base = new Square(x - (size / 2), y + (size / 3), size, baseC); 
        speed = -10; 
    }

    /**
     * ADDITIONAL METHOD: getX
     * Gets the x-coordinate of the House instance that could be used by other classes. 
     */
    public double getX()
    {
        return x; 
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
     * This will be the method that will draw the shape indicated in the class name. 
     * 
     * @param  g2d   Graphics2D that will draw the House
     * @param  at    AffineTransform that will draw the House
     */
    public void draw(Graphics2D g2d, AffineTransform at)
    {
        roof.draw(g2d, at); 
        base.draw(g2d, at); 
    }

    /**
     * This animates the House. 
     */
    public void animate()
    {
        if(call <= 5)
        {
            roof.incX(speed); 
            base.incX(speed);
        }
        call++; 
    }
}
