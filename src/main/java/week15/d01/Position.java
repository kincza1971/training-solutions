package week15.d01;

public class Position {
    private final int numberOfDay;
    private final int price;

    public Position(int numberOfDay, int price) {
        this.numberOfDay = numberOfDay;
        this.price = price;
    }

    public int getNumberOfDay() {
        return numberOfDay;
    }

    public int getPrice() {
        return price;
    }

    public int getMargin(Position position) {
        return getPrice() - position.getPrice();
    }
}
