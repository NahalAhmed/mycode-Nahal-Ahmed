package snakebyte;

import java.awt.Font;
import java.awt.Insets;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
/******************************************************************
 * This class is part of your GitHub project.
 * Update this class to complete the snake game according to the
 * design document description (see Canvas).
 * CLASS DESCRIPTION
 * This class is the event controller for the snake game.
 ******************************************************************/
public class Controller implements KeyListener{

    public 	static final int HEIGHT  = GamePanel.HEIGHT;
    public 	static final int WIDTH   = GamePanel.WIDTH;
    public 	static final int DELAY   = 50;

    JButton gameButton;
    JPanel  lowerPanel;
    private Food       food;
    private GamePanel  game;
    private Snake 	   snake;
    private Timer 	   timer;

    public Controller(GamePanel newGame) {
        game        = newGame;
        gameButton  = new JButton("New Game");
        lowerPanel  = new JPanel();
        timer 	    = new Timer(DELAY, e -> animate());
        snake       = game.snake;
        food        = game.food;
        timer.start();
        timer.setCoalesce(true);

        gameButton.setFont(new Font("Helvetica", Font.PLAIN, 16));
        gameButton.setMargin(new Insets(20, 20 , 20 , 20));
        gameButton.addActionListener(e -> createNewGame());
        lowerPanel.add(gameButton);
    }

    private void animate() {
    }


    public void createNewGame(){
        SwingUtilities.invokeLater(Viewer::new);
    }


    public void keyPressed(KeyEvent event) {
        int keyPress = event.getKeyCode();

        game.repaint();
    }


    public void keyReleased(KeyEvent e) {}
    public void keyTyped(KeyEvent e) {}

}
