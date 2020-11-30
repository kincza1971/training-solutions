package methodpass.toopers;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

public class HeadQuarter {

    private List<Trooper> troopers= new ArrayList<>();

    public void addTrooper(Trooper trooper) {
        troopers.add(trooper);
    }

    public Trooper findTrooperByName (String name) {
        Validator.isValidTrooperName(name);
        for (Trooper trooper : troopers) {
            if (trooper.getName().equals(name)) {
                return trooper;
            }
        }
        throw new IllegalArgumentException("Ilyen állat márpedig nincs: " + name);
    }

    public void moveTrooperByName(String name, Position newPos) {
        findTrooperByName(name).changePosition(newPos);
    }

    public Trooper findClosestTrooper(Position position){
        double minDist = Double.MAX_VALUE;
        Trooper closest = null;
        for (Trooper trooper : troopers) {
            if (trooper.distanceFrom(position) < minDist) {
                minDist = trooper.distanceFrom(position);
                closest=trooper;
            }
        }
        return  closest;
    }

    public void moveClosestTrooper(Position newPos) {
        findClosestTrooper(newPos).changePosition(newPos);
    }

    public void moveTrooper(Trooper trooper, Position newPos) {
        trooper.changePosition(newPos);
    }

    public List<Trooper> getTroopers() {
        return troopers;
    }
}
