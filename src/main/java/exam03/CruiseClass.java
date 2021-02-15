package exam03;

public enum CruiseClass {

    LUXURY(3.0), FIRST(1.8), SECOND(1.0);

    private double classRate;


    CruiseClass(double classRate) {
        this.classRate = classRate;
    }

    public double getClassRate() {
        return classRate;
    }
}
