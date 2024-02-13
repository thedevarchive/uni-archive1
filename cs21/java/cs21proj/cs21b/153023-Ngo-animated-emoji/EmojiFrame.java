
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
import java.awt.*; 
import javax.swing.*;
import java.awt.event.*; 

public class EmojiFrame extends JFrame
{
    // instance variables - replace the example below with your own
    private int width; 
    private int height; 
    private JPanel GUIPan; 
    private JPanel DCPan; 
    private JPanel buttonPan; 
    private JButton up; 
    private JButton down; 
    private JButton left; 
    private JButton right; 
    private JButton big; 
    private JButton small; 
    private JButton counter; 
    private JButton clock; 
    private EmojiComp ec; 

    /**
     * Constructor for objects of class EmojiFrame
     */
    public EmojiFrame(int w, int h)
    {
        width = w; 
        height = h; 
        up = new JButton("UP"); 
        down = new JButton("DOWN"); 
        left = new JButton("LEFT"); 
        right = new JButton("RIGHT"); 
        big = new JButton("BIG"); 
        small = new JButton("SMALL"); 
        counter = new JButton("CCW"); 
        clock = new JButton("CW");  
        ec = new EmojiComp(w, h); 
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public void setup()
    {
        this.setLayout(new BorderLayout());
        
        //DCPan = new JPanel(); 
        //DCPan.setLayout(new GridLayout(1, 1)); 
        //DCPan.add(ec); 
        this.add(ec, BorderLayout.CENTER); 
        
        buttonPan = new JPanel(); 
        buttonPan.setLayout(new GridLayout(4, 2)); 
        buttonPan.add(up); 
        buttonPan.add(down); 
        buttonPan.add(left); 
        buttonPan.add(right); 
        buttonPan.add(big); 
        buttonPan.add(small); 
        buttonPan.add(counter); 
        buttonPan.add(clock); 
        this.add(buttonPan, BorderLayout.SOUTH); 
        
        this.setSize(width, height); 
        this.setTitle("emoji"); 
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        this.setVisible(true); 
    }
    public void actvBtns()
    {
        up.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent ae)
                {
                    ec.getEmoji().incY(-10); 
                    ec.repaint(); 
                }
                
            }); 
        down.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent ae)
                {
                    ec.getEmoji().incY(10); 
                    ec.repaint(); 
                }
            });
        left.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent ae)
                {
                    ec.getEmoji().incX(-10); 
                    ec.repaint(); 
                }
                
            }); 
        right.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent ae)
                {
                    ec.getEmoji().incX(10); 
                    ec.repaint(); 
                }
            });
        big.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent ae)
                {
                    ec.getEmoji().incSz(10); 
                    ec.repaint(); 
                }
                
            }); 
        small.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent ae)
                {
                    ec.getEmoji().incSz(-10); 
                    ec.repaint(); 
                }
            });
        counter.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent ae)
                {
                    ec.getEmoji().counter(); 
                    ec.repaint(); 
                }
                
            }); 
        clock.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent ae)
                {
                    ec.getEmoji().clockwise();
                    ec.repaint(); 
                }
            });
    }
}
