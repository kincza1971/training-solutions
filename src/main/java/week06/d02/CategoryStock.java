package week06.d02;

public class CategoryStock {
    private Category category;
    private int stock;

    public CategoryStock incStock() {
        stock++;
        return this;
    }

    public Category getCategory() {
        return category;
    }

    public int getStock() {
        return stock;
    }

    public CategoryStock(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return category.name() + ": " + stock;
    }
}
