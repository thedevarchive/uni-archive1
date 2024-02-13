
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GameFrame extends JFrame {

    private int width;
    private int height;
    private Container contentPane;
    private JTextArea message;
    private JButton b1;
    private JButton b2;
    private JButton b3;
    private int playerID;
    private boolean buttonsEnabled;
    private ClientSideConnection csc; 

    public GameFrame(int w, int h) {
        width = w;
        height = h;
        message = new JTextArea();
        b1 = new JButton("1");
        b2 = new JButton("2");
        b3 = new JButton("3");
    }
    
    public void connectToServer()
    {
        csc = new ClientSideConnection(); 
        playerID = csc.getPlayerID(); 
    }

    public void setUpGUI() {
        this.setSize(width, height);
        this.setTitle("Player #" + playerID);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        contentPane = this.getContentPane();
        contentPane.setLayout(new GridLayout(1, 4));
        contentPane.add(message);
        message.setWrapStyleWord(true);
        message.setLineWrap(true);
        message.setEditable(false);
        contentPane.add(b1);
        contentPane.add(b2);
        contentPane.add(b3);

        this.setVisible(true);
    }

    public void setUpButtons() {
        ActionListener al = new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                JButton b = (JButton) ae.getSource();
                int bNum = Integer.parseInt(b.getText());

                message.setText("You clicked button #" + bNum + ".");
            }
        };

        b1.addActionListener(al);
        b2.addActionListener(al);
        b3.addActionListener(al);
    }

    public static void main(String[] args) {
        GameFrame gf = new GameFrame(400, 100);
        gf.connectToServer(); 
        gf.setUpGUI();
        gf.setUpButtons();
    }
}
