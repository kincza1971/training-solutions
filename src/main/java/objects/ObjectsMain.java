package objects;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ObjectsMain {
    public static void main(String[] args) {
        new Book();
        System.out.println(new Book());
        Book emptyBook = null;
        System.out.println(emptyBook);
        Book book = new Book();
        System.out.println(book);
        book = null;
        System.out.println(book);
        book = new Book();
        System.out.println(book);
        Book anotherBook = new Book();
        System.out.println(book==anotherBook ? "egyenlő" : "nem egyenlő");
        anotherBook = book;
        System.out.println(book==anotherBook ? "egyenlő" : "nem egyenlő");

        System.out.println(anotherBook instanceof Book);

        Book[] books = {new Book(), new Book(), new Book()};
        List<Book> bookList = Arrays.asList(new Book(), new Book(), new Book());
        List<Book> bookList2 = new ArrayList<>();

        anotherBook = new Book();
        Book otherBook = new Book();

        bookList2.addAll(Arrays.asList(book, anotherBook, otherBook));

    }
}
