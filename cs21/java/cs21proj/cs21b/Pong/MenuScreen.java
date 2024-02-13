
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
 * MenuScreen displays the background of the game. 
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
public class MenuScreen {
    private BufferedImage sprite;
    private int x, y;
    private Color color;
    public int counter = 0;
    private int delay;
    /**
     * Constructor for MenuScreen. Mainly for setting out the position of the background to be used. 
     * 
     * @param  x   x-position of the background
     * @param  y   y-position of the background
     * @param  c   Color of the background 
     */
    public MenuScreen(int x, int y, Color c) {
        this.x = x;
        this.y = y;
        
    }
    /**
     * Draws the background (with the given position and color). 
     * Mainly extracts the sprites to be used for the background. 
     */
    public void draw(Graphics2D g2d, AffineTransform reset) 
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
       sprite = ss.grabSprite((1*32),(1*32),32,32);
       for(int i = 0; i<20; i++)
            {
                g2d.drawImage(sprite,x+(i*160),y,160,160,null);
            }
       sprite = ss.grabSprite((2*32),(1*32),32,32);
       for(int a = 0; a<20; a++)
            {
                g2d.drawImage(sprite,x+(a*160),y-160,160,160,null);
            }
       sprite = ss.grabSprite((0*32),(2*32),32,32);
       for(int a = 0; a<20; a++)
            {
                g2d.drawImage(sprite,x+(a*160),y-320,160,160,null);
            }
       sprite = ss.grabSprite((1*32),(1*32),32,32);
       for(int i = 0; i<20; i++)
            {
                g2d.drawImage(sprite,x+(i*160),y-480,160,160,null);
            }
       sprite = ss.grabSprite((2*32),(1*32),32,32);
       for(int a = 0; a<20; a++)
            {
                g2d.drawImage(sprite,x+(a*160),y-640,160,160,null);
            }
       sprite = ss.grabSprite((0*32),(2*32),32,32);
       for(int a = 0; a<20; a++)
            {
                g2d.drawImage(sprite,x+(a*160),y-800,160,160,null);
            }            
    }

}