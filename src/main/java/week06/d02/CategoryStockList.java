package week06.d02;

import java.util.ArrayList;
import java.util.List;

public class CategoryStockList {

    private List<CategoryStock> stocks = new ArrayList<>();

    private boolean isFoundAndAdd(Category category) {
        boolean found = false;
        for (CategoryStock cs : stocks) {
            if (cs.getCategory().equals(category)) {
                cs.incStock();
                found=true;
                break;
            }
        }
        return found;
    }

    public void add(Category category) {
        if (!isFoundAndAdd(category)) {
            stocks.add(new CategoryStock(category).incStock());
        }
    }



    public List<CategoryStock> getStocks() {
        return stocks;
    }
}
