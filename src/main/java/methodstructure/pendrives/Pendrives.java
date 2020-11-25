package methodstructure.pendrives;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.round;

public class Pendrives {

    public Pendrive best(List<Pendrive> pendriveList) {
        Pendrive bestPendrive = null;
        for (Pendrive pendrive: pendriveList) {
            if (bestPendrive == null || bestPendrive.comparePricePerCapacity(pendrive)==1) {
                bestPendrive = pendrive;
            }
        }
        return bestPendrive;
    }

    public Pendrive cheapest(List<Pendrive> pendriveList) {
        Pendrive cheapestPendrive = null;
        for (Pendrive pendrive: pendriveList) {
            if (cheapestPendrive == null || pendrive.cheaperThan(cheapestPendrive)) {
                cheapestPendrive = pendrive;
            }
        }
        return cheapestPendrive;
    }

    public void risePriceWhereCapacity(List<Pendrive> pendriveList, int percent, int capacity) {
        for (Pendrive pendrive : pendriveList) {
            if (pendrive.getCapacity() == capacity) {
                pendrive.risePrice(percent);
            }
        }
    }


}
