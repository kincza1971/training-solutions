package sorting;


import java.text.Collator;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Locale;

public class OrderedArrayLibrary {

    private Book[] books;

    public Book[] sortingById() {
        Arrays.sort(books);
        return books;
    }

    public Book[] sortingByTitle() {


        Comparator<Book> compareTile = new Comparator<Book>() {
            Collator huCollator = Collator.getInstance(new Locale("hu", "HU"));
            public int compare(Book o1, Book o2) {
                return huCollator.compare(o1.getTitle(),o2.getTitle());
            }
        };

        Arrays.sort(books,compareTile);

        return books;

    }


    public OrderedArrayLibrary(Book[] books) {
        this.books = books;
    }
}
