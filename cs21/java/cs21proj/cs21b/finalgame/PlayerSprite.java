
import java.awt.*;
import java.awt.geom.*;

public class PlayerSprite {

    private double x, y, radius;
    private Color color;

    public PlayerSprite(double x, double y, double r, Color c) {
        this.x = x;
        this.y = y;
        radius = r;
        color = c;
    }

    public void drawSprite(Graphics2D g2d, AffineTransform reset) {
        Ellipse2D.Double e = new Ellipse2D.Double(-radius, -radius, radius * 2, radius * 2);
        g2d.setColor(color);
        g2d.translate(x, y);
        g2d.fill(e);
        g2d.setTransform(reset);
    }

    public void moveH(double n) {
        x += n;
    }

    public void moveV(double n) {
        y += n;
    }
    
    public void setX(double n) {
        x = n;
    }
    
    public void setY(double n) {
        y = n;
    }
    
    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }

}
