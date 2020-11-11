package typeconversion.whichtype;

public enum Type {

    BYTE(-128L,+127L), SHORT(-32768L,32767L), INT(-2_147_483_648L,2_147_483_647L);
    private final long minValue;
    private final long maxValue;

    Type(long minValue, long maxValue) {
        this.minValue = minValue;
        this.maxValue = maxValue;
    }

    public long getMinValue() {
        return minValue;
    }

    public long getMaxValue() {
        return maxValue;
    }
}
