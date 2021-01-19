package week12.d02;

public class Land implements Comparable {
    private final Side side;
    private final int width;
    private final String color;
    private final int houseNumber;

    public Land(Side side, int width, String color, int houseNumber) {
        this.side = side;
        this.width = width;
        this.color = color;
        this.houseNumber = houseNumber;
    }

    public Side getSide() {
        return side;
    }

    public int getWidth() {
        return width;
    }

    public String getColor() {
        return color;
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    @Override
    public int compareTo(Object o) {
        return Integer.compare(this.width, ((Land) o).getWidth());
    }

    @Override
    public String toString() {
        StringBuilder fence = new StringBuilder();
        fence.append("(" + houseNumber + ")");
        for (int i=0; i < width; i++){
            fence.append(color);
        }
        return fence.toString();
    }
}