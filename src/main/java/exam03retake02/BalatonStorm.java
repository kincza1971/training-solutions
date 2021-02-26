package exam03retake02;

import java.io.BufferedReader;
import java.io.IOException;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

public class BalatonStorm {

    public List<String> getStationsInStorm(BufferedReader br) {
        try {
            br.readLine();
            List<String> result = new ArrayList<>();
            String line;
            int level;
            while (!(line = br.readLine()).equals("]")) {
                processOneStation(br, result);
            }
            sortTheList(result);
            return result;
        } catch (IOException e) {
            throw new IllegalStateException("Cannot read file", e);
        }
    }

    private void sortTheList(List<String> result) {
        result.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                Collator huCollator = Collator.getInstance(new Locale("hu", "HU"));
                return huCollator.compare(o1, o2);
            }
        });
    }

    private void processOneStation(BufferedReader br, List<String> result) throws IOException {
        String name = "";
        for (int i = 0; i < 7; i++) {
            if (i == 1) {
                name = br.readLine().split(":")[1];
                name = name.substring(2, name.length() - 2);
            }
            if (i == 4) {
                if (Integer.parseInt(br.readLine().split(":")[1].substring(1, 2)) == 3) {
                    result.add(name);
                }
            }
            br.readLine();
        }
    }
}
//new Comparator<>() {
//
//            public int compare(Book o1, Book o2) {
//                return huCollator.compare(o1.getTitle(),o2.getTitle());
//            }