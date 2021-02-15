package lambdaprimitives;

import java.text.Format;
import java.util.DoubleSummaryStatistics;
import java.util.IntSummaryStatistics;
import java.util.List;

public class SportGadgetStore {
   private final List<Product> products;

    public SportGadgetStore(List<Product> products) {
        this.products = products;
    }

    public long getNumberOfProducts() {
        return products.stream().mapToInt(Product::getQuantity).summaryStatistics().getSum();
    }

    public double getAveragePrice() {
        DoubleSummaryStatistics prc = products.stream().mapToDouble(Product::getPrice).summaryStatistics();
        try {
            return  prc.getAverage();
        } catch (Exception e) {
            return 0;
        }
    }

    public String getExpensiveProductStatistics(double minPrice) {
        IntSummaryStatistics qty = products.stream().filter(p -> p.getPrice()>minPrice).mapToInt(Product::getQuantity).summaryStatistics();
        long types = products.stream().filter(p -> p.getPrice()>minPrice).count();
        if (qty.getSum() == 0) {
            return "Nincs ilyen termék.";
        } else {
            return String.format("Összesen %d féle termék, amelyekből minimum %d db, maximum %d db, összesen %d db van."
                    ,types
                    ,qty.getMin()
            ,qty.getMax()
            ,qty.getSum());
        }
    }


}

//A SportGadgetStore osztály tárolja a termékek listáját, és különböző statisztikákat készít belőle. Az osztály kapja meg a listát kívülről.
//
//Készítsd el a következő metódusokat streamek segítségével:
//
//getNumberOfProducts(): összesen hány termék van a boltban,
//
//getAveragePrice(): átlagosan mennyibe kerül egy termék. Ha nincs termék, 0-t adjon vissza.
//
//getExpensiveProductStatistics(double minPrice): adott árnál drágább termékek darabszámáról szolgáltat statisztikát.
// Az összesítést szövegként adja vissza az alábbi formában:
//
//Összesen 3 féle termék, amelyekből minimum 1 db, maximum 52 db, összesen 74 db van.
//
//Ha nincs ilyen, akkor a visszaadott szöveg a Nincs ilyen termék. legyen!
