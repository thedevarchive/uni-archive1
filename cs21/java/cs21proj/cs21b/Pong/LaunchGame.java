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
 * LaunchGame has the GUI and the main method of the game. 
 * It is to be launched by both players in the game to start it. 
 * 
 * @author Alyssa Mae Ngo and Lian Santos
 * @version May 21, 2017
 */

import java.awt.*;
import javax.swing.*;
import java.net.*;
import java.io.*;

public class LaunchGame extends JFrame {

    private int width, height;
    private int playerID;
    private Socket socket;
    private DataInputStream dataIn;
    private DataOutputStream dataOut;
    private Container contentPane;
    /**
     * Constructor for PlayerFrame 
     * 
     * @param  w    determines the width of the window of the GUI
     * @param  h    determines the height of the window of the GUI
     */
    public LaunchGame(int w, int h) 
    {
        width = w;
        height = h;
    }
    
    /**
     * Creates the GUI for the game. It also starts up the PComponent which has most of the content of
     * the game. 
     */
    public void setUpGUI() {
        contentPane = this.getContentPane();
        PComponent pc = new PComponent(contentPane, socket, dataIn, dataOut, playerID);
        
        this.setTitle("SPACE PONG: PLAYER #" + playerID);
        
        contentPane.setPreferredSize(new Dimension(width, height));
        contentPane.add(pc);
        pc.setUpKL();
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);  
        pc.setUpRepaintTimer();
        pc.startThreads();
    }
    /**
     * This initiates the connection to the server, which oversees and handles the connection and 
     * communication of the two players in the game. 
     */
        public void connectToServer() {
        try {
            socket = new Socket("localhost", 5678);
            dataIn = new DataInputStream(socket.getInputStream());
            dataOut = new DataOutputStream(socket.getOutputStream());
            playerID = dataIn.readInt();
            System.out.println("You are " + playerID);
            String msg = dataIn.readUTF();
            System.out.println(msg);
        } catch (IOException ex) {
            // ...
        }
    }
    /**
     * This launches the GUI and the game. 
     */
    public static void main(String[] args) {
        LaunchGame lg = new LaunchGame(640, 720);
        lg.connectToServer();     
        lg.setUpGUI();   
    }
    
}


