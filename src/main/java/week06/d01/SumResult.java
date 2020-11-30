package week06.d01;

public class SumResult {
    private final double negSum;
    private final double posSum;

    public double getNegSum() {
        return negSum;
    }

    public double getPosSum() {
        return posSum;
    }

    public SumResult(double negSum, double posSum) {
        this.negSum = negSum;
        this.posSum = posSum;
    }
}
