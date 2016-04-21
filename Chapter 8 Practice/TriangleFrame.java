import javax.swing.JFrame;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class TriangleFrame extends JFrame
{
    private static final int FRAME_WIDTH = 300;
    private static final int FRAME_HEIGHT = 400;
    private TriangleComponent scene;
    public TriangleFrame()
    {
        scene = new TriangleComponent();
        add(scene);

        MouseListener listener = new MousePressListener();
        scene.addMouseListener(listener);

        setSize(FRAME_WIDTH,FRAME_HEIGHT);
    }
    class MousePressListener implements MouseListener
    {
        public void mouseClicked(MouseEvent event)
        {
            int x = event.getX();
            int y = event.getY();
            scene.drawPoint(x,y);
        }

        public void mousePressed(MouseEvent event){}

        public void mouseReleased(MouseEvent event){}

        public void mouseEntered(MouseEvent event){}

        public void mouseExited(MouseEvent event){}

    }
}