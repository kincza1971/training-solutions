package interfacestaticmethods;

import java.util.List;

public interface Valued {

    double getValue();

    static double totalValue(List<Valued> products) {
        double sum =0;
        for (Valued valued : products) {
            sum += valued.getValue();
        }
        return sum;
    }

}
