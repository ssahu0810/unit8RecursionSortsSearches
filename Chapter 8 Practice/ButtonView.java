import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import java.awt.event.ActionEvent;

public class ButtonView
{
    private static final int FRAME_WIDTH = 100;
    private static final int FRAME_HEIGHT = 100;

    private JFrame frame;
    private JPanel panel;
    private JLabel label1;
    private JButton button;
    private JButton button2;

    public ButtonView()
    {
        this.frame = new JFrame();
        this.panel = new JPanel();
        this.button = new JButton("Click me!");
        this.button2 = new JButton("Click me too!");
        this.label1 = new JLabel();
        panel.add(button);
        panel.add(button2);
        panel.add(label1);

        ClickListener listener = new ClickListener();
        button.addActionListener(listener);
        button2.addActionListener(listener);

        frame.add(panel);
        frame.setSize(FRAME_WIDTH,FRAME_HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public class ClickListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            System.out.println("Button " + event.getActionCommand() + " was clicked!");
        }
    }

}