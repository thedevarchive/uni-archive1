
/**
 * Write a description of class GameServer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.io.*; 
import java.net.*; 

public class GameServer
{
    // instance variables - replace the example below with your own
    private ServerSocket ss; 
    private int numPlayers; 
    private ServerSideConnection player1; 
    private ServerSideConnection player2; 

    /**
     * Constructor for objects of class GameServer
     */
    public GameServer()
    {
        numPlayers = 0; 
        try 
        {
            ss = new ServerSocket(5678); 
        }
        catch (IOException ex)
        {
            System.out.println("Error from GameServer constructor"); 
        }
    }

    public void acceptConnections()
    {
        try
        {
            while(numPlayers < 2)
            {
                Socket s = ss.accept(); 
                numPlayers++;
                System.out.println("Player #" + numPlayers + " has connected."); 
                ServerSideConnection ssc = new ServerSideConnection(s, numPlayers); 
                Thread t = new Thread(ssc); 
                t.start(); 
                if(numPlayers == 1)
                {
                    player1 = ssc; 
                }
                else
                {
                    player2 = ssc; 
                }
            }
            System.out.println("We now have 2 players"); 
        }
        catch (IOException ex)
        {
            System.out.println("Error from acceptConnections"); 
        }
    }

    private class ServerSideConnection implements Runnable 
    {
        private Socket socket; 
        private DataInputStream dataIn; 
        private DataOutputStream dataOut; 
        private int playerID;

        public ServerSideConnection(Socket s, int id)
        {
            socket = s; 
            playerID = id; 
            try 
            {
                dataIn = new DataInputStream(s.getInputStream()); 
                dataOut = new DataOutputStream(s.getOutputStream()); 

            }
            catch (IOException ex)
            {
                System.out.println("Error from SSC constructor"); 
            }
        }

        public void run()
        {
            try
            {
                dataOut.writeInt(playerID); 
            }
            catch(IOException ex)
            {
                System.out.println("Error from SSC connection"); 
            }
        }	
    }
}
