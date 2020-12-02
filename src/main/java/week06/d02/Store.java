package week06.d02;

import java.util.List;

public class Store {

    private final List<Product> products;

    private void checkCategory(Category category) {
        if (category == null) {
            throw new NullPointerException("Category cannot be null");
        }
    }


    public int getProductByCategoryName(Category category) {
        checkCategory(category);

        int counter = 0;

        for (Product product : products) {
            if (product.getCategory().equals(category)) {
                counter++;
            }
        }

        return counter;
    }

    // objektum
    public StockByCategory getProductsByCategory() {
        StockByCategory stock = new StockByCategory();
        for (Product product : products) {
            stock.addToStock(product.getCategory());
        }
        return stock;
    }

    //lista
    public List<CategoryStock> getStockListByCategory() {
        CategoryStockList stockList = new CategoryStockList();
        for (Product product : products) {
            stockList.add(product.getCategory());
        }
        return stockList.getStocks();
    }


    public Store(List<Product> products) {
        if (products == null || products.size() ==0) {
            throw new IllegalArgumentException("Product list cannot be null or empty");
        }
        this.products = products;
    }
}
