
/**
 * Write a description of class Inputs here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.awt.event.*;
import java.io.*;
public class Inputs  implements ActionListener, MouseListener, MouseMotionListener 
{
    Window window;
    
    Runtime runtime;
    public Inputs(Window window)
    {
        this.window = window;
        
    }
    
    public void actionPerformed(ActionEvent e){}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) 
    {
            window.mainPanel.selected = false;
            window.mainPanel.leftArrowSelected = false;
            window.mainPanel.rightArrowSelected = false;
    }
    public void mousePressed(MouseEvent e) 
    {
        if(window.mainPanel.currentIndex<window.icons.length-1&&e.getX()>window.getWidth()*4/5)
            window.mainPanel.currentIndex++;
        else if(window.mainPanel.currentIndex>0&&e.getX()<window.getWidth()/5)
            window.mainPanel.currentIndex--;
        else if(e.getX()>=window.getWidth()/3&&e.getX()<=window.getWidth()*2/3)
            launchGame(window.gameDir+"/"+window.icons[window.mainPanel.currentIndex].gameName,"/"+window.icons[window.mainPanel.currentIndex].gameName+".exe");
    }
    public void mouseReleased(MouseEvent e) {}
    public void mouseClicked(MouseEvent e) {}
    public void mouseMoved(MouseEvent e) {
        if(e.getX()>=window.getWidth()/3&&e.getX()<=window.getWidth()*2/3)
            window.mainPanel.selected = true;
        else
            window.mainPanel.selected = false;
        if(e.getX()<window.getWidth()/5)
            window.mainPanel.leftArrowSelected = true;
        else if(e.getX()>window.getWidth()*4/5)
            window.mainPanel.rightArrowSelected = true;
        else
        {
            window.mainPanel.leftArrowSelected = false;
            window.mainPanel.rightArrowSelected = false;
        }
        
    }
    public void mouseDragged(MouseEvent e) {}
    
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
