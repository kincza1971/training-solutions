package week13.d01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.Collator;
import java.util.Locale;

public class SortByName {

    public static final String FIELD_SEPARATOR = ";";
    public static final int INDEX_OF_CITY = 1;
    private final Collator huCollator = Collator.getInstance(new Locale( "hu", "HU"));

    private String getSmaller(String line, String firstInAbc) {
        String[] lineParts = line.split(FIELD_SEPARATOR);
        String aktCity = lineParts[INDEX_OF_CITY];
        if (huCollator.compare(firstInAbc,aktCity) <0) {
            return firstInAbc;
        } else return aktCity;
    }

    private void checkStream(InputStream is){
        if (is ==null) {
            throw new IllegalStateException("Cannot read file");
        }
    }

    public String getFirstCityInAbcFromFile(InputStream is) {
        checkStream(is);
        String firstInAbc = "ZZ";
        try (BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
            String line = br.readLine();
            while ((line = br.readLine()) != null) {
                firstInAbc = getSmaller(line,firstInAbc);
            }
        } catch (IOException e) {
               throw new IllegalStateException("Cannot read file",e);
        }
        return firstInAbc;
    }

    public static void main(String[] args) {
        SortByName sortByName = new SortByName();
        System.out.println(sortByName.getFirstCityInAbcFromFile(null));
    }
}
