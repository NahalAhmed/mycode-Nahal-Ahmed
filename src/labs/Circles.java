package labs;

import java.awt.Color;
import java.awt.Graphics;

//TODO: Use this class to complete the CirclesLab and submit to GitHub
//      Your instructor will go over the specifics in your lab class.
public class Circles {

    private final Color     color;
    private final Graphics  graphic;

    public Circles(Graphics _graphics){
        this.graphic = _graphics;
        this.color   = Color.LIGHT_GRAY;
    }

    //TODO: These methods have errors unless given the correct inheritance structure
    //      Update class to make the methods below work
//    public Circles(Graphics _graphics, int x, int y){
//        super(x, y);
//        this.graphic = _graphics;
//        this.color   = Color.LIGHT_GRAY;
//    }
//
//    @Override
//    public void draw(Color color) {
//        graphic.setColor(color);
//        for (int i = 1; i < 11; i++) {
//            graphic.drawOval(x, y, 20 * i, 20 * i);
//        }
//        System.out.println();
//    }
//
//
//    @Override
//    public void fill(Color color) {
//        graphic.setColor(color);
//        for (int i = 1; i < 7; i++) {
//            graphic.fillOval(x * i, y * i, 10 * i, 10 * i);
//        }
//    }

}
