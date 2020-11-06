package finalmodifier;

public class TaxCalculator {

    public static final double VAT = 0.27;

    public double tax(double price) {
        return price * VAT;
    }

    public double priceWithTax(double price) {
        return price * (1 + VAT);
    }

}
