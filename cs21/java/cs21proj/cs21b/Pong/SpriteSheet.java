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
 * SpriteSheet extracts the sprite sheets that will be used in the game. 
 * 
 * This is where we got how to make a SpriteSheet class. 
 * https://www.youtube.com/watch?v=jedilHUPO7c
 * 
 * @author Alyssa Mae Ngo and Lian Santos
 * @version May 21, 2017
 */
import java.awt.image.BufferedImage;
public class SpriteSheet
{
    public BufferedImage spriteSheet;
    
    public SpriteSheet(BufferedImage ss)
    {
        this.spriteSheet = ss;
    }
    
    public BufferedImage grabSprite(int x, int y, int w, int h)
    {
        BufferedImage sprite = spriteSheet.getSubimage(x,y,w,h);
        return sprite;
    }
}
