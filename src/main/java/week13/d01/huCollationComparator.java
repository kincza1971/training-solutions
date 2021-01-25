package week13.d01;

import java.text.Collator;
import java.util.Comparator;
import java.util.Locale;

public class huCollationComparator implements Comparator<City> {


    @Override
    public int compare(City o1, City o2) {
        Collator huCollator = Collator.getInstance(new Locale("hu", "HU"));
        return huCollator.compare(o1.getName(), o2.getName());
    }
}
