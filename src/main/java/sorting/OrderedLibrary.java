package sorting;

import java.text.Collator;
import java.util.Comparator;
import java.util.Locale;
import java.util.Set;
import java.util.TreeSet;

public class OrderedLibrary {

    private final Set<Book> books = new TreeSet<>();


    public Book lendFirstBook() {

        return books.iterator().next();
    }

    public OrderedLibrary(Set<Book> books) {
        if (books == null || books.isEmpty()) {
            throw new NullPointerException("Libray is empty!");
        }
        this.books.addAll(books);
    }
}
