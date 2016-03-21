//********************************************************************
//  FractalPanel.java       Author: Lewis/Loftus/Cocking
//
//  Represents a drawing surface on which to paint a Fractal Snowflake.
//********************************************************************

import java.awt.*;
import javax.swing.JPanel;

public class FractalPanel extends JPanel
{
    private final int PANEL_WIDTH = 400;
    private final int PANEL_HEIGHT = 400;

    private final double SQ = Math.sqrt(3.0) / 6;

    private final int TOPX = 200, TOPY = 20;
    private final int LEFTX = 60, LEFTY = 300;
    private final int RIGHTX = 340, RIGHTY = 300;
    
    private final int beginX = 300, beginY = 300;

    private int current; //current order
    private int dLength = 100;
    
    private final double fractionLength = 0.8;
    private final double branchingAngle = 0.35;

    //-----------------------------------------------------------------
    //  Sets the initial fractal order to the value specified.
    //-----------------------------------------------------------------
    public FractalPanel (int currentOrder)
    {
        current = currentOrder;
        setBackground (Color.black);
        setPreferredSize (new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
    }

    //-----------------------------------------------------------------
    //  Draws the fractal recursively. Base case is an order of 1 for
    //  which a simple straight line is drawn. Otherwise three
    //  intermediate points are computed, and each line segment is
    //  drawn as a fractal.
    //-----------------------------------------------------------------
    /**
    public void drawFractal (int order, int x1, int y1, int x5, int y5,
    g2raphics g2)
    {
    int deltaX, deltaY, x2, y2, x3, y3, x4, y4;

    if (order == 1)
    g2.drawLine (x1, y1, x5, y5);
    else
    {
    deltaX = x5 - x1;  // distance between end points
    deltaY = y5 - y1;

    x2 = x1 + deltaX / 3;  // one third
    y2 = y1 + deltaY / 3;

    x3 = (int) ((x1+x5)/2 + SQ * (y1-y5));  // tip of projection
    y3 = (int) ((y1+y5)/2 + SQ * (x5-x1));

    x4 = x1 + deltaX * 2/3;  // two thirds
    y4 = y1 + deltaY * 2/3;

    drawFractal (order-1, x1, y1, x2, y2, g2);
    drawFractal (order-1, x2, y2, x3, y3, g2);
    drawFractal (order-1, x3, y3, x4, y4, g2);
    drawFractal (order-1, x4, y4, x5, y5, g2);
    }
    }
     */

    public void branch(double dLength, int startX, int startY, double angle, Graphics g2)
    {
        int endX1, endX2, endY1, endY2;
        dLength *= fractionLength;
        
        double angle1 = angle + branchingAngle;
        double angle2 = angle - branchingAngle;
        
        endX1 = (int)(startX - dLength*Math.sin(angle1));
        endY1 = (int)(startY - dLength*Math.cos(angle2));
        endX2 = (int)(startX + dLength*Math.sin(angle1));
        endY2 = (int)(startY + dLength*Math.cos(angle2));
        
        g2.drawLine(startX, startY, endX1, endY1);
        g2.drawLine(startX, startY, endX2, endY2);

    }

    //-----------------------------------------------------------------
    //  Performs the initial calls to the drawFractal method.
    //-----------------------------------------------------------------
    public void paintComponent (Graphics g2)
    {
        super.paintComponent (g2);

        g2.setColor (Color.white);

        branch(dLength, beginX, beginY, 0.3, g2);
    }

    //-----------------------------------------------------------------
    //  Sets the fractal order to the value specified.
    //-----------------------------------------------------------------
    public void setOrder (int order)
    {
        current = order;
    }

    //-----------------------------------------------------------------
    //  Returns the current order.
    //-----------------------------------------------------------------
    public int getOrder ()
    {
        return current;
    }

}
