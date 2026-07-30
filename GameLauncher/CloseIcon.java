
/**
 * Write a description of class CloseIcon here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.awt.image.*;
import javax.imageio.*;
public class CloseIcon
{
    BufferedImage image = null;

    public String closeFileName = "Close.png";

    float imageY;
    float imageX;

    public CloseIcon()
    {
        try{
            image = ImageIO.read(new File(closeFileName));
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

    public void draw(Graphics2D g2,int x,int y,int size)
    {
        int sizeX = (int)(size*imageX);
        int sizeY = (int)(size*imageY);
        g2.drawImage(image, x-sizeX/2, y-sizeY/2,sizeX,sizeY, null);
    }
}
