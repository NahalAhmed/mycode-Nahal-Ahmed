package labs;

//TODO: Use this class to complete the CirclesLab and submit to GitHub
//      Your instructor will go over the specifics in your lab class.

public class Shapes{
    protected int x;
    protected int y;

    public Shapes(){
        this(25, 25);
    }

    public Shapes(int x, int y){
        setLocation(x, y);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    //TODO: Implement the move method for Movable

    public void setLocation(int x, int y) {
        this.x = x;
        this.y = y;
    }

}
