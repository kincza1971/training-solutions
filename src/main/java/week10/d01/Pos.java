package week10.d01;

public class Pos {
    private double x;
    private double y;
    private double alt;

    public Pos(double x, double y, double alt) {
        this.x = x;
        this.y = y;
        this.alt = alt;
    }

    public double getX() {
        return x;
    }

    public double isY() {
        return y;
    }

    public double getAlt() {
        return alt;
    }

    @Override
    public String toString() {
        return Double.toString(x) + ", " + Double.toString(y) +", " + Double.toString(alt);
    }
}
