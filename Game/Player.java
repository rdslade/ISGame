import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.Toolkit;
import java.awt.Color;
import java.util.ArrayList;

/**
 * Write a description of class Building here.
 * 
 * @author Ryan Slade
 * @version 10/7/14
 */
public class Player
{
    private double x;
    private double y;
    private double height;
    private double width;
    private double velx;
    private double vely;
    private boolean penDown;
    private int score;
    public final int oHeight = 75;
    public final int oWidth = 75;
    public final int widthOfScreen = Toolkit.getDefaultToolkit().getScreenSize().width;
    public final int heightOfScreen = Toolkit.getDefaultToolkit().getScreenSize().height;
    
    /**
     * Constructer for car that specifies the xPosition and yPosition of the recatangle and both the height and the width
     * 
     */
    public Player()
    {
        this.x=widthOfScreen/2;
        this.y=heightOfScreen-2*oHeight;
        this.height=oHeight;
        this.width=oWidth;
        this.penDown = false;
    }
    
    /**
     * @param    g2 Graphcics2D object that draws the moon
     */
    public void draw(Graphics2D g2)
    {
        Rectangle2D.Double player = new Rectangle2D.Double(x,y,width,height);
        g2.draw(player);
        if (this.penDown == true)
        {
            g2.setColor(Color.RED);
            g2.fill(player);
        }
    }
    public void setVelX(double v)
    {
        this.velx = v;
    }
    public void setVelY(double v)
    {
        this.vely = v;
    }
    public void setSpeed(double v)
    {
        this.velx *= v;
        this.vely *=v;
    }
    public void setPen(boolean b)
    {
        penDown = b;
    }
    public void move()
    {
        this.x += this.velx;
        this.y+=this.vely;
        if (this.x > this.widthOfScreen)
        {
            this.x = 0;
        }
        else if (this.x+oWidth < 0)
        {
            this.x = this.widthOfScreen-this.oWidth;
        }
        else if (this.y+oHeight < 0)
        {
            this.y = this.heightOfScreen-this.oHeight;
        }
        else if (this.y > this.heightOfScreen)
        {
            this.y = 0;
        }
    }
    public ArrayList<Coin> checkIfTouching(ArrayList<Coin> coins)
    {
        ArrayList<Coin> n = new ArrayList<Coin>();
        for (int i =0; i<coins.size(); i++)
        {
            Coin c = coins.get(i);
            if ( (c.getX() > this.x+this.width) || (c.getX()+25 < this.x) || (c.getY()> this.y+this.height) || (c.getY()+25 < this.y)) //|| (this.penDown == false))
            {
                n.add(c);
            }
            else
            {
                score++;
            }
        }
        return n;
    }
    public int getScore()
    {
        return this.score;
    }
    public void setScore(int s)
    {
        this.score = s;
    }
}
