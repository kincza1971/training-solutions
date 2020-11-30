package methodpass.toopers;

public class Trooper {

    private String name;
    private Position position;

    private void isPosNull(Position position) {
        if (position==null) {
            throw new IllegalArgumentException("Position must not null");
        }
    }

    public void changePosition(Position newPosition) {
        isPosNull(newPosition);
        position = newPosition;
    }

    public double distanceFrom(Position aPos) {
        isPosNull(aPos);
        return position.distanceFrom(aPos);
    }

    public String getName() {
        return name;
    }

    public Position getPosition() {
        return position;
    }

    public Trooper(String name) {
        Validator.isValidTrooperName(name);
        this.name = name;
        position = new Position(0.0, 0.0);
    }
}
