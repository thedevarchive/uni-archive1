
/**
 * Write a description of class PhonePad here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import javax.swing.*; 
import java.awt.*; 
import java.awt.event.*; 

public class PhonePad extends JFrame
{
    private JButton btton;
    private JTextField textField; 
    private JLabel helloLabel; 
    
    public PhonePad()
    {
        setLayout(new GridLayout(4, 3)); 
        add(new Button("1"));
        add(new Button("2")); 
        add(new Button("3")); 
        add(new Button("4"));
        add(new Button("5"));
        add(new Button("6")); 
        add(new Button("7")); 
        add(new Button("8")); 
        add(new Button("9")); 
        add(new Button("*"));
        add(new Button("0")); 
        add(new Button("#")); 
    }
}
