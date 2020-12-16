package week08.d02;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class CountryStatistic {
    public static final int COUNTRY_NAME_INDEX = 0;
    public static final int POPULATION_INDEX = 1;
    public static final int FLAG_COLOR_INDEX = 2;
    public static final int NEIGHBORS_INDEX = 3;
    List<Country> countries = new ArrayList<>();


    private FileReader createFileReader(String stringPath) {
        try {
            FileReader fr = new FileReader(stringPath, StandardCharsets.UTF_8);
            return fr;
        } catch (IOException e) {
            throw new IllegalArgumentException("File not found, " + stringPath,e);
        }
   }

   private String [] splitLine (String line){
       String[] fields = line.split(" ");
       if (fields.length != 4) {
           throw new IllegalArgumentException("Wrong line in file, " + line);
       }
       return fields;

   }

    private Country processLine(String line) {
        try {
            String[] fields = splitLine(line);
            return new Country(fields[COUNTRY_NAME_INDEX], fields[POPULATION_INDEX],
                    fields[FLAG_COLOR_INDEX], fields[NEIGHBORS_INDEX]
            );
        } catch (IllegalArgumentException iax) {
            throw new IllegalArgumentException("Line cannot be processed, " + line,iax);
        }
    }

    public Country maxPopulation() {
        int max = Integer.MIN_VALUE;
        Country maxPop = null;
        for (Country country : countries) {
            if (country.getPopulation() > max) {
                max = country.getPopulation();
                maxPop = country;
            }
        }
        return maxPop;
    }

    public void loadCountriesFromFile(String stringPath) {
        try (BufferedReader br = new BufferedReader(createFileReader(stringPath))) {
            String line;
            while ((line= br.readLine()) != null) {
                countries.add(processLine(line));
            }
        } catch (IOException iox) {
            throw new IllegalArgumentException("Cannot read file, " + stringPath, iox);
        }

    }

    public void loadCountriesFromFile2(String stringPath) {
        Path file = Path.of(stringPath);
        try {
            List<String> lines =  Files.readAllLines(file);
            for (String line : lines) {
                countries.add(processLine(line));
            }
        } catch (IOException iox) {
            throw new IllegalArgumentException("Cannot read file, " + stringPath, iox);
        }

    }


    public List<Country> getCountries() {
        return List.copyOf(countries);
    }
}
