package introconstructors;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Restaurant {
    List<String> menu = new ArrayList<>();
    String name;
    int capacity;

    private void setMenu() {
        menu = Arrays.asList("Bojúpörkölt - 1500 Ft", "Rose kacsamell - 2450 Ft", "Fácánleves fürjtojással - 1490 Ft");
    }

    public Restaurant(String name, int numberOfTables) {
        this.name = name;
        this.capacity = 4 * numberOfTables;
        setMenu();
    }

    public List<String> getMenu() {
        return menu;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

}


