package ioreadwritebytes.temperatures;

public class Temperatures {
    private final byte[] data;

    public double getYearAverage() {
        double sum = 0;
        for(byte b : data) {
            sum += b;
        }
        return sum/data.length;
    }

    public byte[] getData() {
        return data;
    }

    public Temperatures(byte[] data) {
        this.data = data;
    }

}
