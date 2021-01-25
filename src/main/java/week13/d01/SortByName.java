package week13.d01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.Collator;
import java.util.Locale;

public class SortByName {

    private Collator huCollator = Collator.getInstance(new Locale( "hu", "HU"));

    private String getSmaller(String line, String firstInAbc) {
        String[] lineParts = line.split(";");
        String aktCity = lineParts[1];
        if (huCollator.compare(firstInAbc,aktCity) <0) {
            return firstInAbc;
        } else return aktCity;
    }

    public String getFirstCityInAbcFromFile(InputStream is) {
        if (is ==null) {
//            is = this.getClass().getResourceAsStream("varosok.csv");
            throw new IllegalStateException("Cannot read file");
        }
        String firstInAbc = "ZZ";
        try (BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
            String line;
            line = br.readLine();
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
