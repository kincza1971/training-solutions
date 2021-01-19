package collectionsiterator;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class LibraryManager {
    private Set<Book> bookSet = new HashSet<>();

    public Book findBookByRegNumber(int regNumber) {
        Iterator<Book> bi = bookSet.iterator();
        Book book;
        while (bi.hasNext()) {
            book = bi.next();
            if (book.getRegNumber() == regNumber) {
                return book;
            }
        }
        throw new MissingBookException("Book cannot be found!");
    }

    public int removeBookByRegNumber(int regNumber){
        return 0;
    }
    public Set<Book> selectBooksByAuthor(String author) {
        return null;
    }
}
