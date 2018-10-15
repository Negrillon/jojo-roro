package mysokoban.fx.core;

public class Coord_x_y {
    private int x;
    private int y;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public Coord_x_y(int x, int y){
        this.x = x;
        this.setY(y);
    }

    @Override
    public String toString() {
        return new String("le point : "+(x)+" ; " +
                ""+(getY()));
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}

