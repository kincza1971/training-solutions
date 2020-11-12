package controladvanced;

import java.util.List;
import java.util.ArrayList;

public class CsvValidation {

    public List<String> filterLines(List<String> lines) {
        List<String> validLines = new ArrayList<>();
        for (String line: lines) {
            String[] parts = line.split(";");
            if(parts.length != 4) {         //Innen kezdve hiányzik jópár sor
                break;
            }
            if ( (parts[0].length() !=7) || (parts[0].indexOf("-") == -1) ) {
                break;;
            }
            int year =Integer.parseInt(parts[1]);
            if ( (year > 2018) && (year <1971) ) {
                break;
            }
            validLines.add(line);
        }
        return validLines;
    }

}
