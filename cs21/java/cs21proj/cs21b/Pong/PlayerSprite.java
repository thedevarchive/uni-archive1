
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
 * PlayerSprite generates the sprites controlled by the players. In this program, this is used to create
 * ships for the player to control. 
 * 
 * @author Alyssa Mae Ngo and Lian Santos
 * @version May 21, 2017
 */

import java.awt.*;
import java.awt.geom.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
public class PlayerSprite {
    private int x, y;
    private int health;
    private BufferedImage sprite;
    private Boolean p1;
    /**
     * Constructor for PlayerSprite
     * 
     * @param  x   determines the (starting) x-coordinate of the PlayerSprite
     * @param  y   determines the (starting) y-coordinate of the PlayerSprite
     * @param  z   determines the player in a frame
     */
    public PlayerSprite(int x, int y, Boolean z) {
        this.x = x;
        this.y = y;
        p1 = z;
        health = 4;
    }
    /**
     * getHP returns health of PlayerSprite. Health is needed to remain in the game. 
     * 
     * @return  health   the remaining health of the PlayerSprite
     */
    public int getHP()
    {
        return health;
    }
    /**
     * updateHP makes changes to the PlayerSprite. 
     * 
     * @param  change   the value that would be added (or reduced) to the health of the PlayerSprite. 
     */
    public void updateHP(int change)
    {
        this.health = this.health + change;
    }
    /**
     * Draws the sprite of the player. 
     * This also enables the user to see how many lives left they have in the game. 
     * 
     * @param  g2d   the Graphics2D needed to draw the sprite
     * @param  reset   the AffineTransform needed to draw the object
     */
    public void draw(Graphics2D g2d, AffineTransform reset) {
       BufferedImageLoader loader = new BufferedImageLoader();
       BufferedImage spriteSheet = null;
       try
       {
           spriteSheet = loader.loadImage("Ships.png");
       }
       catch(IOException ex)
       {
           
       }
       SpriteSheet ss = new SpriteSheet(spriteSheet);
       if(p1)
        {
            sprite = ss.grabSprite(0,0,32,32);
            g2d.drawImage(sprite,x,y,96,96,null);
            g2d.setColor(Color.GREEN);
            Font font = new Font("DialogInput", Font.PLAIN, 20);
            g2d.setTransform(reset);
       }
       else
       {
           sprite = ss.grabSprite(32,0,32,32);
           g2d.drawImage(sprite,x,y,96,96,null);
            g2d.setColor(Color.GREEN);
            g2d.setTransform(reset);
       }
        
    }
    /**
     * Moves the player horizontally. 
     * 
     * @param  n   the increment/decrement that would move the PlayerSprite to the right/left
     */
    public void moveH(int n) {
        x += n;
    }
    /**
     * Moves the player vertically. 
     * 
     * @param  n   the increment/decrement that would move the PlayerSprite downward/upward
     */
    public void moveV(int n) {
        y += n;
    }
    /**
     * This positions the PlayerSprite to an x-coordinate. 
     * 
     * @param  n   the x-coordinate the PlayerSprite will be moved to
     */
    public void setX(int n) {
        x = n;
    }
    /**
     * This positions the PlayerSprite to an y-coordinate. 
     * 
     * @param  n   the y-coordinate the PlayerSprite will be moved to
     */
    public void setY(int n) {
        y = n;
    }
    /**
     * Gets the x-coordinate. 
     * 
     * @return  x    the current x-coordinate of the PlayerSprite
     */
    public int getX() {
        return x;
    }
    /**
     * Gets the y-coordinate. 
     * 
     * @return  y    the current y-coordinate of the PlayerSprite
     */
    public int getY() {
        return y;
    }
    
}

