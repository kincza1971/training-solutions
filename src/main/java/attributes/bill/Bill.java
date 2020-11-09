package attributes.bill;

import java.util.ArrayList;
import java.util.List;

public class Bill {
    List<Item> items = new ArrayList<>();

    public List<Item> getItems() {
        return items;
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public double calculateTotalPrice(){
        double total = 0.0;
        for (Item item : items) {
            total += item.getQuantity()*item.getPrice();
        }
        return total;
    }
}
