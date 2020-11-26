package methodchain.robot;

public class NavigationPoint {
    private int distance;
    private int azimut;

    @Override
    public String toString() {
        return String.format("distance: %d azimut: %d",distance,azimut);
    }

    public NavigationPoint(int distance, int azimut) {
        this.distance = distance;
        this.azimut = azimut;
    }
}
