
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
 * ChickenWire is one of the other composite shapes that will be used in the greeting card. 
 * It serves as one of the objects in the backdrop. 
 * 
 * @author Alyssa Mae Ngo (153023) 
 * @version April 15, 2017
 */
import java.awt.*; 
import java.awt.geom.*; 
public class ChickenWire implements DrawingObject
{
    // instance variables - replace the example below with your own
    private double x; 
    private double y; 
    private double length; 
    private double gap; 
    private double temp; 

    /**
     * Constructor for objects of class JavaChicken
     * 
     * This will set the position of the JavaChicken object based on the input, and will set up the 
     * chicken for drawing. (Size is not a parameter of this constructor since it will be complicated to
     * adjust the size of the parts of the JavaChicken object. 
     * 
     * @param  a   x-coordinate of the chicken to be drawn (starts with the chicken's head)
     * @param  b   y-coordinate of the chicken
     * @param  l   length of the lines in the ChickenWire object (determines the second point of the line)
     * @param  g   gap between the lines to be drawn
     * 
     */
    public ChickenWire(double a, double b, double l, double g)
    {
        x = a; 
        y = b; 
        length = l; 
        gap = g; 
        temp = x; 
    }

    /**
     * This will be the method that will draw the shape indicated in the class name. 
     * 
     * @param  g2d   Graphics2D that will draw the ChickenWire 
     * @param  at    AffineTransform that will draw the ChickenWire 
     */
    public void draw(Graphics2D g2d, AffineTransform at)
    {
        Line l1 = new Line(temp, y, temp + length, y + length);
        l1.draw(g2d, at); 
        temp += gap; 
        Line l2 = new Line(temp, y, temp + length, y + length); 
        l2.draw(g2d, at);  
        temp += gap;  
        Line l3 = new Line(temp, y, temp + length, y + length);
        l3.draw(g2d, at); 
        temp += gap;  
        Line l4 = new Line(temp, y, temp + length, y + length);
        l4.draw(g2d, at);  
        temp += gap; 
        Line l5 = new Line(temp, y, temp + length, y + length);
        l5.draw(g2d, at); 
        temp += gap; 
        Line l11 = new Line(temp, y, temp + length, y + length);
        l11.draw(g2d, at);
        temp += gap;   
        Line l13 = new Line(temp, y, temp + length, y + length);
        l13.draw(g2d, at); 
        temp += gap; 
        Line l15 = new Line(temp, y, temp + length, y + length);
        l15.draw(g2d, at);
        temp = x; 
        Line l6 = new Line(temp, y + length, temp + length, y); 
        l6.draw(g2d, at);  
        temp += gap; 
        Line l7 = new Line(temp, y + length, temp + length, y);
        l7.draw(g2d, at); 
        temp += gap; 
        Line l8 = new Line(temp, y + length, temp + length, y);
        l8.draw(g2d, at); 
        temp += gap; 
        Line l9 = new Line(temp, y + length, temp + length, y);
        l9.draw(g2d, at); 
        temp += gap; 
        Line l10 = new Line(temp, y + length, temp + length, y); 
        l10.draw(g2d, at); 
        temp += gap; 
        Line l12 = new Line(temp, y + length, temp + length, y);
        l12.draw(g2d, at); 
        temp += gap;
        Line l14 = new Line(temp, y + length, temp + length, y);
        l14.draw(g2d, at); 
        temp += gap; 
    }
    /**
     * This method is left blank since this will not be animated. 
     */
    public void animate()
    {
    }
}
