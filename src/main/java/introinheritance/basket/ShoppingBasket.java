package introinheritance.basket;

public class ShoppingBasket {
    private Basket basket;

    public void addItem(Item item) {
        basket.addItem(item);
    }
    public void removeItem(String barcode) {
        basket.removeItem(barcode);
    }

    public double sumNettoPrice() {
        double sumNetto = 0;
        for (Item item : basket.getItems()) {
            sumNetto += item.getNettoPrice();
        }
        return sumNetto;
    }

    public double sumTaxValue() {
        double sumVAT = 0;
        for (Item item : basket.getItems()) {
            sumVAT += item.getTaxAmount();
        }
        return sumVAT;
    }

    public double sumBruttoPrice() {
        double netto = sumNettoPrice();
        double VAT = sumTaxValue();
        return netto + VAT;
    }

    public void checkout() {
        basket.clearBasket();
    }
    public void removeMostExpensiveItem() {
        double max = Double.MIN_VALUE;
        String barCode = "";
        for (Item item : basket.getItems()) {
            if (item.getNettoPrice() + item.getTaxAmount() > max) {
                max = item.getNettoPrice() + item.getTaxAmount();
                barCode = item.getBarcode();
            }
        }
        removeItem(barCode);
    }

    public ShoppingBasket() {
    }

    //
}
