
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
public class Icon
{

    BufferedImage image = null;

    public String gameName;

    float imageY;
    float imageX;

    public Icon(String gameName,Window window)
    {
        this.gameName = gameName;
        try{
            image = ImageIO.read(new File(window.gameDir+"/"+gameName+"/"+gameName+"_icon.png"));
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

    public void drawIcon(Graphics2D g2,int x,int y,int size)
    {
        int sizeX = (int)(size*imageX);
        int sizeY = (int)(size*imageY);
        g2.drawImage(image, x-sizeX/2, y-sizeY/2,sizeX,sizeY, null);
    }
}
