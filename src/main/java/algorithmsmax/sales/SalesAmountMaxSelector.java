package algorithmsmax.sales;

import java.util.List;

public class SalesAmountMaxSelector {

    public Salesperson selectSalesPersonWithMaxSalesAmount(List<Salesperson> salespersons) {
        Salesperson personWithMax = null;
        for (Salesperson sp : salespersons) {
            if(personWithMax==null || personWithMax.getAmount()<sp.getAmount()) {
                personWithMax = sp;
            }
        }
        return personWithMax;
    }
}
