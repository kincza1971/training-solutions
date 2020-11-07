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

    public double distance (Point otherPint) {
        int x = this.getX();
        int y = this.getY();
        int x1 = otherPint.getX();
        int y1= otherPint.getY();
        double a =abs(x-x1);
        double b =abs(y-y1);
        return Math.sqrt(Math.pow(a,2.0) + Math.pow(b,2.0));
    }
}
