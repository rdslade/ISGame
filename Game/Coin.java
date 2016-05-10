import java.awt.geom.Ellipse2D;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Toolkit;
/**
 * Write a description of class Coin here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Coin
{
    // instance variables - replace the example below with your own
    private double x;
    private double y;
    private double r;
    private double vely;
    private double widthOfScreen = Toolkit.getDefaultToolkit().getScreenSize().width;
    private double heightOfScreen = Toolkit.getDefaultToolkit().getScreenSize().height;
    /**
     * Constructor for objects of class Coin
     */
    public Coin(double x, double y)
    {
        this.x = x;
        this.y = y;
        this.r = 25;
    }
    /**
     * @param    g2 Graphcics2D object that draws the moon
     */
    public void draw(Graphics2D g2)
    {
        Ellipse2D.Double coin = new Ellipse2D.Double(x,y,r,r);
        g2.setColor(Color.YELLOW);
        g2.draw(coin);
        g2.fill(coin);
    }
    public void move()
    {
        this.y+=.5;
    }
    public double getX()
    {
        return this.x;
    }
    public double getY()
    {
        return this.y;
    }
}
