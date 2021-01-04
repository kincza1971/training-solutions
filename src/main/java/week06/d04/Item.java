package week06.d04;

public class Item {
    private String name;
    private int quantity;

    private String checkedName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        return name.toLowerCase().trim();
    }


    public void incQty(int quantity) {
        this.quantity += quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getName() {
        return name;
    }


    public Item(String name, int quantity) {
        this.name = checkedName(name);
        if (quantity <= 0) {
            throw new IllegalArgumentException("A mennyiség nem lehet kevesebb, mint 0");
        }
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "(" + getName()+", " + Integer.toString(getQuantity()) + ")";
    }
}
