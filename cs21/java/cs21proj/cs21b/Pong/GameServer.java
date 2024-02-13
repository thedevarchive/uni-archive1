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
 * GameServer is the server for the game. It sends and receives connections to the other players of the game. 
 * It usually sends the coordinates of the PlayerSprites, and the Ball. 
 * 
 * @author Alyssa Mae Ngo and Lian Santos
 * @version May 21, 2017
 */
import java.io.*;
import java.net.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.io.*;
import java.net.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
public class GameServer {

    private ServerSocket ss;
    private final int maxPlayers = 2;
    private int numPlayers;

    private TalkToClientThread p1Talk;
    private TalkToClientThread p2Talk;
    private ListenToClientThread p1Listen;
    private ListenToClientThread p2Listen;


    private int p1x, p1y, p2x, p2y;
    /**
     * GameServer constructor
     */
    public GameServer() {
        System.out.println("GAME SERVER: LOADING...");
        numPlayers = 0;
        p1x = -9999;
        p1y = -9999;
        p2x = -9999;
        p2y = -9999;
        try {
            ss = new ServerSocket(5678);
        } catch (IOException ex) {
        }
    }
    /**
     * This method, when called, begins accepting the client's connections. 
     */
    public void acceptConnections() {
        try {
            System.out.println("Now accepting connections...");

            while (numPlayers < maxPlayers) {
                Socket s = ss.accept();
                numPlayers++;
                System.out.println("Player #" + numPlayers + " has connected.");
                TalkToClientThread ttct = new TalkToClientThread(s, numPlayers);
                ListenToClientThread ltct = new ListenToClientThread(s, numPlayers);
                if (numPlayers == 1) {         
                    p1Talk = ttct;
                    p1Listen = ltct;
                } else {
                    p2Talk = ttct;
                    p2Listen = ltct;
                    Thread lt1 = new Thread(p1Listen);
                    Thread lt2 = new Thread(p2Listen);
                    lt1.start();
                    lt2.start();
                    p1Talk.sendStartMsg();
                    p2Talk.sendStartMsg();
                    Thread tt1 = new Thread(p1Talk);
                    Thread tt2 = new Thread(p2Talk);
                    tt1.start();
                    tt2.start();
                }
            }

        } catch (IOException ex) {
        }
    }
   

    /**
     * Enables the server to send information to clients. 
     */
    private class TalkToClientThread implements Runnable {

        private int playerID;
        private Socket socket;
        private DataOutputStream dataOut;

        public TalkToClientThread(Socket s, int pid) {
            playerID = pid;
            socket = s;
            try {
                dataOut = new DataOutputStream(socket.getOutputStream());
                dataOut.writeInt(playerID);
                dataOut.flush();
            } catch (IOException ex) {
                System.out.println("ex - TalkToClientThread constructor");
            }
        }

        public void run() {
            while (true) {
                if (p1x != -9999 && p1y != - 9999 && p2x != -9999 && p2y != -9999) {
                    if (playerID == 1) {
                        p1Talk.sendEnemyCoordinates(p2x, p2y);
                    } else {
                        p2Talk.sendEnemyCoordinates(p1x, p1y);
                    }
                }
                try {
                    Thread.sleep(25);
                } catch (InterruptedException ex) {
                    // ...
                }
            }
        }

        public void sendEnemyCoordinates(int x, int y) {
            try {
                dataOut.writeInt(x);
                dataOut.writeInt(y);
                dataOut.flush();
            } catch (IOException ex) {
                // ...
            }

        }
        public void sendBallCoordinates(int x, int y)
        {
            try {
                dataOut.writeInt(x);
                dataOut.writeInt(y);
                dataOut.flush();
            } catch (IOException ex) {
                // ...
            }

        }
        public void sendStartMsg() {
            try {
                dataOut.writeUTF("We now have 2. Go!");
            } catch (IOException ex) {
                // ...
            }
        }
        
    }

    /**
     * Enables the GameServer to read client's data, to be sent to another client. 
     */
    private class ListenToClientThread implements Runnable {

        private int playerID;
        private Socket socket;
        private DataInputStream dataIn;
        int interval = 10;
        boolean start = true;
        public ListenToClientThread(Socket s, int pid) {
            playerID = pid;
            socket = s;
            try {
                dataIn = new DataInputStream(socket.getInputStream());
            } catch (IOException ex) {
                System.out.println("ex - ListenToClientThread constructor");
            }

        }
        public void run() {
            try {
                while (true) {
                    if (playerID == 1) {
                        p1x = dataIn.readInt();
                        p1y = dataIn.readInt();
                    } else {
                        p2x = dataIn.readInt();
                        p2y = dataIn.readInt();
                    }
                }
            } 
            catch (IOException ex) {
                // ...
            }
        }
        
    }

    /**
     * This is the main method that will launch the GameServer. 
     */
    public static void main(String[] args) {
        GameServer gs = new GameServer();
        gs.acceptConnections();
    }

}


    

    
   