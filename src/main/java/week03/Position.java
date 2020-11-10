package week03;

import java.util.ArrayList;
import java.util.List;

public class Position {

    private String position;
    private int bonus;

    public Position(String position, int bonus) {
        this.position = position;
        this.bonus = bonus;
    }

    @Override
    public String toString() {
        return  position + " (" + bonus + ")";
    }


    public int getBonus() {
        return bonus;
    }


    public static void main(String[] args) {
        List<Position> positions = new ArrayList<>();

        positions.add(new Position("takarító",150000));
        positions.add(new Position("manager",1250000));
        positions.add(new Position("bakter",50000));

        for (Position position : positions) {
            if (position.getBonus()>150000) {
                System.out.println(position.toString());
            };
        }

    }
}
