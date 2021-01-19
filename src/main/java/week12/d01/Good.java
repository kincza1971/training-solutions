package week12.d01;

import java.util.Objects;

public class Good implements Comparable{
    private final int weight;
    private final int price;

    public Good(int weight, int price) {
        this.weight = weight;
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Good good = (Good) o;
        return weight == good.weight && price == good.price;
    }

    @Override
    public int hashCode() {
        return Objects.hash(weight, price);
    }

    public int getWeight() {
        return weight;
    }

    public int getPrice() {
        return price;
    }



    @Override
    public int compareTo(Object o) {
        return Integer.compare(this.getWeight(),((Good) o).getWeight());
    }

    @Override
    public String toString() {
        return "(" + getWeight() + "," + getPrice() + ")";
    }
}
