package ioreaderclasspath;

public class Country {
    private final String name;
    private final int numberOfNeighbours;

    public Country(String name, int numberOfNeighbours) {
        this.name = name;
        this.numberOfNeighbours = numberOfNeighbours;
    }

    public String getName() {
        return name;
    }

    public int getNumberOfNeighbours() {
        return numberOfNeighbours;
    }
}
