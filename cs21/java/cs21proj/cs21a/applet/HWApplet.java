
/**
 * Write a description of class HWApplet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import javax.swing.*; 
import java.awt.*; 

public class HWApplet extends JApplet
{
    private JButton btton;
    private JTextField textField; 
    private JButton rnd; 
    private JLabel helloLabel; 
    public void init()
    {
        Container c = getContentPane();
        c.setLayout(new FlowLayout()); 
        helloLabel = new JLabel("Hello World");
        c.add(helloLabel);
        textField = new JTextField("Enter your name: ", 15); 
        c.add(textField); 
        btton = new JButton("Click me");
        c.add(btton);
        rnd = new JButton("Become gay");
        c.add(rnd); 
    }
}
