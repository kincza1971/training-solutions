package math;

import static java.lang.Math.abs;

public class Point {

    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public double distance (Point otherPoint) {
        // abs elhagyható a négyzetre emelés miatt
        return Math.sqrt(Math.pow(getX()- otherPoint.getX(),2.0) + Math.pow(getY()-otherPoint.getY(),2.0));
    }
}
