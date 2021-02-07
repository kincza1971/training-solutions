package lambdastreams.bookstore;

public class Book {
    private final String title;
    private final int yearOfPublish;
    private int price;
    private int stock;

    public Book(String title, int yearOfPublish, int price, int stock) {
        this.title = title;
        this.yearOfPublish = yearOfPublish;
        this.price = price;
        this.stock = stock;
    }

    public String getTitle() {
        return title;
    }

    public int getYearOfPublish() {
        return yearOfPublish;
    }

    public int getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public int getStockValue() {
        return price * stock;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", yearOfPublish=" + yearOfPublish +
                ", price=" + price +
                ", stock=" + stock +
                '}';
    }
}
