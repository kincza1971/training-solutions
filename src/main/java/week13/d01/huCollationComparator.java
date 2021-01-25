package week13.d01;

import java.text.Collator;
import java.util.Comparator;
import java.util.Locale;

public class huCollationComparator implements Comparator {


    @Override
    public int compare(Object o1, Object o2) {
        Collator huCollator = Collator.getInstance(new Locale("hu", "HU"));
        return huCollator.compare(((City) o1).getName(),((City) o2).getName());
    }
}
