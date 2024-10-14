package snakebyte;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.BorderFactory;
import javax.swing.SwingUtilities;
/******************************************************************
 * {@code @author:} A.Ford plus You
 * This class creates a display frame for Snake Game graphics.
 ******************************************************************/
public class Viewer{
    public static final int WIDTH  = GamePanel.WIDTH;
    public static final int HEIGHT = GamePanel.HEIGHT + 75;
    public static final int LEFT_X = 100;
    public static final int TOP_Y  = 100;

    public Viewer(){

        Color       bgColor     = Color.DARK_GRAY;
        GamePanel   _gamePanel  = new GamePanel();
        Controller  _controller = new Controller(_gamePanel);
        JFrame      frame       = new JFrame("Snake Byte");
        String      borderTitle = "Options";

        _controller.lowerPanel.setBorder(BorderFactory.createTitledBorder(borderTitle));
        _gamePanel.addKeyListener(_controller);
        _gamePanel.setFocusable(true);
        _gamePanel.setFocusTraversalKeysEnabled(false);

        frame.setBackground(bgColor);
        frame.setLayout(new BorderLayout());
        frame.add(_gamePanel, BorderLayout.CENTER);
        frame.add(_controller.lowerPanel, BorderLayout.SOUTH);
        frame.setSize(WIDTH, HEIGHT);
        frame.setLocation(LEFT_X, TOP_Y);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Viewer::new);
    }
}
