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
 * BufferedImageLoader creates the images that will be used in the game.  
 * 
 * This is where we also got how to make a BufferedImageLoader class. 
 * https://www.youtube.com/watch?v=jedilHUPO7c
 * 
 * @author Alyssa Mae Ngo and Lian Santos
 * @version May 21, 2017
 */
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
public class BufferedImageLoader
{
    /**
     * A method that will load the images. 
     * 
     * @param  pathRelativetoThis   the URL of the image to be used in the game 
     * @return  img   the loaded image
     */
    public BufferedImage loadImage(String pathRelativeToThis) throws IOException
    {
        URL url = this.getClass().getResource(pathRelativeToThis);
        BufferedImage img = ImageIO.read(url);
        return img;
    }
}
