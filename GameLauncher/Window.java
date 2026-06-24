
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
import java.util.Arrays;
public class Window extends JFrame
{
    Panel mainPanel;

    public String gameDir = "./games";

    Inputs input;

    Icon[] icons;

    public final int ScreenWidth = 1000;
    public final int ScreenHeight = 1000;
    /**
     * Constructor for objects of class Window
     */
    public Window()
    {
        input = new Inputs(this);

        String[] gameNames = getgames();
        icons = new Icon[gameNames.length];
        for (int i = 0; i< gameNames.length;i++)
            icons[i] = new Icon(gameNames[i],this);

        setTitle("The launcher");
        this.getContentPane().setPreferredSize(new Dimension(ScreenWidth,ScreenHeight));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        mainPanel = new Panel(this);
        mainPanel.setBackground(Color.WHITE);
        this.add(mainPanel);

        this.addMouseListener(input);

        this.pack();
        this.toFront();
        this.setVisible(true);

        mainPanel.startLoop();
    }

    public String[] getgames()
    {
        File file = new File(gameDir);
        String[] directories = file.list(new FilenameFilter() {
                    @Override
                    public boolean accept(File current, String name) {
                        return new File(current, name).isDirectory();
                    }
                });
        System.out.println(Arrays.toString(directories));
        return directories;
    }

}
