
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
 * DrawingObject is an interface that provides the draw and animate method, that will be defined by the 
 * classes that will implement it. 
 * 
 * @author Alyssa Mae Ngo (153023)
 * @version March 30, 2017
 */
import java.awt.geom.*; 
import java.awt.*; 

public interface DrawingObject
{
    /**
     * This method draws the shape indicated in the class name.
     * 
     * @param  g2d    the Graphics2D that will draw the shape 
     * @param  at     the AffineTransform that will be used in drawing the shape 
     */
    void draw(Graphics2D g2d, AffineTransform at);
    /**
     * This method makes the drawn shape move.
     */
    void animate();
}
