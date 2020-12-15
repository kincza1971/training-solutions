package week08.d02;

import org.junit.jupiter.api.Test;

import java.util.List;

public class CountryStatisticTest {

    CountryStatistic cs = new CountryStatistic();

    @Test
    public void loadTest() {
        cs.loadCountriesFromFile("src/main/resources/countries.txt");
        List<Country> countries = cs.getCountries();
    }
}
