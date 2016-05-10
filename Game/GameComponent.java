import java.awt.*;
import javax.swing.*;
import java.util.Random;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
public class GameComponent extends JPanel
{
    private Player p;
    private Timer timer;
    private ArrayList<Coin> coins;
    
    private Random r;
    private int counter;
    private AddCoin addC;
    
    private JPanel contentPane;
    private JLabel scoreLabel;
    private JLabel gameOver;
    private JButton back;
    
    private final double speed = 1;
    public GameComponent(JPanel panel)
    {
        this.setFocusable(true);
        this.contentPane = panel;
        this.addKeyListener(new MyKeyListener());
        
        r = new Random();
        counter = 0;
        
        this.p = new Player();
        
        this.scoreLabel = new JLabel(new Integer(p.getScore()).toString());
        this.back = new JButton("Back");
        this.back.addActionListener(new ClickListener());
        
        this.add(this.scoreLabel);
        this.add(this.back);
       
        this.coins= new ArrayList<Coin>();
        this.addC = new AddCoin();
    }
    /**
     * @param    g Graphics object to create each object and draw it to the screen
     */
    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;
        p.draw(g2);
        p.move();
        this.coins = p.checkIfTouching(this.coins);
        counter++;
        if (counter%250==0)
        {
            addC.run();
            System.out.println(counter);
        }
        for (int i=0; i<this.coins.size(); i++)
        {
            this.coins.get(i).moveAccel(.005); //good accelleration is .005; good velocity is .5
            this.coins.get(i).draw(g2);
        }
        this.scoreLabel.setText("<html><font color='BLUE'><font size=18> Score: "+new Integer(p.getScore()).toString());
        requestFocusInWindow();
        repaint();
    }
    public void gameOver()
    {
        this.add(this.gameOver);
        gameOver.setText("<html><font color='RED'><font size=18> GAME OVER!");
    }
    public void reset()
    {
        p.setScore(0);
        coins.clear();
    }
    class MyKeyListener implements KeyListener
    {    
        public MyKeyListener()
        {
            
        }
        public void keyTyped(KeyEvent event)
        {
            
        }
        public void keyPressed(KeyEvent event)
        {
            int i = event.getKeyCode();
            if (i==37 )
            {
                //left
                p.setVelX(-speed);
            }
            else if (i==39)
            {
                //right
                p.setVelX(speed);
            }
            else if (i==32)
            {
                p.setPen(true);
            }
        }
        public void keyReleased(KeyEvent event)
        {
            int i = event.getKeyCode();
            if (i==37 || i==39 )
            {
                //left
                p.setVelX(0);
            }
            else if (i==38 || i==40)
            {
                //up
                p.setVelY(0);
            }
            else if (i==32)
            {
                p.setPen(false);
            }
        }
    }
    public class ClickListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            CardLayout cardLayout = (CardLayout) contentPane.getLayout();
            cardLayout.next(contentPane);
            reset();

        }
    }
    public class AddCoin
    {
        private int width = Toolkit.getDefaultToolkit().getScreenSize().width;
        //private int heigth = Toolkit.getDefaultToolkit().getScreenSize().height;
        private Random r = new Random();
        public void run()
        {
            int x = r.nextInt(width-25);
            int y = 100;
            Coin c = new Coin(x,y);
            coins.add(c);
        }
    }
}
