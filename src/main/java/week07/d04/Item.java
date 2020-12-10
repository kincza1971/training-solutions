package week07.d04;

public class Item {
    private String name;
    private double quantity;
    private double price;

    public double getAmount () {
        return getQuantity()*getPrice();
    }

    public String getName() {
        return name;
    }

    public double getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }


    public Item(String name, double quantity, double price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }
}
