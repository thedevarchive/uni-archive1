

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.io.*;
import java.net.*;
import javax.swing.*;

public class PlayerComponent extends JComponent {

    private Container contentPane;
    private int playerID; 
    private PlayerSprite me; 
    private PlayerSprite enemy; 
    private Socket socket;
    private DataInputStream dataIn;
    private DataOutputStream dataOut;
    private Timer animationTimer;
    private TalkToServerThread ttst;
    private ListenToServerThread ltst;
    private boolean up, down, left, right;

    public PlayerComponent(Container cp, Socket s, DataInputStream dis, DataOutputStream dos, int id) {
        contentPane = cp;
        socket = s;
        dataIn = dis;
        dataOut = dos;
        playerID = id;
        up = false;
        down = false;
        left = false;
        right = false;

        if(playerID == 1)
        {
            me = new PlayerSprite(100, 400, 50, Color.BLUE);
            enemy = new PlayerSprite(540, 400, 50, Color.RED);
        }
        else
        {
            enemy = new PlayerSprite(100, 400, 50, Color.BLUE);
            me = new PlayerSprite(540, 400, 50, Color.RED);
        }

        ttst = new TalkToServerThread(); 
        ltst = new ListenToServerThread(); 
    }

    public void startThreads()
    {
        Thread listen = new Thread(ltst); 
        Thread talk = new Thread(ttst); 
        listen.start(); 
        talk.start();
    }
    
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        AffineTransform reset = g2d.getTransform();

        RenderingHints rh = new RenderingHints(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHints(rh);

        me.drawSprite(g2d, reset);
        enemy.drawSprite(g2d, reset);
    }

    public void setUpRepaintTimer() {
        int interval = 10;
        ActionListener al = new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        double speed = 5;
                        if(up) {
                            me.moveV(-speed);
                        } else if(down) {
                            me.moveV(speed);
                        } else if(left) {
                            me.moveH(-speed);
                        } else if(right) {
                            me.moveH(speed);
                        }
                        PlayerComponent.this.repaint();
                    }
                });
            }
        };
        animationTimer = new Timer(interval, al);
        animationTimer.start();
    }

    public void setUpKL() {
        KeyListener kl = new KeyListener() {
            public void keyTyped(KeyEvent ke) {

            }

            public void keyPressed(KeyEvent ke) {
                int keyCode = ke.getKeyCode();

                switch (keyCode) {
                    case KeyEvent.VK_UP:
                        up = true;
                        down = false;
                        left = false;
                        right = false;
                        break;
                    case KeyEvent.VK_DOWN:
                        up = false;
                        down = true;
                        left = false;
                        right = false;
                        break;
                    case KeyEvent.VK_LEFT:
                        up = false;
                        down = false;
                        left = true;
                        right = false;
                        break;
                    case KeyEvent.VK_RIGHT:
                        up = false;
                        down = false;
                        left = false;
                        right = true;
                        break;
                    default:
                        break;
                }
            }

            public void keyReleased(KeyEvent ke) {
                int keyCode = ke.getKeyCode();

                switch (keyCode) {
                    case KeyEvent.VK_UP:
                        up = false;
                        break;
                    case KeyEvent.VK_DOWN:
                        down = false;
                        break;
                    case KeyEvent.VK_LEFT:
                        left = false;
                        break;
                    case KeyEvent.VK_RIGHT:
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
    
    

/* ============================== TALKTOSERVERTHREAD INNER CLASS ============================== */  
    private class TalkToServerThread implements Runnable {

        public TalkToServerThread() {
            System.out.println("TTST created.");
        }

        public void run() {
            try
            {
                while(true)
                {
                    dataOut.writeDouble(me.getX()); 
                    dataOut.writeDouble(me.getY()); 
                    dataOut.flush(); 

                    try
                    {
                        Thread.sleep(25); 
                    }
                    catch(InterruptedException ex)
                    {
                    }
                }
            }
            catch(IOException ex)
            {
            }
        }

    }
    
    

/* ============================== LISTENTOSERVERTHREAD INNER CLASS ============================== */ 
    private class ListenToServerThread implements Runnable {

        public ListenToServerThread() {
            System.out.println("LTST created.");
        }

        public void run() {
            try
            {
                while(true)
                {
                    double x = dataIn.readDouble();
                    double y = dataIn.readDouble(); 
                    enemy.setX(x); 
                    enemy.setY(y); 
                }
            }
            catch(IOException ex)
            {
            }
        }
    }

}
