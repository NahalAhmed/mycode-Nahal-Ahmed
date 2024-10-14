package snakebyte;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.io.Serial;
import javax.swing.JPanel;
/******************************************************************
 * This class is used for the Snake Game.
 * Update this class to complete the game according to the
 * design document description (see Canvas).
 * CLASS DESCRIPTION
 * This class is used to display and animate the snake graphics.
 ******************************************************************/
public class GamePanel extends JPanel {

    @Serial
    private static final long serialVersionUID = 5L;
    public static final int WIDTH  = 600;
    public static final int HEIGHT = 600;

    Food     food;
    boolean  isOver;
    boolean  isPaused;
    Snake 	 snake;

    Color   bgColor ;
    Color   fontColor;
    Color   scoreColor;

    public GamePanel(){
        bgColor     = Color.BLACK;
        scoreColor  = Color.GRAY;
        fontColor   = Color.RED;
        isOver      = false;
        isPaused    = false;
        snake       = new Snake();
        food        = new Food(snake);
    }

    public void checkGameOver(Graphics _graphics){
    }

    public void gameOver(Graphics _graphics){
        repaint();
        _graphics.setColor(fontColor);
        _graphics.setFont( new Font("Lucida Grande", Font.BOLD, 60) );
        _graphics.drawString("Game Over", WIDTH / 4, HEIGHT / 2);
        _graphics.drawString("Score : " + food.getScore() ,  WIDTH / 4, 2 * HEIGHT / 3);
    }

    public void draw(Graphics _graphics){
        repaint();
        _graphics.setColor(bgColor);
        _graphics.fillRect(0, 0, WIDTH, HEIGHT);
        _graphics.setColor(scoreColor);
        _graphics.setFont( new Font("Verdana", Font.BOLD, 20) );
        _graphics.drawString("Score : " + food.getScore() , WIDTH / 20, HEIGHT / 20);
        snake.draw(_graphics);
        food.draw(_graphics);
    }

    public void paintComponent(Graphics _graphics) {
        super.paintComponent(_graphics);
        draw(_graphics);
        checkGameOver(_graphics);
    }

    public void update(Graphics _graphics) {
        super.update(_graphics);
        paintComponent(_graphics);
    }
}
