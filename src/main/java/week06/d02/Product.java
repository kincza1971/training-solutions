package week06.d02;


public class Product {

    private String name;
    private Category category;
    private int price;

    public Category getCategory() {
        return category;
    }

    public Product(String name, Category category, int price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }
}
