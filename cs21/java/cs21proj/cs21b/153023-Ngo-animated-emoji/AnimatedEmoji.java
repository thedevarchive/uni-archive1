
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
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AnimatedEmoji
{
    public static void main(String args[])
    {
        int w = 640; 
        int h = 480; 
        
        EmojiFrame e = new EmojiFrame(w, h); 
        e.setup();
        e.actvBtns(); 
    }
}
