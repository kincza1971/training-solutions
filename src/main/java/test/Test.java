package test;

import attributes.book.Book;

import java.io.IOException;
import java.text.Collator;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Test {
    public static void main(String[] args) throws IOException {
        List<String> strings = new ArrayList<>();
        List<Book> books = new ArrayList<>();
        strings.sort((s1, s2) -> Collator.getInstance().compare(s1, s2));
        books.sort((b1, b2) -> Collator.getInstance(new Locale("hu", "HU")).compare(b2.getTitle(), b2.getTitle()));
        books.stream().map(Book::getTitle);
    }
}