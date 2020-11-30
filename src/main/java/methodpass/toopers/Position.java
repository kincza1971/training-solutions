package methodpass.toopers;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class Position {
    private final double posX;
    private final double posY;

    public double distanceFrom(Position posFrom) {
        return  sqrt(pow(posX - posFrom.getPosX(),2) + pow(posY - posFrom.getPosY(),2));
    }

    public double getPosX() {
        return posX;
    }

    public double getPosY() {
        return posY;
    }

    public Position(double posX, double posY) {
        Validator.isValidPosition(posX,posY);
        this.posX = posX;
        this.posY = posY;
    }
}
