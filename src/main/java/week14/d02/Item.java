package week14.d02;

public class Item {
    private final String itemName;
    private final int itemPrice;

    public Item(String itemName, int itemPrice) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
    }

    public String getItemName() {
        return itemName;
    }

    public int getItemPrice() {
        return itemPrice;
    }

    @Override
    public String toString() {
        return String.format("%s(%d)",getItemName(),getItemPrice());
    }
}
