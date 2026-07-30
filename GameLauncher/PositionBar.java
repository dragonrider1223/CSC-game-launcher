
/**
 * Write a description of class Icon here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.awt.image.*;
import javax.imageio.*;
public class PositionBar
{

    int iconCount;
    Window window;

    float widthPercentage;
    float heightPercentage;
    float sizePercentage;

    public PositionBar(Window window,float widthPercentage, float heightPercentage,float sizePercentage)
    {
        this.iconCount = window.icons.length;
        this.window = window;
        this.heightPercentage = heightPercentage;
        this.sizePercentage = sizePercentage;
        this.widthPercentage = widthPercentage;
    }

    public void drawBar(Graphics2D g2,int index)
    {
        float width = window.getWidth()*widthPercentage;
        float height = window.getHeight()*sizePercentage;
        float xPos = window.getWidth()/2-width/2;
        float yPos = window.getHeight()*heightPercentage-(height/2);
        float iconOffset = width/(iconCount+1);
        for(int i = 1;i<=iconCount;i++)
        {
            
            drawCircle(g2,Math.round(xPos+iconOffset*i),Math.round(yPos),Math.round(height),(index==i-1));
        }
    }
    
    public void drawCircle(Graphics2D g2,int x,int y,int size,boolean filled)
    {
        if(!filled)
            g2.drawOval( x-size/2, y-size/2,size,size);
        else
            g2.fillOval( x-size/2, y-size/2,size,size);
    }
}
