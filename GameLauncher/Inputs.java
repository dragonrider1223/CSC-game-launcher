
/**
 * Write a description of class Inputs here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.awt.event.*;
import java.io.*;
public class Inputs  implements ActionListener, MouseListener
{
    Window window;
    
    Runtime runtime;
    public Inputs(Window window)
    {
        this.window = window;
        
    }
    
    public void actionPerformed(ActionEvent e){}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
    public void mousePressed(MouseEvent e) 
    {
        if(window.mainPanel.currentIndex<window.icons.length-1&&e.getX()>window.ScreenWidth*2/3)
            window.mainPanel.currentIndex++;
        else if(window.mainPanel.currentIndex>0&&e.getX()<window.ScreenWidth/3)
            window.mainPanel.currentIndex--;
        else
            launchGame(window.gameDir+"/"+window.icons[window.mainPanel.currentIndex].gameName,"/"+window.icons[window.mainPanel.currentIndex].gameName+".exe");
    }
    public void mouseReleased(MouseEvent e) {}
    public void mouseClicked(MouseEvent e) {}
    
    public void launchGame(String filePath, String ExeName)
    {
        try{
            Runtime.getRuntime().exec(filePath+ExeName, null, new File(filePath));}
        catch(IOException e)
        {
            System.out.println(e);
        }

    }
}
