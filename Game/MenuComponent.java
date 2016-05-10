import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.CardLayout;
public class MenuComponent extends JPanel
{
    private JButton start;
    private JPanel contentPane;
    public MenuComponent(JPanel panel)
    {
        contentPane = panel;
        this.start = new JButton("Start");
        start.addActionListener(new ClickListener());
        this.add(this.start);
    }
    public class ClickListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            CardLayout cardLayout = (CardLayout) contentPane.getLayout();
            cardLayout.next(contentPane);
        }
    }
}