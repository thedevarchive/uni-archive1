import java.io.*; 
import java.util.*; 
/**
 * Write a description of class Arbiter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Arbiter
{
    // instance variables - replace the example below with your own
    private int turns; 
    private Player p1; 
    private Player p2; 
    private boolean winner; 
    private ArrayList<Card> deck = new ArrayList<Card>();  
    private String message = "";
    
    private boolean fRes; 
    private boolean mRes; 
    private boolean wRes;
    private boolean hasRes; 
    private boolean fWk; 
    private boolean mWk; 
    private boolean wWk; 
    private boolean hasWk; 
    
    private String t1 = ""; 
    private String t2 = ""; 
    private int truDam; 
    private Card main1; 
    private Card main2; 
    private Card next1; 
    private Card next2; 
    private int prod1; 
    private int prod2; 
    private Card tempCard; 
    
    private boolean hasFile; 
    /**
     * Constructor for objects of class Arbiter
     */
    public Arbiter(Player a, Player b)
    {
        // initialise instance variables
        p1 = a; 
        p2 = b; 
        turns = 1; 
        winner = false; 
        assembleDeck(); 
    }
    
    //This is where I learned to shuffle an arrayList
    //http://stackoverflow.com/questions/16112515/how-to-shuffle-an-arraylist
    
    public void shuffleDeck()
    {
        Collections.shuffle(deck);
    }
    
    private void assembleDeck()
    {
        deck.add( new Card( "Fire", "Akiko", 170, 25 ) );
        deck.add( new Card( "Metal", "Bashio", 166, 79 ) );
        deck.add( new Card( "Water", "Chikeko", 159, 86 ) );
        deck.add( new Card( "Fire", "Danotia", 105, 39 ) );
        deck.add( new Card( "Metal", "Eromi", 175, 30 ) );
        deck.add( new Card( "Water", "Fuwoma", 154, 40 ) );
        deck.add( new Card( "Fire", "Ginduos", 109, 27 ) );
        deck.add( new Card( "Metal", "Hikun", 144, 25 ) );
        deck.add( new Card( "Water", "Irosa", 149, 32 ) );
        deck.add( new Card( "Fire", "Juxios", 165, 50 ) );
        deck.add( new Card( "Metal", "Kaletia", 148, 43 ) );
        deck.add( new Card( "Water", "Lereios", 133, 28 ) );
        deck.add( new Card( "Fire", "Moruru", 115, 36 ) );
        deck.add( new Card( "Metal", "Nukosu", 153, 30 ) );
        deck.add( new Card( "Water", "Owayu", 152, 25 ) );
        deck.add( new Card( "Fire", "Polelia", 151, 40 ) );
        deck.add( new Card( "Metal", "Queoios", 173, 43 ) );
        deck.add( new Card( "Water", "Rinichi", 147, 64 ) );
        deck.add( new Card( "Fire", "Shike", 138, 39 ) );
        deck.add( new Card( "Metal", "Takiru", 155, 36 ) );
        deck.add( new Card( "Water", "Ustelia", 166, 33 ) );
        deck.add( new Card( "Fire", "Voronia", 155, 32 ) );
        deck.add( new Card( "Metal", "Wasu", 175, 38 ) );
        deck.add( new Card( "Water", "Xios", 152, 45 ) );
        deck.add( new Card( "Fire", "Yora", 174, 59 ) );
        deck.add( new Card( "Metal", "Zagios", 151, 52 ) );
    }
    
    public void assembleNewDeck()
    { 
        //Learned emptying an arrayList here.
        //https://www.tutorialspoint.com/java/util/arraylist_clear.htm
        deck.clear(); 
        while (!hasFile)
        {
            try
            {
                FileReader f = new FileReader("newCards.txt"); 
                Scanner s = new Scanner(f); 
                while (s.hasNextLine())
                {
                    String line = s.nextLine(); 
                    String[] spl = line.split(" ");
                    deck.add(new Card(spl[0], spl[1], Integer.parseInt(spl[2]), Integer.parseInt(spl[3]))); 
                }
                s.close(); 
                hasFile = true; 
            }
            catch(FileNotFoundException f)
            {
                hasFile = false; 
            }
        }
    }
    
    // this link taught me how to remove an item in an ArrayList
    // http://stackoverflow.com/questions/10738634/delete-data-from-arraylist-with-a-for-loop
    
    public java.lang.String dealCard()
    {
        if (turns % 2 == 1)
        {
            if(p1.handIsFull())
            {
                message = p1.getName() + "'s hand is full.\n";
                turns++; 
            }
            else
            {
                p1.drawCard(deck.get(0));
                message = p1.getName() + " draws " + (deck.get(0)).getName() + ".\n";
                deck.remove(0);
                turns++; 
            }
        }
        else
        {
            if(p2.handIsFull())
            {
                message = p2.getName() + "'s hand is full.\n"; 
                turns++;
            }
            else
            {
                p2.drawCard(deck.get(0)); 
                message = p2.getName() + " draws " + (deck.get(0)).getName() + ".\n";
                deck.remove(0); 
                turns++; 
            }
        }
        return message; 
    }
    
    public String play(String action)
    {
        message = ""; 
        main1 = p1.getActiveCard();
        main2 = p2.getActiveCard(); 
        if (turns % 2 == 1)
        {
            if("swap".equals(action))
            {
                message += p1.getName() + " swaps out " + main1.getName() + "...\n";
                message += p1.swap(); 
            }
            else if ("attack".equals(action))
            {
                message = "";
                message += p1.getName() + " attacks with " + main1.getName() + ".\n";
                message += dealDamage(main1, main2); 
                if(main2.getHitPoints() <= 0)
                {
                    message += p2.getName() + " discards " + main2.getName() + "\n"; 
                    deck.remove(p2.getActiveCard()); 
                    p2.discard(); 
                    if(deck.size() > 1)
                    {
                        next1 = deck.get(0); 
                        prod1 = next1.getHitPoints() * next1.getPower(); 
                        next2 = deck.get(1); 
                        prod2 = next2.getHitPoints() * next2.getPower(); 
                    }
                    if (deck.isEmpty())
                    {
                        message += "The deck is empty."; 
                    }
                    else if(prod1 >= prod2 || deck.size() == 1)
                    {
                        message += p2.getName() + " draws " + next1.getName() + "\n"; 
                        p2.drawCard(next1);
                        deck.remove(0);
                        tempCard = next2;  
                        deck.add(tempCard); 
                        deck.remove(0); 
                    }
                    else
                    {
                        message += p2.getName() + " draws " + next2.getName() + "\n"; 
                        p2.drawCard(next2); 
                        deck.remove(1); 
                        tempCard = next1; 
                        deck.add(tempCard);
                        deck.remove(0); 
                    }
                    p1.claimToken(); 
                    message += p1.getName() + " gets a token!\n"; 
                    if(hasWinner())
                    {
                        message += p1.getName() + " wins!!!\n";
                        message += gameReport(); 
                    }
                }
            }
        }
        else
        {
            if("swap".equals(action))
            {
                message += p2.getName() + " swaps out " + main2.getName() + "...\n";
                message += p2.swap(); 
            }
            else if ("attack".equals(action))
            {
                message = "";
                message += p2.getName() + " attacks with " + main2.getName() + ".\n";
                message += dealDamage(main2, main1);
                if(main1.getHitPoints() <= 0)
                {
                    message += p1.getName() + " discards " + main1.getName() + "\n"; 
                    deck.remove(p1.getActiveCard()); 
                    p1.discard(); 
                    if(deck.size() > 1)
                    {
                        next1 = deck.get(0); 
                        prod1 = next1.getHitPoints() * next1.getPower(); 
                        next2 = deck.get(1); 
                        prod2 = next2.getHitPoints() * next2.getPower(); 
                    }
                    //Learned how to check empty arrayLists here
                    // http://stackoverflow.com/questions/3203664/empty-arraylist-equals-null
                    if (deck.isEmpty())
                    {
                        message += "The deck is empty.\n"; 
                    }
                    else if(prod1 >= prod2 || deck.size() == 1)
                    {
                        message += p1.getName() + " draws " + next1.getName() + "\n"; 
                        p1.drawCard(next1);
                        deck.remove(0); 
                        tempCard = next2; 
                        deck.add(tempCard); 
                        deck.remove(0); 
                    }
                    else
                    {
                        message += p1.getName() + " draws " + next2.getName() + "\n"; 
                        p1.drawCard(next2); 
                        deck.remove(1); 
                        tempCard = next1; 
                        deck.add(tempCard);
                        deck.remove(0); 
                    }
                    p2.claimToken(); 
                    message += p2.getName() + " gets a token!\n"; 
                    if(hasWinner())
                    {
                        message += p2.getName() + " wins!!!";
                        message += gameReport(); 
                    }
                }
            }
        }
        turns++; 
        return message; 
    }
    
    public java.lang.String dealDamage(Card inPlay, Card target)
    {
        message = ""; 
        t1 = target.getType(); 
        t2 = inPlay.getType();
        if(checkResistance(t1, t2))
        {
            truDam = inPlay.getPower() / 2; 
            message += t1 + " is resistant to " + t2 + ".\n";
        }
        else if(checkWeakness(t1, t2))
        {
            truDam = inPlay.getPower() * 2; 
            message += t1 + " is weak to " + t2 + ".\n"; 
        }
        else
        {
            truDam = inPlay.getPower(); 
        }
        target.sustainHit(truDam); 
        message += inPlay.getName() + " deals " + truDam + " damage on " + target.getName() + ".\n";
        message += target.getName() + " has " + target.getHitPoints() + " points left.\n"; 
        return message; 
    }
    
    public boolean checkResistance(java.lang.String type1, java.lang.String type2)
    {
        fRes = "fire".equalsIgnoreCase(type1) && "metal".equalsIgnoreCase(type2);
        mRes = "metal".equalsIgnoreCase(type1) && "water".equalsIgnoreCase(type2);
        wRes = "water".equalsIgnoreCase(type1) && "fire".equalsIgnoreCase(type2); 
        hasRes = fRes || mRes || wRes; 
        return hasRes; 
    }
    
    public boolean checkWeakness(java.lang.String type1, java.lang.String type2)
    {
        fWk = "fire".equalsIgnoreCase(type1) && "water".equalsIgnoreCase(type2); 
        mWk = "metal".equalsIgnoreCase(type1) && "fire".equalsIgnoreCase(type2); 
        wWk = "water".equalsIgnoreCase(type1) && "metal".equalsIgnoreCase(type2); 
        hasWk = fWk || mWk || wWk; 
        return hasWk; 
    }
    
    public java.lang.String gameReport()
    {
        message = "---=== GAME SUMMARY ===---\nThis game lasted " + turns + " turns.\n";
        message += p1.statusReport() + "\n"; 
        message += p2.statusReport(); 
        return message; 
    }
    
    public boolean hasWinner()
    {
        if (p1.getTokenCount() == 3 || p2.getTokenCount() == 3)
        {
            winner = true; 
        }
        return winner; 
    }
    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
}
