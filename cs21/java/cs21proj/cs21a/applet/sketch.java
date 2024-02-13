
/**
 * Write a description of class sketch here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import javax.swing.*; 
import java.awt.*; 
import java.awt.event.*; 

public class sketch extends JFrame
{
    private JButton btton;
    private JTextField textField; 
    private JLabel helloLabel; 
    
    public sketch()
    {
        setLayout(new BorderLayout()); 
        add(new Label("This feels like Android Dev Sessions"), "North"); 
        add(new Label("Some sketchy stuff down there"), "North"); 
        add(new TextField(""), "Center"); 
        add(new TextField("Enter text here"), "South");
        add(new Button("Send"), "East"); 
        add(new Label("Pals"), "East"); 
        
    }
}
