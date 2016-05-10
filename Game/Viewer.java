import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Toolkit;
import java.awt.CardLayout;
import javax.swing.BorderFactory;

/**
 * Class that contains the main method for the program and creates the frame containing the component.
 * 
 * @author @gcschmit
 * @version 18 July 2014
 */
public class Viewer 
{
    /**
     * main method for the program which creates and configures the frame for the program
     *
     */
    public static void main(String[] args)
    {
        JFrame frame = new JFrame();
        
        frame.setSize(Toolkit.getDefaultToolkit().getScreenSize().width /* x */, Toolkit.getDefaultToolkit().getScreenSize().height /* y */);
        frame.setTitle("Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel contentPane = new JPanel();
        //contentPane.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new CardLayout());
        
        MenuComponent mcomponent = new MenuComponent(contentPane);
        GameComponent gcomponent = new GameComponent(contentPane);
        contentPane.add(gcomponent,"Game");
        contentPane.add(mcomponent,"Menu");
        
        frame.setContentPane(contentPane);
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

}
