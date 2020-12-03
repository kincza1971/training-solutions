package introinheritance.basket;

import java.util.ArrayList;
import java.util.List;

public class Basket {

    private List<Item> itemList = new ArrayList<>();

    public void addItem(Item item) {
        itemList.add(item);
    }

    public void removeItem(String barcode){

        List<Item> remainedList = new ArrayList<>();

        for (Item item : itemList) {
            if (!item.getBarcode().equals(barcode)) {
                remainedList.add(item);
            }
        }
        itemList = remainedList;
    }

    public void clearBasket() {
        itemList = new ArrayList<>();
    }


    public List<Item> getItems() {
       return List.copyOf(itemList);
    }

}
