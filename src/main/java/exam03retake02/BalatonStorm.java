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
            String name;
            int level;
            while (!(line = br.readLine()).equals("]")) {
                br.readLine();
                name = br.readLine().split(":")[1];
                name = name.substring(1, name.length() - 1);
                br.readLine();
                br.readLine();
                br.readLine();
                if (Integer.parseInt(br.readLine().split(":")[1].substring(1, 2)) == 3) {
                    result.add(name);
                }
                br.readLine();
                br.readLine();
                br.readLine();
            }
            result.sort(new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    Collator huCollator = Collator.getInstance(new Locale("hu", "HU"));
                    return huCollator.compare(o1, o2);
                }
            });
            return result;
        } catch (IOException e) {
            throw new IllegalStateException("Cannot read file", e);
        }
    }
}
//new Comparator<>() {
//
//            public int compare(Book o1, Book o2) {
//                return huCollator.compare(o1.getTitle(),o2.getTitle());
//            }