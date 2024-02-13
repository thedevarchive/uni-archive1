
import java.awt.*;
import java.awt.geom.*;

public class MyCircle {

    private double x;
    private double y;
    private double radius;
    private Color color;

    public MyCircle(double x, double y, double r, Color c) {
        this.x = x;
        this.y = y;
        radius = r;
        color = c;
    }

    public void drawObject(Graphics2D g2d, AffineTransform reset) {
        Ellipse2D.Double e = new Ellipse2D.Double(-radius, -radius, radius * 2, radius * 2);

        g2d.setColor(color);
        g2d.translate(x, y);
        g2d.fill(e);
        g2d.setTransform(reset);
    }

    public void incX(double speed) {
        x += speed;
    }

    public void incY(double speed) {
        y += speed;
    }

    public void decX(double speed) {
        x -= speed;
    }

    public void decY(double speed) {
        y -= speed;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

}

