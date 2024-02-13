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
 * Ball is an object that is used in the game. 
 * This object mainly determines which player loses a life in a round. 
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
public class Ball {
    private String level;
    private int x, y, radius;
    private int health;
    private BufferedImage sprite;
    /**
     * Constructor for the Ball class
     * 
     * @param  x   starting x-position of Ball object
     * @param  y   starting y-position of Ball object
     */
    public Ball(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public void init()
   {
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
       sprite = ss.grabSprite(74,6,12,11);
   }
   /**
    * This draws the Ball object.
    * 
    * @param  g2d   the Graphics2D that will draw the object
    * @param  reset   the AffineTransform that will draw the object
    */
    public void draw(Graphics2D g2d, AffineTransform reset) {
            init();
            g2d.drawImage(sprite,x,y,32,32,null);
    }
    /**
     * Moves Ball horizontally. 
     * 
     * @param  n   the increment/decrement that would move the Ball to the right/left
     */
    public void moveH(int n) {
        x += n;
    }
    /**
     * Moves Ball vertically. 
     * 
     * @param  n   the increment/decrement that would move the Ball downward/upward
     */
    public void moveV(int n) {
        y += n;
    }
    /**
     * This positions Ball to an x-coordinate. 
     * 
     * @param  n   the x-coordinate the Ball will be moved to
     */
    public void setX(int n) {
        x = n;
    }
    /**
     * This positions Ball to an y-coordinate. 
     * 
     * @param  n   the y-coordinate the Ball will be moved to
     */
    public void setY(int n) {
        y = n;
    }
    /**
     * Gets the x-coordinate. 
     * 
     * @return  x    the current x-coordinate of the Ball
     */
    public int getX() {
        return x;
    }
    /**
     * Gets the y-coordinate. 
     * 
     * @return  y    the current y-coordinate of the Ball
     */
    public int getY() {
        return y;
    }
}

