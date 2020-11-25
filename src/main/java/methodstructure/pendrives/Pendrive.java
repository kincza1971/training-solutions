package methodstructure.pendrives;

import java.util.List;

import static java.lang.Math.round;

public class Pendrive {

    private String name;
    private int capacity;
    private int price;

    public void risePrice(int percent) {
        price = (int) round(price*(1+(double)percent/100));
    }

    public int comparePricePerCapacity(Pendrive pendrive) {
        double ppcThis = getPricePerCapacity();
        double ppcParam = pendrive.getPricePerCapacity();
        if ( ppcThis> ppcParam) {
            return 1;
        } else return ppcThis == ppcParam ? 0 : -1;
    }


    public boolean cheaperThan(Pendrive pendrive) {
        return price<pendrive.getPrice();
    }

    public double getPricePerCapacity() {
        return (double)price/(double) capacity;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getPrice() {
        return price;
    }

    public Pendrive(String name, int capacity, int price) {
        this.name = name;
        this.capacity = capacity;
        this.price = price;
    }
}
