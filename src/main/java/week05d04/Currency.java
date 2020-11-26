package week05d04;

public enum Currency {
    HUF(1), USD(300);
    private double rate;

    public double getRate() {
        return rate;
    }

    Currency(double rate) {
        this.rate = rate;
    }
}
