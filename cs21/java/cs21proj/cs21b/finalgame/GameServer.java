
import java.io.*;
import java.net.*;

public class GameServer {

    private ServerSocket ss;
    private final int maxPlayers = 2;
    private int numPlayers;

    // The server will use 2 threads for each player.
    // This will lead to a total of 4 threads if there are 2 players.
    // Why 2 threads per player?
    //      - one thread for the output stream
    //      - one thread for the input stream
    // They need to be separate because we will be 
    // CONSTANTLY sending out each player's coordinates.
    private TalkToClientThread p1Talk;
    private TalkToClientThread p2Talk;
    private ListenToClientThread p1Listen;
    private ListenToClientThread p2Listen;

    // These fields will store the coordinates of each player.
    private double p1x, p1y, p2x, p2y;

    public GameServer() {
        System.out.println("===== GAME SERVER =====");
        numPlayers = 0;
        // Ridiculous negative values for the player coordinates
        // to signify that the players, at this point, haven't sent
        // their actual coordinates yet.
        p1x = -9999;
        p1y = -9999;
        p2x = -9999;
        p2y = -9999;
        try {
            ss = new ServerSocket(8888);
        } catch (IOException ex) {
            System.out.println("ex - GameServer constructor");
        }
    }

    public void acceptConnections() {
        try {
            System.out.println("Waiting for connections...");

            while (numPlayers < maxPlayers) {
                Socket s = ss.accept();
                numPlayers++;
                System.out.println("Player #" + numPlayers + " has connected.");
                TalkToClientThread ttct = new TalkToClientThread(s, numPlayers);
                ListenToClientThread ltct = new ListenToClientThread(s, numPlayers);

                if(numPlayers == 1)
                {
                    p1Talk = ttct; 
                    p1Listen = ltct; 
                }
                else
                {
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
            System.out.println("ex - acceptConnections()");
        }
    }


    /* ============================== TALKTOCLIENTTHREAD INNER CLASS ============================== */    
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
            while (true)
            {
                if(p1x != -9999 && p1y != -9999 && p2x != -9999 && p2y != -9999)
                {
                    if(playerID == 1)
                    {
                        p1Talk.sendEnemyCoordinates(p2x, p2y); 
                    }
                    else
                    {
                        p2Talk.sendEnemyCoordinates(p1x, p1y); 
                    }
                }
                try
                {
                    Thread.sleep(25); 
                }
                catch(InterruptedException ex)
                {
                }
            }
        }

        public void sendEnemyCoordinates(double x, double y)
        {
            try{
                dataOut.writeDouble(x); 
                dataOut.writeDouble(y); 
            }
            catch(IOException ex)
            {
            }
        }

        public void sendStartMsg()
        {
            try
            {
                dataOut.writeUTF("Two players have connected. Let's begin."); 
            }
            catch(IOException ex)
            {
            }
        }
    }

    
    /* ============================== LISTENTOCLIENTTHREAD INNER CLASS ============================== */    
    private class ListenToClientThread implements Runnable {

        private int playerID;
        private Socket socket;
        private DataInputStream dataIn;

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
            try
            {
				while(true){
                if(playerID == 1)
                {
                    p1x = dataIn.readDouble(); 
                    p1y = dataIn.readDouble(); 
                }
                else
                {
                    p2x = dataIn.readDouble(); 
                    p2y = dataIn.readDouble(); 
                }
				}
            }
            catch(IOException ex)
            {
                System.out.println("this is an error from ltct"); 
            }
        }

    }

    public static void main(String[] args) {
        GameServer gs = new GameServer();
        gs.acceptConnections();
    }

}
