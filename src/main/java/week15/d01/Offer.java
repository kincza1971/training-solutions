package week15.d01;

public class Offer {
    private final Position minPosition;
    private final Position maxPosition;
    private final int margin;

    public Offer(Position minPosition, Position maxPosition) {
        this.minPosition = minPosition;
        this.maxPosition = maxPosition;
        margin = minPosition.getMargin(maxPosition);
    }

    public Position getMinPosition() {
        return minPosition;
    }

    public Position getMaxPosition() {
        return maxPosition;
    }

    public int getMargin() {
        return margin;
    }
}
