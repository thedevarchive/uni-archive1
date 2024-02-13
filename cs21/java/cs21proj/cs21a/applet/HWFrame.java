
/**
 * Write a description of class HWFrame here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import javax.swing.*; 
import java.awt.*; 
import java.awt.event.*; 

public class HWFrame extends JFrame
{
    private JButton btton;
    private JTextField textField; 
    private JLabel helloLabel; 
    
    public HWFrame()
    {
        setLayout(new FlowLayout()); 
        helloLabel = new JLabel("Hello World");
        add(helloLabel);
        textField = new JTextField("Enter your name: ", 15); 
        add(textField); 
        btton = new JButton("Click me");
        add(btton); 
        class ButtonListener implements ActionListener 
        {
            public void actionPerformed(ActionEvent ae)
            {
                String text = textField.getText();
                helloLabel.setText("Hello, " + text); 
            }
        }
    }
}
