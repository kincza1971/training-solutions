package classstructureconstructors;

public class Store {
    private String product;
    private int stock;

    public Store(String product) {
        this.product = product;
        this.stock=0;
    }

    public void store(int qty) {
        this.stock += qty;
    }
    public void dispatch(int qty) {
        this.stock -= qty;
    }

    public String getProduct() {
        return product;
    }

    public int getStock() {
        return stock;
    }
}
