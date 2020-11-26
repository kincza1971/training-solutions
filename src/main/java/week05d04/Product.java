package week05d04;

public class Product {

    private long price;
    private Currency eCurr;

    public double convertPrice(String currency) {
        if (this.eCurr.name().equals(currency)) {
            return price;
        } else {
            return this.eCurr.getRate() * this.price / Currency.valueOf(currency).getRate();
        }
    }

    public long getPrice() {
        return price;
    }

    public Currency geteCurr() {
        return eCurr;
    }

    public Product(long price, String currency) {
        this.price = price;
        this.eCurr=Currency.valueOf(currency);
    }

    public Product(long price, Currency currency) {
        this.price = price;
        this.eCurr=currency;
    }
}
