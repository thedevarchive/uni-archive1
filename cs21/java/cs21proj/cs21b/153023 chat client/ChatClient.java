
/**
 * Write a description of class ChatClient here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.net.*; 
import java.io.*; 
import java.util.*; 

public class ChatClient
{
    
    /**
     * Constructor for objects of class ChatClient
     */
    public ChatClient()
    {
        System.out.println("Client created"); 
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public void connectToServer() 
    {
        try 
        {
            Socket s = new Socket("192.168.1.37", 8888); 
            DataInputStream dataIn = new DataInputStream(s.getInputStream()); 
            DataOutputStream dataOut = new DataOutputStream(s.getOutputStream()); 
            
            Scanner chatInput = new Scanner(System.in); 
            System.out.println("name: "); 
            //String name = chatInput.nextLine(); 
            dataOut.writeUTF("world"); 
            dataOut.flush(); 
            
            while(true)
            {
                System.out.println("Enter Message: "); 
                String msg = chatInput.nextLine(); 
                dataOut.writeUTF(msg); 
                dataOut.flush(); 
                if(msg.equals("LEAVE"))
                {
                    break; 
                }
                s.close(); 
            }
        }
        catch(IOException ie)
        {
            System.out.println("Error connecting."); 
        }
    }
    
    public static void main(String args[])
    {
        ChatClient cc = new ChatClient(); 
        cc.connectToServer(); 
    }
}
