package abstractclass.gamecharacter;

import static java.lang.Math.*;

public class Point {
    private final int posX;
    private final int posY;

    public float distance(Point otherPoint) {
        return round(sqrt(pow(posX - otherPoint.getX(),2) + pow(posY-otherPoint.getY(),2)));
    }

    public int getX() {
        return posX;
    }

    public int getY() {
        return posY;
    }

    public Point(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
    }
}
