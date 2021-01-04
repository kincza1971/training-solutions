package ioconvert.products;

public class Product {
    private final String name;
    private final int price;

    @Override
    public String toString() {
        return name+";"+Integer.toString(price);
    }

    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

}
