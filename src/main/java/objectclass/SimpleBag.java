package objectclass;

import java.util.ArrayList;
import java.util.List;

public class SimpleBag {

    private List itemList = new ArrayList();
    private int cursor;

    private void checkObject(Object item) {
        if (item==null) {
            throw new IllegalArgumentException("Null cannot be added to list");
        }
    }

    public void putItem(Object item) {
        checkObject(item);
        itemList.add(item);

    }

    public boolean isEmpty() {
        return itemList.isEmpty();
    }
    public int size() {
        return itemList.size();
    }
    public void beforeFirst() {
        cursor = -1;
    }
    public boolean hasNext() {
        return !itemList.isEmpty() && cursor< itemList.size()-1;
    }
    public Object next() {
        if (hasNext()) {
            cursor++;
            return itemList.get(cursor);
        }
        return null;
    }
    public boolean contains(Object item) {
        return itemList.contains(item);
    }
    public int getCursor() {
        return cursor;
    }
}
