
/**
 * Write a description of class FrameTester here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FrameTester
{
    public static void main(String args[])
    {
        int w = 640; 
        int h = 480; 
        MyFrame f = new MyFrame(w, h); 
        f.setup(); 
        f.activateButtons(); 
    }
}
