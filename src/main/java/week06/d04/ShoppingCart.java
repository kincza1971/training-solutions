package week06.d04;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ShoppingCart {

    private List<Item> itemList = new ArrayList<>();

    private String checkedName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        return name.toLowerCase().trim();
    }

    public int getItem(String name) {
        String checkedName = checkedName(name);
        for (Item item : itemList) {
            if (item.getName().equals(checkedName)) {
                return item.getQuantity();
            }
        }
        return 0;
    }


    private boolean chkQty(Item item, int newQty) {
        if (item.getQuantity()+newQty <=0) {
            itemList.remove(item);
            return false;
        }
        return true;
    }

    public void addItem(String name, int quantity) {
        String checkedName = checkedName(name);
        for (Item item : itemList) {
            if (item.getName().equals(checkedName)) {
                if (chkQty(item,quantity)) {
                    item.incQty(quantity);
                }
                return;
            }
        }
        itemList.add(new Item(checkedName,quantity));
    }
}
