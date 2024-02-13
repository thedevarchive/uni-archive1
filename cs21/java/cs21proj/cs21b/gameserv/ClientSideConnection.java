
/**
 * Write a description of class ClientSideConnection here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.io.*; 
import java.net.*; 

public class ClientSideConnection
{
    private Socket s; 
    private DataInputStream dataIn;
    private DataOutputStream dataOut; 
    private int playerID; 
    
    public ClientSideConnection()
    {
        try
        {
            s = new Socket("localhost", 5678); 
            dataIn = new DataInputStream(s.getInputStream()); 
            dataOut = new DataOutputStream(s.getOutputStream()); 
            playerID = dataIn.readInt(); 
        }
        catch(IOException ex)
        {
            System.out.println("Error from CSC"); 
        }
    }
    public int getPlayerID()
    {
        return playerID; 
    }
}
