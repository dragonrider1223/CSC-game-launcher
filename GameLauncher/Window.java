
/**
 * Generates the window
 *
 * @Joshua Wolf
 * @version 11/06/2026
 */
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.awt.image.*;
import javax.imageio.*;
public class Window extends JFrame
{
    JPanel mainPanel;
    BufferedImage image = null;
    
    final int ScreenWidth = 1000;
    final int ScreenHeight = 1000;
    /**
     * Constructor for objects of class Window
     */
    public Window()
    {
        setTitle("The launcher");
        this.getContentPane().setPreferredSize(new Dimension(ScreenWidth,ScreenHeight));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        try{
            image = ImageIO.read(new File("test.png"));
        } catch(IOException e){}
    
        
        mainPanel = new JPanel()
        {
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D)g;
                g2.drawImage(image, 0, 0, null);
            }
        };
        mainPanel.setBackground(Color.WHITE);
        this.add(mainPanel);
        
        this.pack();
        this.toFront();
        this.setVisible(true);
        
        while(true)
            mainPanel.repaint();
    }
    
}
