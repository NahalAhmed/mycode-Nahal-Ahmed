package snakebyte;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import coordinates.Point;
import java.util.ArrayList;
/******************************************************************
 * This class is used in your GitHub Snake Game Project.
 * Update this class to complete the snake game according to the
 * design document description (see Canvas).
 * CLASS DESCRIPTION
 * This class uses an ArrayList to draw the snake body graphics
 * on the game panel.
 ******************************************************************/
public class Snake {

    private Color            bodyColor;
    private Direction        direction;
    private boolean          elongate;
    private boolean          isMoving;
    private ArrayList<Point> snakeBody;

    public static final int  SQUARE     = 8;
    public static final int  START_SIZE = 20;
    public static final int  START_X    = Controller.WIDTH  / 2;
    public static final int  START_Y    = Controller.HEIGHT / 2;

    public Snake() {
        bodyColor  = Color.WHITE;
        isMoving   = false;
        elongate   = false;
        snakeBody  = make();
    }

    public void draw(Graphics _graphics) {
        Graphics2D pen = (Graphics2D) _graphics;
        pen.setColor(bodyColor);
    }


    private ArrayList<Point> make() {

        ArrayList<Point> newSnake = new ArrayList<Point>();
        newSnake.add( new Point(START_X, START_Y) );

        for (int i = 1; i < START_SIZE; i++) {
            newSnake.add(new Point(START_X - i * SQUARE , START_Y) );
        }
        return newSnake;
    }


}
