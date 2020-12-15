package week08.d02;

public class Country {
    private final String nameOfCountry;
    private final int population;
    private final int numberOfColors;
    private final int numberOfNeighbors;

    private String validateNameOfCountry(String nameOfCountry) {
        if (nameOfCountry.isBlank()) {
            throw new IllegalArgumentException("Country name cannot be empty, " + nameOfCountry);
        }
        return nameOfCountry;
    }

    private int parseInt(String toParse) {
        try {
            return Integer.parseInt(toParse);
        } catch (NumberFormatException nfx) {
            throw new IllegalArgumentException("");
        }
    }

    private int validatePopulation(String population) {
        try {
            return parseInt(population);
        } catch (IllegalArgumentException iax) {
            throw new IllegalArgumentException("Number of population is not valid, " + population);
        }
    }

    private int validateNumberOfColors(String numberOfColors) {
        try {
            return parseInt(numberOfColors);
        } catch (IllegalArgumentException iax) {
            throw new IllegalArgumentException("Number of population is not valid, " + numberOfColors);
        }
    }

    private int validateNumberOfNeighbors(String numberOfNeighbors) {
        try {
            return parseInt(numberOfNeighbors);
        } catch (IllegalArgumentException iax) {
            throw new IllegalArgumentException("Number of population is not valid, " + numberOfNeighbors);
        }
    }

    public Country(String nameOfCountry, String population, String numberOfColors, String numberOfNeighbors) {
        this.nameOfCountry = validateNameOfCountry(nameOfCountry);
        this.population = validatePopulation(population);
        this.numberOfColors = validateNumberOfColors(numberOfColors);
        this.numberOfNeighbors = validateNumberOfNeighbors(numberOfNeighbors);

    }
}
