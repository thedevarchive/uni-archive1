
/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player
{
    // instance variables - replace the example below with your own
    private String yn; 
    private Card[] hand;
    private int tokens; 
    private boolean handFull; 
    private int i; 
    private boolean cardDrawn = false; 
    private Card tempCard; 
    private int tempInd; 
    private int nextProd; 
    private int tempProd; 
    private String message = ""; 
    
    /**
     * Constructor for objects of class Player
     */
    public Player(java.lang.String n)
    {
        yn = n; 
        hand = new Card[5]; 
        tokens = 0; 
        handFull = false; 
    }

    public void drawCard(Card c)
    {
        for(i = 0; i < 5; i++)
        {
            if (hand[i] == null)
            {
                hand[i] = c; 
                if (i == 4)
                {
                    handFull = true; 
                }
                break; 
            }
        }
    }
    
    public java.lang.String swap()
    {
        tempCard = hand[0]; 
        if(findCard() == -1)
        {
            message = yn + " has no other card to swap with. Turn forfeited.\n"; 
        }
        else if(findCard() != -1)
        {
            hand[0] = hand[findCard()]; 
            hand[findCard()] = tempCard; 
            message = hand[0].getName() + " is now active with " + hand[0].getHitPoints() + " points.";
            message += "\n";
        }
        return message; 
    }
    
    private int findCard()
    { 
        tempInd = -1; 
        if(hand[1] != null)
        {
            tempInd = 1; 
            tempProd = hand[1].getPower() * hand[1].getHitPoints(); 
            for (i = 2; i < 5; i++)
            {
                if(hand[i] != null)
                {
                    nextProd = hand[i].getPower() * hand[i].getHitPoints(); 
                    if (tempProd < nextProd)
                    {
                        tempProd = nextProd; 
                        tempInd = i; 
                    }
                }
            }
        }
        return tempInd; 
    }
    
    public void discard()
    {
        hand[0] = hand[1]; 
        hand[1] = hand[2]; 
        hand[2] = hand[3]; 
        hand[3] = hand[4]; 
        hand[4] = null; 
    }
    
    public void claimToken()
    {
        tokens += 1; 
    }
    
    public java.lang.String statusReport()
    {
        message = yn + "\n     ";
        for(i = 0; i < 4; i++)
        {
            if(hand[i] != null)
            {
                message += hand[i].getName() + " : " + hand[i].getHitPoints() + "\n     "; 
            }
        }
        if(hand[4] != null)
        {
            message += hand[4].getName() + " : " + hand[4].getHitPoints(); 
        }
        return message; 
    }
    
    public Card getActiveCard()
    {
        return hand[0]; 
    }
    
    public boolean handIsFull()
    {
        return handFull; 
    }
   
    public int getTokenCount()
    {
        return tokens; 
    }
    
    public java.lang.String getName()
    {
        return yn; 
    }
    
}
