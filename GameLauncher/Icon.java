
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
    
    public Icon(String gameName,Window window)
    {
        this.gameName = gameName;
        try{
            image = ImageIO.read(new File(window.gameDir+"/"+gameName+"/"+gameName+"_icon.png"));
        } catch(IOException e){}
    }

    public void drawIcon(Graphics2D g2,int x,int y,int size)
    {
        g2.drawImage(image, x-size/2, y-size/2,size,size, null);
    }
}
