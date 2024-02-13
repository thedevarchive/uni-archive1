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
 * PComponent has the graphics of the game, and has most of the content of the game.  
 * 
 * @author Alyssa Mae Ngo and Lian Santos
 * @version May 21, 2017
 */

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.io.*;
import java.net.*;
import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
public class PComponent extends JComponent
{
    private Container contentPane;
    private int playerID; 
    private PlayerSprite me;
    private PlayerSprite me2; 
    private MenuScreen ms;
    private boolean up, down, left, right;
    private boolean inlevel = false;
    private int hp = 4;
    private boolean pAlive = true;
    private int pAnimCounter;
    private Timer animationTimer;
    private TalkToServerThread ttst;
    private ListenToServerThread ltst;
    private Ball ball;
    private DataInputStream dataIn;
    private DataOutputStream dataOut;
    private Socket socket;
    private int bxmove,bymove;
    private boolean start = true;
    private boolean gover = false;
    /**
     * Constructor for PComponent
     * 
     * @param  cp   the content pane of the GUI
     * @param  s    the socket of the client
     * @param  dis  the DataInputStream to be used to receive data
     * @param  dos  the DataOutputStream to be used to get data
     * @param  id   the ID of the player (whether they are player 1 or 2)
     */
   public PComponent(Container cp, Socket s, DataInputStream dis, DataOutputStream dos, int id)
   {
       contentPane = cp;
       socket = s;
       dataIn = dis;
       dataOut = dos;
       playerID = id;
       if (playerID == 1) {
            me = new PlayerSprite(100, 624,true);
            me2 = new PlayerSprite(0, 0,false);
        } else {
            me2 = new PlayerSprite(100, 624,true);
            me = new PlayerSprite(0,0,false);
        }
        ms = new MenuScreen(0,720,Color.WHITE);
       ball = new Ball(270,310);
       ltst = new ListenToServerThread();
       ttst = new TalkToServerThread();
   }
   /**
    * Draws the graphics of the game. Where most of the game happens. 
    * 
    * @param  g   the Graphics used to draw the game and the sprites
    */
   protected void paintComponent(Graphics g)
   {
       Graphics2D g2d = (Graphics2D) g;
       AffineTransform reset = g2d.getTransform();
       RenderingHints rh = new RenderingHints(
       RenderingHints.KEY_ANTIALIASING,
       RenderingHints.VALUE_ANTIALIAS_ON);
       ms.draw(g2d,reset);  
       me.draw(g2d,reset);
       me2.draw(g2d,reset);
       ball.draw(g2d,reset);
   }
   /**
    * Creates  a repaint timer that would redraw the game and sprites over and over to animate the game. 
    * This also handles the collision
    */
   public void setUpRepaintTimer() {
        int interval = 10;
        ActionListener al = new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                    int speed = 5;      
                    if(me.getHP()>0)
                            {
                                if(left) 
                                {
                                    if(me.getX()>=0)
                                    me.moveH(-speed);
                                } 
                                else if(right) 
                                {
                                    if(me.getX()<=640-96)
                                    me.moveH(speed);

                            
                                }
                        }
                    if(playerID == 1)
                    {
                        if(start)
                        {
                            ball.moveV(1);
                            if(me.getY() == ball.getY())
                            {
                                if(me.getX()<ball.getX() && me.getX()+32>=ball.getX())
                                {
                                    bxmove = -4;
                                    bymove = -4;
                                    start = false;
                                }
                                else if(me.getX()+32<ball.getX() && me.getX()+64>=ball.getX())
                                {
                                    bxmove = 0;
                                    bymove = -4;
                                    start = false;
                                }
                                else if(me.getX()+64<ball.getX() && me.getX()+96>=ball.getX())
                                {
                                    bxmove = +4;
                                    bymove = -4;
                                    start = false;
                                }
                            }
                        }
                        else
                        {
                            if(me.getY() == ball.getY())
                            {
                                if(me.getX()<ball.getX() && me.getX()+32>=ball.getX())
                                {
                                    bxmove = -4;
                                    bymove = -4;
                                }
                                else if(me.getX()+32<ball.getX() && me.getX()+64>=ball.getX())
                                {
                                    bxmove = 0;
                                    bymove = -4;                                    
                                }
                                else if(me.getX()+64<ball.getX() && me.getX()+96>=ball.getX())
                                {
                                    bxmove = +4;
                                    bymove = -4;                                    
                                }
                            }
                            else if(me2.getY()+96 == ball.getY())
                            {
                                if(me2.getX()<ball.getX() && me2.getX()+32>=ball.getX())
                                {
                                    bxmove = -4;
                                    bymove = +4;
                                }
                                else if(me2.getX()+32<ball.getX() && me2.getX()+64>=ball.getX())
                                {
                                    bxmove = 0;
                                    bymove = +4;                                    
                                }
                                else if(me2.getX()+64<ball.getX() && me2.getX()+96>=ball.getX())
                                {
                                    bxmove = +4;
                                    bymove = +4;                                    
                                }
                            }
                            if(ball.getX()+32>=720)
                            {
                                bxmove = bxmove * (-1);
                            }
                            if(ball.getX()<=0)
                            {
                                bxmove = bxmove * (-1);
                            }
                            
                    
                        }
                    }
                    if(playerID == 2)
                    {
                        if(start)
                        {
                            ball.moveV(1);
                            if(me2.getY() == ball.getY())
                            {
                                if(me2.getX()<ball.getX() && me2.getX()+32>=ball.getX())
                                {
                                    bxmove = -4;
                                    bymove = -4;
                                    start = false;
                                }
                                else if(me2.getX()+32<ball.getX() && me2.getX()+64>=ball.getX())
                                {
                                    bxmove = 0;
                                    bymove = -4;      
                                    start = false;
                                }
                                else if(me2.getX()+64<ball.getX() && me2.getX()+96>=ball.getX())
                                {
                                    bxmove = +4;
                                    bymove = -4;            
                                    start = false;
                                }
                            }
                        }
                        else
                        {
                            if(me.getY()+96 == ball.getY())
                            {
                                if(me.getX()<ball.getX() && me.getX()+32>=ball.getX())
                                {
                                    bxmove = -4;
                                    bymove = +4;
                                }
                                else if(me.getX()+32<ball.getX() && me.getX()+64>=ball.getX())
                                {
                                    bxmove = 0;
                                    bymove = +4;                                    
                                }
                                else if(me.getX()+64<ball.getX() && me.getX()+96>=ball.getX())
                                {
                                    bxmove = +4;
                                    bymove = +4;                                    
                                }
                            }
                            else if(me2.getY() == ball.getY())
                            {
                                if(me2.getX()<ball.getX() && me2.getX()+32>=ball.getX())
                                {
                                    bxmove = -4;
                                    bymove = -4;
                                }
                                else if(me2.getX()+32<ball.getX() && me2.getX()+64>=ball.getX())
                                {
                                    bxmove = 0;
                                    bymove = -4;                                    
                                }
                                else if(me2.getX()+64<ball.getX() && me2.getX()+96>=ball.getX())
                                {
                                    bxmove = +4;
                                    bymove = -4;                                    
                                }
                            }
                            if(ball.getX()+32>=720)
                            {
                                bxmove = bxmove * (-1);
                            }
                            if(ball.getX()<=0)
                            {
                                bxmove = bxmove * (-1);
                            }
                            
                    
                        }
                        
                    }
                    if(ball.getY() <= 0 || ball.getY() >= 720)
                        {
                            bxmove = 0; 
                            bymove = 0;
                            ball.setX(270);
                            ball.setY(310);
                            start = true; 
                        }
                    ball.moveV(bymove);
                    ball.moveH(bxmove);
                    PComponent.this.repaint();
                    
                        
                    }
               });
            }
        };

        animationTimer = new Timer(interval, al);
        animationTimer.start();
        
    }
    /**
     * Activates the KeyListeners, which has the controls of the game. 
     */
    public void setUpKL() {
        KeyListener kl = new KeyListener() {
            public void keyTyped(KeyEvent ke) {

            }

            public void keyPressed(KeyEvent ke) {
                int keyCode = ke.getKeyCode();

                switch (keyCode) {
                    case KeyEvent.VK_A:
                        up = false;
                        down = false;
                        left = true;
                        right = false;
                        break;
                    case KeyEvent.VK_D:
                        up = false;
                        down = false;
                        left = false;
                        right = true;
                        break;
                    case KeyEvent.VK_SPACE:
                        break;
                    case KeyEvent.VK_ENTER:
                        if(inlevel)
                        {
                            
                        }
                        else
                        {
                        inlevel = true;
                        }
                        default:
                        break;
                }
            }

            public void keyReleased(KeyEvent ke) {
                int keyCode = ke.getKeyCode();

                switch (keyCode) {
                    case KeyEvent.VK_W:
                        up = false;
                        break;
                    case KeyEvent.VK_S:
                        down = false;
                        break;
                    case KeyEvent.VK_A:
                        left = false;
                        break;
                    case KeyEvent.VK_D:
                        right = false;
                        break;
                    default:
                        break;
                }
            }
        };
        contentPane.addKeyListener(kl);
        contentPane.setFocusable(true);
    }
    /**
     * startThreads triggers the activation of the threads for the communication to the server. 
     */
    public void startThreads() {
        Thread talk = new Thread(ttst);
        Thread listen = new Thread(ltst);
        talk.start();
        listen.start();
    }

    /**
     * This is the inner class that would send information to the server. 
     */
    private class TalkToServerThread implements Runnable {

        public TalkToServerThread() {
            System.out.println("TTST created.");
        }

        public void run() {
            try {
                while (true) {
                    dataOut.writeInt(me.getX());
                    dataOut.writeInt(me.getY());
                    dataOut.flush();
                    try {
                        Thread.sleep(25);
                    } catch (InterruptedException ex) {
                        // ...
                    }
                }
            } catch (IOException ex) {
                // ...
            }
        }

    }

    /**
     * This receives information coming from the server. 
     */
    private class ListenToServerThread implements Runnable {

        public ListenToServerThread() {
            System.out.println("LTST created.");
        }

        public void run() {
            try {
                while (true) {
                    me2.setX(dataIn.readInt());
                    me2.setY(dataIn.readInt());
                }
            } catch (IOException ex) {
                // ...
            }
            
        }
    }
}
