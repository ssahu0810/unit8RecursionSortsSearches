//********************************************************************
//  FractalPanel.java       Author: Lewis/Loftus/Cocking
//
//  Represents a drawing surface on which to paint a Fractal Snowflake.
//********************************************************************

import java.awt.*;
import javax.swing.JPanel;

public class FractalPanel extends JPanel
{
    //vierwe dimensions
    private final int PANEL_WIDTH = 800;
    private final int PANEL_HEIGHT = 800;
    
    //beginning point
    private final int beginX = 400, beginY = 500;
    
    //current order
    private int current; 
    private int dLength = 120;
    
    //angle stuff
    private final double fractionLength = 0.8;
    private double branchingAngle = 0.15;
    private double angleChange = 0.15;
    
    
    /**
     * FractalPanel Constructor
     *
     * @param currentOrder current order the recursion is on
     */
    public FractalPanel (int currentOrder)
    {
        current = currentOrder;
        setBackground (Color.black);
        setPreferredSize (new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
    }

    /**
     * handles recursive method of creating branches off of branches
     *
     * @param dLength length of branch
     * @param startX starting x position
     * @param startY starting y position
     * @param angle angle between branches
     * @param g2 graphics object
     * @param branchingAngle initial branching angle
     * @param angleChange how much the angle increases/decreases by
     */
    public void branch(double dLength, int startX, int startY, double angle, Graphics g2, double branchingAngle, double angleChange)
    {
        int endX1, endX2, endY1, endY2;
        dLength *= fractionLength;
        
        //creates angle between branches
        double angle1 = angle + branchingAngle;
        double angle2 = angle - branchingAngle;

        //finds endpoints
        endX1 = (int)(startX - dLength*Math.cos(angle1));
        endY1 = (int)(startY - dLength*Math.sin(angle1));
        endX2 = (int)(startX - dLength*Math.cos(angle2));
        endY2 = (int)(startY - dLength*Math.sin(angle2));

        //increases angle and rate at which it increases
        branchingAngle += angleChange;
        angleChange += 0.05;
        
        g2.drawLine(startX, startY, endX1, endY1);
        g2.drawLine(startX, startY, endX2, endY2);
        
        //check terminating sequence
        //if true, call it twice
        if (dLength >= 35)
        {
            branch(dLength, endX1, endY1, 1.57+0.2, g2, branchingAngle, angleChange);
            branch(dLength, endX2, endY2, 1.57+0.2, g2, branchingAngle, angleChange);
        }

    }

    /**
     * Performs the initial calls to the drawFractal method.
     *
     * @param g2 graphics object
     */
    public void paintComponent (Graphics g2)
    {
        super.paintComponent (g2);

        g2.setColor (Color.white);
        g2.drawLine(400,600,400,500);

        branch(dLength, beginX, beginY, 1.57, g2, branchingAngle, angleChange);
    }

    /**
     * Sets the fractal order to the value specified.
     *
     * @param order order number
     */
    public void setOrder (int order)
    {
        current = order;
    }

    /**
     * Returns the current order.
     *
     * @return order of the recursion
     */
    public int getOrder ()
    {
        return current;
    }

}
