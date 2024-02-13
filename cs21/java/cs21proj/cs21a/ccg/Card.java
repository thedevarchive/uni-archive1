
/**
 * Write a description of class Card here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Card
{
    private String typ; 
    private String nm; 
    private int hp; 
    private int atk; 
    
    public Card(java.lang.String t, java.lang.String n, int h, int p)
    {
        typ = t; 
        nm = n; 
        hp = h; 
        atk = p; 
    }

    public void sustainHit(int damage)
    {
        hp -= damage; 
    }
    
    public java.lang.String getType()
    {
        return typ; 
    }
    
    public java.lang.String getName()
    {
        return nm; 
    }
    
    public int getHitPoints()
    {
        return hp; 
    }
    
    public int getPower()
    {
        return atk; 
    }
}
