
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
 * Text displays text in the greeting card. 
 * 
 * @author Alyssa Mae Ngo (153023) 
 * @version April 10, 2017
 */
import java.awt.*; 
import java.awt.geom.*;
public class Text implements DrawingObject
{
    // instance variables - replace the example below with your own
    private int x;
    private int y; 
    private String message;
    private int fontSize; 
    private int call = 0; 
    private Color tCol; 
    
    /**
     * Constructor for objects of class Text
     */
    public Text(int a, int b, String m, int fs, Color c)
    {
        x = a; 
        y = b; 
        message = m; 
        fontSize = fs; 
        tCol = c; 
    }

    /**
     * ADDITIONAL METHOD: incX
     * Added just to give horizontal movement to the Text instances. 
     * 
     * @param  a   change or step in the x-position of the Text
     */
    public void incX(double a)
    {
        x += (int) a; 
    }

    /**
     * ADDITIONAL METHOD: incY
     * Added just to give vertical movement to the Text instances. 
     * 
     * @param  a   change or step in the y-position of the Text
     */
    public void incY(double b)
    {
        y += (int) b; 
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public void draw(Graphics2D g2d, AffineTransform at)
    {
        // This is where I learned to set fonts. 
        // http://stackoverflow.com/questions/18249592/how-to-change-font-size-in-drawstring-java
        Font myFont = new Font("Helvetica", 1, fontSize); 
        g2d.setFont(myFont); 
        // This is where I learned how to make text in Graphics. 
        // http://www.javaworld.com/article/2076869/learn-java/drawing-text-is-easy-with-three-java-classes.html
        g2d.setColor(tCol); 
        g2d.drawString(message, x, y); 
    }

    public void animate()
    {
        if(call <= 100)
            y += 10; 
        else if (call >= 100 && fontSize <= 35)
        {
            fontSize += 5; 
            this.incX(-10); 
            this.incY(-30);
        }
        call++; 
    }
}
