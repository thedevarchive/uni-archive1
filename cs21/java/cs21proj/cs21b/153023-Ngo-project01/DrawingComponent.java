
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
 * This is the method that will draw the shape and composite shape objects, and will call the animate()
 * methods of each shape drawn in this class (if any). 
 * 
 * @author Alyssa Mae Ngo (153023) 
 * @version April 15, 2017
 * 
 */
import java.awt.*; 
import java.awt.geom.*; 
import javax.swing.*; 
import java.util.*; 
import java.awt.event.*; 
import javafx.scene.input.KeyCode; 

public class DrawingComponent extends JComponent implements Runnable
{
    private int width; 
    private int height; 
    private JFrame frame; 
    private boolean running; 
    private int delay; 
    private ArrayList<DrawingObject> dos = new ArrayList<DrawingObject>(); 
    private MyKeyListener mkl; 
    private Graphics2D g2d; 
    private MyMouseListener mml; 

    private House h; 
    private Text start; 
    private JavaChicken jc; 
    private Egg e1; 
    private Rectangle grass; 
    private Circle hole; 
    private Text greet; 

    public DrawingComponent(JFrame f)
    {
        frame = f; 
        running = false; 
        delay = 100; 
        start = new Text(0, 200, "PRESS ANY KEY TO START", 28, Color.BLACK);
        h = new House(640, 275, Color.RED, Color.WHITE, 100); 
        dos.add(h); 
        jc = new JavaChicken(-100, 250); 
        e1 = new Egg(-100, 330, 60, 15, Color.LIGHT_GRAY); 
        dos.add(e1); 
        grass = new Rectangle(0, 400, 640, 400, Color.GREEN);
        dos.add(grass); 
        hole = new Circle(200, 250, 0, Color.BLACK); 
        dos.add(hole); 
        greet = new Text(250, -700, "HAPPY EASTER!", 0, Color.MAGENTA); 
        dos.add(greet); 
    }

    protected void paintComponent (Graphics g)
    {
        g2d = (Graphics2D) g; 

        AffineTransform reset = g2d.getTransform();

        RenderingHints rh = 
            new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2d.setRenderingHints(rh);

        Rectangle sky = new Rectangle(0, 0, 640, 480, Color.CYAN); 
        sky.draw(g2d, reset); 

        Circle sun = new Circle(-50, -50, 150, Color.YELLOW); 
        sun.draw(g2d, reset); 

        //move to 250, 200
        h.draw(g2d, reset); 
        
        ChickenWire cw = new ChickenWire(-100, 250, 200, 100); 
        cw.draw(g2d, reset); 

        grass.draw(g2d, reset); 
        g2d.rotate(Math.toRadians(e1.getRotAng()), e1.getWidth() / 2 + e1.getX(), e1.getLength() / 2 + e1.getY()); 

        e1.draw(g2d, reset); 

        jc.draw(g2d, reset);
        dos.add(jc); 

        start.draw(g2d, reset); 
        dos.add(start);

        hole.draw(g2d, reset); 

        greet.draw(g2d, reset); 
    }

    public void activateL()
    {
        mkl = new MyKeyListener(); 
        frame.getContentPane().addKeyListener(mkl); 
        frame.getContentPane().setFocusable(true); 

        mml = new MyMouseListener(); 
        frame.getContentPane().addMouseListener(mml); 
        frame.getContentPane().setFocusable(true); 
    }

    class MyKeyListener implements KeyListener 
    {
        Thread t1 = new Thread(DrawingComponent.this);
        public void keyTyped(KeyEvent e)
        { 

            if(!running)
            {
                running = true; 
                t1.start(); 
            }
        }

        public void keyPressed(KeyEvent e)
        { 
            // I used this to help me find the keys that I should not allow to start the program. 
            // https://docs.oracle.com/javase/7/docs/api/java/awt/event/KeyEvent.html
            if(e.getKeyCode() != KeyEvent.VK_CONTROL && e.getKeyCode() != KeyEvent.VK_CAPS_LOCK &&
            e.getKeyCode() != KeyEvent.KEY_LOCATION_UNKNOWN &&
            e.getKeyCode() != KeyEvent.KEY_LOCATION_NUMPAD && e.getKeyCode() != KeyEvent.VK_TAB &&
            e.getKeyCode() != KeyEvent.VK_SCROLL_LOCK && e.getKeyCode() != KeyEvent.VK_UNDEFINED &&
            e.getKeyCode() != KeyEvent.VK_SHIFT && e.getKeyCode() != KeyEvent.VK_ESCAPE && 
            e.getKeyCode() != KeyEvent.VK_ALT && e.getKeyCode() != KeyEvent.VK_F1 &&
            e.getKeyCode() != KeyEvent.VK_F2 && e.getKeyCode() != KeyEvent.VK_F3 &&
            e.getKeyCode() != KeyEvent.VK_F4 && e.getKeyCode() != KeyEvent.VK_F5 && 
            e.getKeyCode() != KeyEvent.VK_F6 && e.getKeyCode() != KeyEvent.VK_F7 &&
            e.getKeyCode() != KeyEvent.VK_F8 && e.getKeyCode() != KeyEvent.VK_F9 &&
            e.getKeyCode() != KeyEvent.VK_F10 && e.getKeyCode() != KeyEvent.VK_F11 && 
            e.getKeyCode() != KeyEvent.VK_F12)
            {
                if(!running)
                {
                    running = true; 
                    t1.start(); 
                }
            }
        }

        public void keyReleased(KeyEvent e)
        {
        }
    }
    //This is where I learned how to make a MouseListener.
    //I also followed the pattern of how to make a KeyListener. 
    //http://stackoverflow.com/questions/2668718/java-mouselistener
    class MyMouseListener implements MouseListener
    {
        Thread t1 = new Thread(DrawingComponent.this);
        public void mousePressed(MouseEvent e)
        {
            //This is where I learned how to get the source of the mouse clicks and presses. 
            //https://docs.oracle.com/javase/7/docs/api/java/awt/event/MouseEvent.html
            if(e.getButton() == MouseEvent.BUTTON1)
            {
                if(!running)
                {
                    running = true; 
                    t1.start(); 
                }
            }
        }

        public void mouseReleased(MouseEvent e)
        {
        }

        public void mouseEntered(MouseEvent e)
        {
        }

        public void mouseExited(MouseEvent e)
        {
        }

        public void mouseClicked(MouseEvent e)
        {
            if(e.getButton() == MouseEvent.BUTTON1)
            {
                if(!running)
                {
                    running = true; 
                    t1.start(); 
                }
            }
        }
    }

    public void run() 
    {
        while(running)
        {
            animateAll();  
            repaint(); 
            try
            {
                Thread.sleep(delay); 
            }
            catch (InterruptedException ex)
            {
            }
        }
    }

    public void animateAll()
    {
        for (int i = 0; i < dos.size(); i++)
        {
            dos.get(i).animate(); 
        }
    }
}
