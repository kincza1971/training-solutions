package ioreaderclasspath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CountryStatistic {

    public static final int INDEX_OF_COUNTRY = 0;
    public static final int INDEX_OF_NEIGHBOURS = 1;
    private List<Country> countries = new ArrayList<>();

    private void procLine(String line) {
        String[] lineParts = line.split(" ");
        countries.add(new Country(lineParts[INDEX_OF_COUNTRY],Integer.parseInt(lineParts[INDEX_OF_NEIGHBOURS])));
    }

    public void loadFromFile() {
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader((this.getClass().getResourceAsStream("/countries.txt"))))) {
            String line;
            while ((line = br.readLine()) != null) {
                procLine(line);
            }
        } catch (IOException e) {
            throw new IllegalStateException("Cannot read file");
        }
    }

    public int getNumberOfCountries() {
        return countries.size();
    }

    public Country getCountryWithMaxNumberOfNeighbours() {
        int max=0;
        Country resultCountry = null;
        for (Country country : countries) {
            if (country.getNumberOfNeighbours() > max) {
                max=country.getNumberOfNeighbours();
                resultCountry = country;
            }
        }
        return resultCountry;
    }

}
