package lambdacomparator;

import java.util.Comparator;

public class CloudStorage implements Comparable<CloudStorage>{
    private final String provider;
    private final int space;
    private double price;
    private PayPeriod payPeriod;


    public CloudStorage(String provider, int space) {
        this.provider = provider;
        this.space = space;
    }

    public CloudStorage(String provider, int space, PayPeriod payPeriod, double price) {
        this(provider,space);
        this.price = price;
        this.payPeriod = payPeriod;
    }

    public String getProvider() {
        return provider;
    }

    public int getSpace() {
        return space;
    }

    public double getPrice() {
        return price;
    }

    public PayPeriod getPayPeriod() {
        return payPeriod;
    }

    public PayPeriod getPeriod() {
        return payPeriod;
    }

    @Override
    public int compareTo(CloudStorage o) {
        double thisValue = getPayPeriod()==null? 0 : getPrice()/getSpace()/getPayPeriod().getLength();
        double thatValue = o.getPayPeriod()==null? 0 : o.getPrice()/o.getSpace()/o.getPayPeriod().getLength();
        return Double.compare(thisValue,thatValue);
    }
}
