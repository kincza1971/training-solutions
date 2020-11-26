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

    public boolean isEmpty(String str) {
        return (str == null || str == "");
    }

    public long getPrice() {
        return price;
    }

    public Currency geteCurr() {
        return eCurr;
    }

    public Product(long price, String currency) {
        if (isEmpty(currency)) {
            throw new IllegalArgumentException("Currency must not empty");
        }
        this.price = price;
        this.eCurr=Currency.valueOf(currency);
    }

    public Product(long price, Currency currency) {
        if (currency == null) {
            throw new NullPointerException("Currency object cannot be null");
        }
        this.price = price;
        this.eCurr=currency;
    }
}
