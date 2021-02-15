package week15.d05;

public class Country implements Comparable<Country>{
    private String name;
    private int population;
    private int cases;

    public Country(String name, int population, int cases) {
        this.name = name;
        this.population = population;
        this.cases = cases;
    }

    public String getName() {
        return name;
    }

    public int getPopulation() {
        return population;
    }

    public int getCases() {
        return cases;
    }

    public double getRate() {
        if (population == 0) {
            return 0;
        }
        return (double) cases/population;
    }


    @Override
    public int compareTo(Country o) {
        return Double.compare(this.getRate(),o.getRate());
    }

    @Override
    public String toString() {
        return "Country{" +
                       "name='" + name + '\'' +
                       ", population=" + population +
                       ", cases=" + cases +
                       ", rate=" + getRate() +
                       '}';
    }
}
