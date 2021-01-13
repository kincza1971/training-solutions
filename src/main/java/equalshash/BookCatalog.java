package equalshash;

import java.util.ArrayList;
import java.util.List;

public class BookCatalog {

    List<Book> books = new ArrayList<>();





    public BookCatalog(List<Book> books) {
        this.books = books;
    }

    public List<Book> getBooks() {
        return books;
    }
}
