import java.awt.geom.Line2D;
import javax.swing.JComponent;
import java.awt.Graphics2D;
import java.awt.Graphics;

public class TriangleComponent extends JComponent
{
    private int x1,x2,x3,y1,y2,y3;
    private int count = 0;
    private Line2D.Double point1, point2, point3,side1,side2,side3;
    public void drawPoint(int x,int y)
    {
        //Sejal was here
        if (count == 0)
        {
            this.x1 = x;
            this.y1 = y;
            point1 = new Line2D.Double(x1,y1,x1,y1);
            repaint();
        }
        else if (count == 1)
        {
            this.x2 = x;
            this.y2 = y;
            point2 = new Line2D.Double(x2,y2,x2,y2);
            side1 = new Line2D.Double(x1,y1,x2,y2);
            repaint();
        }
        else if (count == 2)
        {
            this.x3 = x;
            this.y3 = y;
            point3 = new Line2D.Double(x3,y3,x3,y3);
            side2 = new Line2D.Double(x2,y2,x3,y3);
            side3 = new Line2D.Double(x3,y3,x1,y1);
            repaint();
        }
        else
        {
            repaint();
        }
        count++;
    }

    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;
        if (count ==0)
        {
            
        }
        else if (count == 1)
        {
            g2.draw(point1);
        }
        else if(count==2)
        {
            g2.draw(point2);
            g2.draw(side1);
        }
        else if(count == 3)
        {
            g2.draw(point3);
            g2.draw(side1);
            g2.draw(side2);
            g2.draw(side3);
        }
        else if(count == 4)
        {
            count = 0;
        }
    }
}