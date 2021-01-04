package week10.d01;

public class Differences {
    private double increasing;
    public double decreasing;

    public void add(double diff) {
        if (diff<0) {
            decreasing -= diff;
        } else {
            increasing += diff;
        }
    }

    public double getIncreasing() {
        return increasing;
    }

    public double getDecreasing() {
        return decreasing;
    }
}
