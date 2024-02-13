

import java.awt.*;
import javax.swing.*;
import java.net.*;
import java.io.*;

public class PlayerFrame extends JFrame {

    private int width, height;
    private int playerID;
    private Socket socket;
    private DataInputStream dataIn;
    private DataOutputStream dataOut;
    private Container contentPane;

    public PlayerFrame(int w, int h) {
        width = w;
        height = h;
    }

    public void setUpGUI() {
        contentPane = this.getContentPane();
        PlayerComponent pc = new PlayerComponent(contentPane, socket, dataIn, dataOut, playerID);
        
        this.setTitle("PLAYER #" + playerID);
        
        contentPane.setPreferredSize(new Dimension(width, height));
        contentPane.add(pc);
        pc.setUpKL();
        
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);  
        
        pc.setUpRepaintTimer();
        pc.startThreads(); 
    }

    public void connectToServer() 
    {
        try
        {
            socket = new Socket("localhost", 8888); 
            dataIn = new DataInputStream(socket.getInputStream()); 
            dataOut = new DataOutputStream(socket.getOutputStream()); 
            playerID = dataIn.readInt(); 
            System.out.println("Connected to server >>> " + playerID); 
            String msg = dataIn.readUTF(); 
            System.out.println(msg); 
        }
        catch(IOException ex)
        {
        }
    }
    
    public static void main(String[] args) {
        PlayerFrame pf = new PlayerFrame(640, 480);
        pf.connectToServer(); 
        pf.setUpGUI();
    }

}
