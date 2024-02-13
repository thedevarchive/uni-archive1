
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
 * JavaChicken is one of the main composite shapes that will be animated in the foreground. 
 * 
 * @author Alyssa Mae Ngo (153023) 
 * @version April 13, 2017
 */
import java.awt.*; 
import java.awt.geom.*; 
public class JavaChicken implements DrawingObject
{
    // instance variables - replace the example below with your own
    private double x;
    private double y; 
    private Color roofC;
    private Color baseC; 
    
    private double speed; 
    
    private Circle head; 
    private Circle comb1; 
    private Circle comb2; 
    private Circle comb3; 
    private Circle eye; 
    private Triangle beak; 
    private Circle neck; 
    private Egg body;
    private Rectangle leg; 
    private Rectangle foot; 

    /**
     * Constructor for objects of class JavaChicken
     * 
     * This will set the position of the JavaChicken object based on the input, and will set up the 
     * chicken for drawing. (Size is not a parameter of this constructor since it will be complicated to
     * adjust the size of the parts of the JavaChicken object.)
     * 
     * @param  a   x-coordinate of the chicken to be drawn (starts with the chicken's head)
     * @param  b   y-coordinate of the chicken
     * 
     */
    public JavaChicken(double a, double b)
    {
        x = a; 
        y = b; 
        speed = 1; 
        comb1 = new Circle(x - 10, y - 3, 30, 3, Color.ORANGE);
        comb2 = new Circle(x + 15, y - 15, 30, 3, Color.ORANGE); 
        comb3 = new Circle(x + 40, y - 3, 30, 3, Color.ORANGE); 
        beak = new Triangle(x + 30, y + 30, x + 30, y + 50, x + 90, y + 40, Color.ORANGE); 
        head = new Circle(x, y, 60, Color.WHITE); 
        eye = new Circle(x + (40), y + (20), 10, Color.BLACK); 
        
        neck = new Circle(x - 20, y + 40, 90, Color.WHITE); 
        body = new Egg(x - 120, y + 60, 180, 120, Color.WHITE); 
        
        leg = new Rectangle(x - 30, y + 180, 10, 50, Color.ORANGE); 
        foot = new Rectangle(x - 30, y + 220, 30, 10, Color.ORANGE); 
    }

    /**
     * This will be the method that will draw the shape indicated in the class name. 
     * 
     * @param  g2d   Graphics2D that will draw the JavaChicken. 
     * @param  at    AffineTransform that will draw the JavaChicken. 
     */
    public void draw(Graphics2D g2d, AffineTransform at)
    {
        comb1.draw(g2d, at); 
        comb2.draw(g2d, at); 
        comb3.draw(g2d, at); 
        beak.draw(g2d, at); 
        head.draw(g2d, at); 
        eye.draw(g2d, at); 
        
        neck.draw(g2d, at); 
        body.draw(g2d, at); 
        
        leg.draw(g2d, at); 
        foot.draw(g2d, at); 
    }

    /**
     * Animates each part of the JavaChicken. 
     */
    public void animate()
    {
        comb1.incX(speed); 
        comb2.incX(speed); 
        comb3.incX(speed);  
        beak.incX(speed); 
        head.incX(speed); 
        eye.incX(speed); 
        
        neck.incX(speed); 
        body.incX(speed); 
        
        leg.incX(speed); 
        foot.incX(speed);  
    }
}
