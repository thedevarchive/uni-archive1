import java.awt.*;
import java.awt.event.*; 
import java.awt.geom.*;
import javax.swing.*;
import javafx.scene.input.KeyCode; 

public class DrawingComponentKL extends JComponent implements Runnable{

    private MyCircle c;
    private MyKeyListener mkl; 
    private JFrame frame; 
    private boolean running; 
    private int delay; 
    private double speed; 

    public DrawingComponentKL(JFrame f) {
        c = new MyCircle(100, 100, 25, Color.BLACK);
        frame = f; 
        running = false; 
        delay = 25; 
        speed = 5; 
    }
    
    public void run() 
    {
        while(running)
        {
            c.incX(speed); 
            repaint(); 
            try
            {
                Thread.sleep(delay); 
            }
            catch (InterruptedException ex)
            {
                System.out.println("this is an error"); 
            }
            if(c.getX() >= 400 || c.getX() <= 0)
            {
                speed = -speed; 
            }
        }
    }

    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        AffineTransform reset = g2d.getTransform();
        
        RenderingHints rh = new RenderingHints(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        g2d.setRenderingHints(rh);

        c.drawObject(g2d,reset);
    }
    
    public void activateKL()
    {
        mkl = new MyKeyListener(); 
        frame.getContentPane().addKeyListener(mkl); 
        frame.getContentPane().setFocusable(true); 
    }
    
    class MyKeyListener implements KeyListener 
    {
        //private DrawingComponentKL parent = DrawingComponentKL.this; 
        public void keyTyped(KeyEvent e)
        {
            System.out.println("key typed"); 
        }
        
        public void keyPressed(KeyEvent e)
        {
            if(e.getKeyCode() == KeyEvent.VK_SPACE)
            {
                Thread t1 = new Thread(DrawingComponentKL.this); 
                if(!running)
                {
                    running = true; 
                    t1.start(); 
                    System.out.println("Start animation: " + running); 
                }
                else
                {
                    running = false; 
                }
            }
            //parent.repaint(); 
        }
        
        public void keyReleased(KeyEvent e)
        {
            System.out.println("key released"); 
        }
    }

    public static void main(String[] args) {
        JFrame f = new JFrame();
        DrawingComponentKL dckl = new DrawingComponentKL(f);

        dckl.activateKL(); 
        
        f.getContentPane().setPreferredSize(new Dimension(400, 400));
        f.setTitle("Key Listener");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(dckl);
        f.pack();
        f.setVisible(true);
        
        /*Thread t1 = new Thread(dckl); 
        t1.start(); */
    }
}

