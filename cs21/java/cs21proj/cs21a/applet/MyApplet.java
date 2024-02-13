
/**
 * Write a description of class MyApplet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import javax.swing.*; 
import java.awt.*; 

public class MyApplet extends JApplet
{
	private JLabel helloLabel; 
	public void init()
	{
		Container c = getContentPane();
		c.setLayout(new FlowLayout()); 
		helloLabel = new JLabel("Hello World");
		c.add(helloLabel);
	}
}
