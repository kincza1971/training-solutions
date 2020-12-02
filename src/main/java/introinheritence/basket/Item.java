package introinheritence.basket;

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
        return "Vonalkód: " + barcode + ", Nettó Ár: " + nettoPrice + ", ÁFA%: " + vatPercent;
    }

    public Item(String barcode, double nettoPrice, int vatPercent) {
        this.barcode = barcode;
        this.nettoPrice = nettoPrice;
        this.vatPercent = vatPercent;
    }
}
