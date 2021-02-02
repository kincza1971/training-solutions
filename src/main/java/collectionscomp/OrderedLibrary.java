package collectionscomp;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;


public class OrderedLibrary {

    private final List<Konyv> konyvs = new ArrayList<>();


    public Konyv lendFirstBook() {

        return konyvs.iterator().next();
    }

    public OrderedLibrary(List<Konyv> konyvs) {
        if (konyvs == null || konyvs.isEmpty()) {
            throw new NullPointerException("Libray is empty!");
        }
        this.konyvs.addAll(konyvs);
    }

    public List<Konyv> orderedByAuthor() {
        konyvs.sort(new AuthorComparator());
        return new ArrayList<>(konyvs) ;
    }

    public List<Konyv> orderedByTitle() {
        konyvs.sort(Comparator.naturalOrder());
        return new ArrayList<>(konyvs);
    }

    public List<String> orderedByTitleLocale(Locale locale) {
        konyvs.sort(Comparator.comparing(Konyv::getTitle, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Collator.getInstance(locale).compare(o1,o2);
            }
        }));
        List<String> titles = new ArrayList<>();
        for (Konyv konyv : konyvs) {
            titles.add(konyv.getTitle());
        }

        return titles;
    }
}
