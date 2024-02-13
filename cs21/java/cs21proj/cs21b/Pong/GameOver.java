import java.awt.*;
import java.awt.geom.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
public class GameOver {
    private String level;
    private int x, y, radius;
    private Color color;
    private int delay = 50;
    private int counter;
    private int counter2;
    private int health;
    private int walkstage;
    private BufferedImage sprite;
    private int playerAnimStagex;
    private int playerAnimStagey;
    private boolean dead = false;
    public GameOver(int x, int y) 
    {
        this.x = x;
        this.y = y;
    }
    public void draw(Graphics2D g2d, AffineTransform reset) {
            if(dead)
            {
                g2d.setColor(Color.RED);
                Font font = new Font("DialogInput", Font.PLAIN, 20);
                g2d.setFont(font);
                g2d.drawString("Game Over", x, y);
                g2d.setTransform(reset);
            }
    }
    public void kill()
    {
        dead = true;
    }
    public void moveH(int n) {
        x += n;
    }

    public void moveV(int n) {
        y += n;
    }
    
    public void setX(int n) {
        x = n;
    }
    
    public void setY(int n) {
        y = n;
    }
    
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    
}

