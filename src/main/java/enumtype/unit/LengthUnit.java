package enumtype.unit;

public enum LengthUnit {
    MILLIMÉTER(1,true), CENTIMÉTER(10,false), MÉTER(1000,true),
    YARD(1000,false), FOOT(350,false),INCH(2.54,false);

    private final double inMillimeter;
    private final boolean isSi;

    LengthUnit(double inMillimeter, boolean isSi) {
        this.inMillimeter = inMillimeter;
        this.isSi = isSi;
    }

    public double getInMillimeter() {
        return inMillimeter;
    }

    public boolean isSi() {
        return isSi;
    }
}
