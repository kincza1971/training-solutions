package collectionscomp;

import java.util.Comparator;

public class AuthorComparator implements Comparator<Konyv> {

    @Override
    public int compare(Konyv o1, Konyv o2) {
        return o1.getAuthor().compareTo(o2.getAuthor());
    }

    @Override
    public boolean equals(Object obj) {
        return false;
    }
}
