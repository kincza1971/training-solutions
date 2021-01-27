package week02.d05;

public class Product {
    private String name;
    private String code;

    public Product(String name, String code) {
        this.name = name;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public boolean areTheyEqual(Product p) {

        return ((this.name.equals(p.getName())) && (Math.abs((this.code).length() - p.getCode().length()) <= 1));
    }

    public static void main(String[] args) {
        Product p1 = new Product("Termek", "1234");
        Product p2 = new Product("Termek", "12345");
        System.out.println(p1.areTheyEqual(p2));

    }

}
