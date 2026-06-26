
/**
 * Write a description of class Arrow here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.awt.image.*;
import javax.imageio.*;
public class Arrow
{
    BufferedImage image = null;

    public String arowFileName = "Arrow.png";

    float imageY;
    float imageX;

    public Arrow()
    {
        try{
            image = ImageIO.read(new File(arowFileName));
        } catch(IOException e){}
        imageY = image.getHeight();
        imageX = image.getWidth();
        if(imageY>imageX)
        {
            imageX /= imageY;
            imageY = 1;
        }else
        {
            imageY /= imageX;
            imageX = 1;
        }
    }

    public void drawArrow(Graphics2D g2,int x,int y,int size,boolean flip)
    {
        int sizeX = (int)(size*imageX);
        if(flip)
            sizeX*=-1;
        int sizeY = (int)(size*imageY);
        g2.drawImage(image, x-sizeX/2, y-sizeY/2,sizeX,sizeY, null);
    }
}
