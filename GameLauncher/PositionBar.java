
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

    int yPos;

    public PositionBar(Window window,float widthPercentage, float heightPercentage,int yPos)
    {
        this.iconCount = window.icons.length;
        this.window = window;
    }

    public void drawCircle(Graphics2D g2,int x,int y,int size)
    {
        g2.drawOval( x-size/2, y-size/2,size,size);
    }
}
