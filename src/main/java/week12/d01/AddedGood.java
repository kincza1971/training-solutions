package week12.d01;

import java.util.Objects;

public class AddedGood {
    private final Good good;
    private int quantity;
    private int weight;
    private int value;



    public AddedGood(Good good, int quantity) {
        this.good = good;
        value = getGood().getPrice()*quantity;
        weight = getGood().getWeight()*quantity;
        this.quantity = quantity;
    }


    public void removeOne () {
        value -= getGood().getPrice();
        weight -= getGood().getWeight();
        quantity--;
    }

        public Good getGood() {
        return good;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getWeight() {
        return weight;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.format("(%d, %d, Qty: %d, Price: %d)",+getGood().getWeight(),getGood().getPrice(),getQuantity(), getValue());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddedGood addedGood = (AddedGood) o;
        return Objects.equals(good, addedGood.good);
    }

    @Override
    public int hashCode() {
        return Objects.hash(good);
    }
}
