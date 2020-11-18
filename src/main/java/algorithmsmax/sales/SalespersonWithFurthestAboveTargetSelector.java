package algorithmsmax.sales;

import java.util.List;

public class SalespersonWithFurthestAboveTargetSelector {

    public Salesperson selectSalesPersonWithFurthestAboveTarget(List<Salesperson> salespersons) {
        Salesperson selected = null;
        for (Salesperson sp : salespersons){
            if(selected == null || selected.getDifferenceFromTarget() < sp.getDifferenceFromTarget()) {
                selected = sp;
            }
        }
        return selected;
    }

}
