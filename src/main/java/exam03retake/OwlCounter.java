package exam03retake;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class OwlCounter {
    private Map<String, Integer> numberOfOwls = new HashMap<>();

    public void readFromFile(BufferedReader reader) {
        String line;
        String[] parts;
        try {
            while ((line = reader.readLine()) != null) {
                parts = line.split("=");
                numberOfOwls.put(parts[0], Integer.parseInt(parts[1]));
            }
        } catch (IOException ie) {
            throw new IllegalStateException("Cannot read");
        }
    }

    public int getNumberOfOwls(String key) {
        return numberOfOwls.get(key);
    }
}

//Bagolyszámlálás
//A OwlCounter oszály egy Map<String, Integer> attribútumban tárolja, hogy melyik megyében mennyi baglyot számoltak
// a madárszámlálók. A readFromFile() metódussal (paraméterezése, visszatérési értéke kiderül a tesztesetből) töltsd be
// az értékeket egy fájlból! A fájl formátuma a következő:
//
//Bács-Kiskun=1000
//Baranya=1050
//Békés=980
//Borsod-Abaúj-Zemplén=600
//A getNumberOfOwls() metódus adja vissza a baglyok számát a paraméterként átadott megyében!