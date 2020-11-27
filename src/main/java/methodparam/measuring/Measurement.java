package methodparam.measuring;

public class Measurement {

    private double[] measures;

    public int findFirstIndexInLimit(double min, double max) {
        if (measures.length<1) {
            return -1;
        }
        for (int i = 0; i<measures.length; i++) {
            if (measures[i] >= min && measures[i]<=max) {
                return i;
            }
        }
        return -1;
    }

    public double minimum() {
        double min =Double.MAX_VALUE;
        for (int i = 0; i<measures.length; i++) {
            if (measures [i] < min) {
                min = measures[i];
            }
        }
        return min;
    }

    public Measurement(double[] measures) {
        this.measures = measures;
    }

}
