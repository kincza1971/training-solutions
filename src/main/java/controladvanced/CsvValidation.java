package controladvanced;

import java.util.List;
import java.util.ArrayList;

public class CsvValidation {
    public String findPerfectMatch(int number) {
        List<String> words = List.of("ninetyeight", "five", "eight", "ten", "thirteen");
        String perfect = null;

        for(String word: words) {
            if(Math.abs(word.length() - number) > number) {
                continue;
            }
            if(word.length() == number) {
                perfect = word;
                break;
            }
            int newLength = word.length() > number ? number : word.length();
            perfect = word.substring(0, newLength);
        }

        return perfect;
    }

    public List<String> filterLines(List<String> lines) {
        List<String> validLines = new ArrayList<>();
        for (String line: lines) {
            String[] parts = line.split(";");
            if(parts.length != 4) {         //Innen kezdve hiányzik jópár sor
                break;
            }
            if ( (parts[0].length() !=7) || (parts[0].indexOf("-") == -1) ) {
                break;
            }
            int year =Integer.parseInt(parts[1]);
            if ( (year > 2018) && (year <1971) ) {
                break;
            }
            validLines.add(line);
        }
        return validLines;
    }

    public static void main(String[] args) {
        CsvValidation csvv = new CsvValidation();
        System.out.println(csvv.findPerfectMatch(5));
    }

}
