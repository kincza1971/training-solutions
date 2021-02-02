package introinheritance.basket;

import java.util.Locale;

public class Item {
    private String barcode;
    private double nettoPrice;
    private int vatPercent;


    public double getTaxAmount() {
        return nettoPrice*vatPercent/100;
    }

    public double getNettoPrice() {
        return nettoPrice;
    }
    public String getBarcode() {
        return barcode;
    }

    @Override
    public String toString() {
        return String.format(new Locale("en","EN"),"Item{barcode='%s', nettoPrice=%5.1f, vatPercent=%d}", barcode,nettoPrice,vatPercent);
    }

    public Item(String barcode, double nettoPrice, int vatPercent) {
        this.barcode = barcode;
        this.nettoPrice = nettoPrice;
        this.vatPercent = vatPercent;
    }
}
