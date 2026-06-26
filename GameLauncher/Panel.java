
/**
 * Write a description of class Panel here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.awt.image.*;
import javax.imageio.*;
public class Panel extends JPanel
{
    public Window window;
    public Graphics2D g2;
    public int currentIndex = 1;

    private int iconSize = 128;
    private int middleIconMult = 2;
    private int selectedMult = 3;

    public boolean selected = false;

    public boolean leftArrowSelected = false;
    public boolean rightArrowSelected = false;
    private int arrowSelectedMult = 2;

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g2 = (Graphics2D)g;
        drawArrows();
        drawThreeIcons();
    }

    public Panel(Window window)
    {
        this.window = window;
    }

    public void startLoop()
    {
        while(true){
            repaint();
        }
    }

    public void drawAllIcons()
    {
        int iconCount = window.icons.length;
        int positionOffset =  window.getWidth()/(iconCount+1);
        for(int i = 0; i< window.icons.length;i++)
        {
            if(g2!=null)
                window.icons[i].drawIcon(g2,positionOffset*(i+1),window.getHeight()/2,128);
        }
    }

    public void drawThreeIcons()
    {
        int positionOffset =  window.getWidth()/4;
        for(int i = 0; i< 3;i++)
        {
            int size = iconSize;
            if(window.getWidth()<window.getHeight())
                size = (int)Math.floor(size*(float)window.getWidth()/(float)window.ScreenWidth);
            else
                size = (int)Math.floor(size*(float)window.getHeight()/(float)window.ScreenHeight);

            if(i%2!=0){
                if(selected)
                    size*=selectedMult;
                else
                    size*=middleIconMult;
            }
            if(i-1+currentIndex<window.icons.length&&i-1+currentIndex>=0)
                if(g2!=null)
                    window.icons[i-1+currentIndex].drawIcon(g2,positionOffset*(i+1),window.getHeight()/2,size);
        }
    }

    public void drawArrows()
    {
        int positionOffset =  window.getWidth()/10;

        int size = iconSize;
        if(window.getWidth()<window.getHeight())
            size = (int)Math.floor(size*(float)window.getWidth()/(float)window.ScreenWidth);
        else
            size = (int)Math.floor(size*(float)window.getHeight()/(float)window.ScreenHeight);

        if(currentIndex>0){
            if(leftArrowSelected)
                window.arrows[0].drawArrow(g2,positionOffset,window.getHeight()/2,size*arrowSelectedMult,true);
            else 
                window.arrows[0].drawArrow(g2,positionOffset,window.getHeight()/2,size,true);
        }
        if(currentIndex<window.icons.length-1){
            if(rightArrowSelected)
                window.arrows[0].drawArrow(g2,positionOffset*9,window.getHeight()/2,size*arrowSelectedMult,false);
            else 
                window.arrows[0].drawArrow(g2,positionOffset*9,window.getHeight()/2,size,false);
        }
    }

}
