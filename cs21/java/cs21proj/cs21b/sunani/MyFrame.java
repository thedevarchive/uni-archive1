
/**
 * Write a description of class MyFrame here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.awt.*; 
import javax.swing.*; 
import java.awt.event.*; 

public class MyFrame extends JFrame
{
    // instance variables - replace the example below with your own
    private int width; 
    private int height; 
    private Container contentPane;
    private JButton b1; 
    private JButton b2; 
    private DrawComp3B dc3b;
    private int del; 
    
    Timer tim; 

    /**
     * Constructor for objects of class MyFrame
     */
    public MyFrame(int w, int h)
    { 
        width = w; 
        height = h; 
        b1 = new JButton("b1"); 
        b2 = new JButton("b2"); 
        dc3b = new DrawComp3B(w, h); 
        del = 100; 
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public void setup()
    {
        contentPane = this.getContentPane(); 
        contentPane.setLayout(new BorderLayout()); 
        this.setSize(width, height); 
        this.setTitle("The Content Pane"); 
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 

        contentPane.add(b1, BorderLayout.NORTH); 
        contentPane.add(b2, BorderLayout.SOUTH);
        contentPane.add(dc3b, BorderLayout.CENTER); 

        
        this.setVisible(true); 
    }

    public void activateButtons()
    {
        b1.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent ae)
                {
                    dc3b.getSun().incX(-10); 
                    dc3b.repaint();
                }
            }); 
        b2.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent ae)
                {
                    dc3b.getSun().incX(5); 
                    dc3b.repaint();
                }
            });
    }
}
