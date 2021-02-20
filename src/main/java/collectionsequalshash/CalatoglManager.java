package collectionsequalshash;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CalatoglManager {

    public Book findBookByTitleAuthor(List<Book> books, String title, String author) {
        for (Book book : books) {
            if (book.getTitle().equals(title) && book.getAuthor().equals(author)) {
                return book;
            }
        }
        throw new IllegalArgumentException("Book not found");
    }

    public Book findBook(List<Book> books, Book book) {
        for (Book aBook : books) {
            if (aBook.equals(book)) {
                return aBook;
            }
        }
        throw new IllegalArgumentException("Book not found");
    }

    public Set<Book> addBooksToSet(Book[] books) {
        Set<Book> bookSet = new HashSet<>();
        bookSet.addAll(Arrays.asList(books));
        return bookSet;
    }
}
