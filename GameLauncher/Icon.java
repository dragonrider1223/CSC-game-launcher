
/**
 * Write a description of class Icon here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
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
        } catch(IOException e)
        {
            File file = new File(window.gameDir+"/"+gameName+"/"+gameName+".exe");
            javax.swing.Icon icon = FileSystemView.getFileSystemView().getSystemIcon(file,1028,1028);
            image = new BufferedImage(
                icon.getIconWidth(),
                icon.getIconHeight(),
                BufferedImage.TYPE_INT_ARGB
            ); 

            Graphics g = image.createGraphics();
            // paint the Icon to the BufferedImage.
            icon.paintIcon(null, g, 0,0);
            g.dispose();
        }
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
        Font font =new Font("Arial", Font.BOLD, size/4);

        FontMetrics metrics = g2.getFontMetrics(font);

        g2.setFont(font);

        int sizeX = (int)(size*imageX);
        int sizeY = (int)(size*imageY);
        g2.drawImage(image, x-sizeX/2, y-sizeY/2,sizeX,sizeY, null);
        g2.drawString(gameName,x-metrics.stringWidth(gameName) / 2,y+sizeY);
    }
}
