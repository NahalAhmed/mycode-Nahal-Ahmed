package labs;

import java.awt.Color;
import java.awt.Graphics;

//TODO: Use this class to complete the CirclesLab and submit to GitHub

public class CirclesLab {

//    public static void testDrawable(Viewer display, Drawable circles) throws Exception {
//
//        //TODO: Set Location to (50, 50)
//
//        // TODO : Clear then Pause for 250 milliseconds
//        display.pause(250);
//
//        // TODO : Move location by (50, 0) and draw Yellow Circles
//
//        // TODO : Move location by (0, 100) and draw RED Circles
//
//        // TODO : Move location by (0, 100) and draw Circles with Fillable AZUL
//
//        // TODO : Pause for 250 milliseconds
//
//    }
//
//    public static void testFillable(Viewer display, Fillable circles) throws Exception {
//
//        //TODO: Set Location to (40, 40)
//
//        // TODO : Pause for 250 milliseconds
//        display.pause(250);
//
//        // TODO : Draw fillable RED Circles then move (-25,40)
//
//        // TODO : Draw fillable WHITE Circles then move (50,-50)
//
//        // TODO : Draw fillable AZUL Circles
//
//        // TODO : Pause for 250 milliseconds
//
//    }

    public static void main(String[] args) throws Exception{

        Viewer viewer01 = new Viewer(50, 50, 600, 600);
        Viewer viewer02 = new Viewer(800, 50, 400, 600);
        viewer01.setBackground(Color.BLACK);
        viewer02.setBackground(Color.BLACK);

        // Get Graphics graphic Object for Drawing in Window
        Graphics graphic01 = viewer01.getGraphics();
        Graphics graphic02 = viewer02.getGraphics();

        // TODO : Create Circles of a Fillable Type with graphics object 1

        // TODO : Use testFillable to draw Fillable Circles with viewer 1

        // TODO : Create Circles of a Drawable Type with graphics object 2

        // TODO : Use testDrawable to draw Open Drawable Circles with viewer 2

    }

}
