package week15.d05;


import week15.d05.Country;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;


public class CovidCounter {

    public static final String FIELD_SEPARATOR = ",";
    public static final int WEEK_INDEX = 1;
    public static final int NUMBER_OF_CASES_INDEX = 2;
    public static final int COUNTRY_INDEX = 4;
    public static final int POPULATION_INDEX = 7;

    private final Path path = Path.of("src/main/resources","data.csv");
    private List<Country> countries = new ArrayList<>();

    public List<Country> getCountryMostCases() {
        loadFromFile();
        Collections.sort(countries, Collections.reverseOrder());
        return countries.stream().limit(3).collect(Collectors.toList());
    }


    private void loadFromFile() {
        try (BufferedReader br = Files.newBufferedReader(path)){
            String line = br.readLine();
            String countryName="";
            int population = 0;
            int cases =0;
            while ((line=br.readLine()) != null) {
                String[] lineParts = line.split(FIELD_SEPARATOR);
                if (!lineParts[COUNTRY_INDEX].equals(countryName)) {
                    if(!countryName.equals("")) {
                        countries.add(new Country(countryName, population, cases));
                    }
                    countryName = lineParts[COUNTRY_INDEX];
                    cases =0;
                }
                population = lineParts[POPULATION_INDEX].isBlank() ? 0:Integer.parseInt(lineParts[POPULATION_INDEX]);
                cases += Integer.parseInt(lineParts[NUMBER_OF_CASES_INDEX]);
            }
            countries.add(new Country(countryName, population, cases));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        CovidCounter cc = new CovidCounter();
        System.out.println(cc.getCountryMostCases());
    }
}
