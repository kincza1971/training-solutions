package iofiletest;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books = new ArrayList<>();

    public void add(Book bookToAdd) {
        for (Book book : books) {
            if (book.equals(bookToAdd.getBookData())) {
                throw new IllegalArgumentException("Book already exists");
            }
        }
        books.add(bookToAdd);
    }
}
